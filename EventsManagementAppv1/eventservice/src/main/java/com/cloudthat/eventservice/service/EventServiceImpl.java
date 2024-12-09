package com.cloudthat.eventservice.service;

import com.cloudthat.eventservice.entity.Category;
import com.cloudthat.eventservice.entity.Event;
import com.cloudthat.eventservice.exception.ResourceNotFoundException;
import com.cloudthat.eventservice.external.client.VenueAvailabilityModel;
import com.cloudthat.eventservice.external.client.VenueModel;
import com.cloudthat.eventservice.external.client.VenueService;
import com.cloudthat.eventservice.model.ApiResponse;
import com.cloudthat.eventservice.model.EventModel;
import com.cloudthat.eventservice.model.EventResponse;
import com.cloudthat.eventservice.repository.CategoryRepository;
import com.cloudthat.eventservice.repository.EventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    VenueService venueService;


    @Autowired
    RestTemplate restTemplate;

    @Override
    public EventModel createEvent(EventModel eventModel) {
        Event savedEvent = eventRepository.save(eventModelToEvent(eventModel));
        VenueAvailabilityModel venueAvailabilityModel = new VenueAvailabilityModel();
        venueAvailabilityModel.setVenueId(eventModel.getVenueId());
        venueAvailabilityModel.setStartDateTime(eventModel.getStartDateTime());
        venueAvailabilityModel.setEndDateTime(eventModel.getEndDateTime());
        venueService.bookVenue(eventModel.getVenueId(),venueAvailabilityModel);
        return eventToEventModel(savedEvent);
    }

    @Override
    public EventModel getEvent(Long eventId) {
        return eventRepository.findById(eventId)
                .map(this::eventToEventModel)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "ID", eventId));
    }

    @Override
    public List<EventModel> getAllEvents() {
        List<Event> eventList = eventRepository.findAll();
        return eventList.stream()
                .map(this::eventToEventModel).toList();
    }

    @Override
    public EventModel updateEvent(Long eventId, EventModel eventModel) {
        Event eventDB = eventRepository.findById(eventId).get();

        if(Objects.nonNull(eventModel.getName()) && !("".equalsIgnoreCase(eventModel.getName()))){
            eventDB.setName(eventModel.getName());
        }

        if(Objects.nonNull(eventModel.getDescription()) && !("".equalsIgnoreCase(eventModel.getDescription()))){
            eventDB.setDescription(eventModel.getDescription());
        }

        if(Objects.nonNull(eventModel.getVenueId())){
            eventDB.setVenueId(eventModel.getVenueId());
        }

        if(Objects.nonNull(eventModel.getOrganizerId())){
            eventDB.setOrganizerId(eventModel.getOrganizerId());
        }

        eventRepository.save(eventDB);

        return eventToEventModel(eventDB);
    }

    @Override
    public String deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        eventRepository.deleteById(eventId);
//        event.setIsDeleted(true);
//        eventRepository.save(event);
        return "Event with id "+ eventId + " deleted successfully";
    }

    @Override
    public EventResponse getEventDetails(Long eventId) {
        Event event = eventRepository.findById(eventId).get();

        EventResponse eventResponse = new EventResponse();
        eventResponse.setId(event.getId());
        eventResponse.setName(event.getName());
        eventResponse.setDescription(event.getDescription());
        eventResponse.setEventStatus(event.getEventStatus());

        Long venueId = event.getVenueId();

        ApiResponse apiResponse = restTemplate.getForObject("http://VENUE-SERVICE/api/venues/"+venueId, ApiResponse.class);

        ObjectMapper objectMapper = new ObjectMapper();
        VenueModel venueModel = objectMapper.convertValue(apiResponse.getData(),VenueModel.class);
        eventResponse.setVenue(venueModel);

        eventResponse.setOrganizerId(event.getOrganizerId());

        return eventResponse;
    }


    protected Event eventModelToEvent(EventModel eventModel){
        Event event = new Event();
        event.setId(eventModel.getId());
        event.setName(eventModel.getName());
        event.setDescription(eventModel.getDescription());
        event.setVenueId(eventModel.getVenueId());
        event.setOrganizerId(eventModel.getOrganizerId());
        event.setEventStatus(eventModel.getEventStatus());
//        event.setCategories(eventModel.getCategories());
        event.setStartDateTime(eventModel.getStartDateTime());
        event.setEndDateTime(eventModel.getEndDateTime());

        return event;
    }

    protected EventModel eventToEventModel(Event event){

        EventModel eventModel = new EventModel();
        eventModel.setId(event.getId());
        eventModel.setName(event.getName());
        eventModel.setDescription(event.getDescription());
        eventModel.setVenueId(event.getVenueId());
        eventModel.setOrganizerId(event.getOrganizerId());
        eventModel.setEventStatus(event.getEventStatus());
//        eventModel.setCategories(event.getCategories());
        eventModel.setStartDateTime(event.getStartDateTime());
        eventModel.setEndDateTime(event.getEndDateTime());

        return eventModel;
    }
}
