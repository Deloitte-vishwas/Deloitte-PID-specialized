# Event Management Application

An Event Management App is built using spring boot following the below reference(actual implementations may differ 5%):

The Modules for the App may be as below

![](./images/modules.png)

The Entities & their relations in each service

![](./images/entities-light.png)

The approximate stucture of the App be:

![](./images/arch.png)

## Lab Sessions breakup
### Day 1: 4th Dec 2024 ( Spring & spring boot referesher)
- Designing Modules, Entities, Backend Endpoints for Event Management App
- Lab : Hello, Spring Boot!
- Lab: Spring Boot Configuration
  - Injecting values from app.props & app.yml
  - Passing sensitive information from environment variables
  - Passing values through command line in spring boot app
- Lab: Swapping Embedded Server

### Day 2: 5th Dec 2024
- Lab 1: Creating Service Registry for EventsManagementApp
- Lab 2: Creating Event Service & adding as eureka client
- Lab 3: Event Service creation (CRUD) & testing in post man
### Day 3: 6th Dec 2024
- Lab 4: Creating Venue Service
- Lab 5: Externalizing Configuration using config server
- Lab 6: Open Feign Client Communication, submit interface screenshot