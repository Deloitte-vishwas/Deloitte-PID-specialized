import { Component, inject } from '@angular/core';
import { HousingLocationComponent } from '../../components/housing-location/housing-location.component';
import { HousingLocation } from '../../interfaces/housing-location';
import { CommonModule } from '@angular/common';
import { HousingService } from '../../services/housing.service';

@Component({
  selector: 'app-home-page',
  imports: [CommonModule, HousingLocationComponent],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {
  housingService: HousingService = inject(HousingService);
  housingLocations: HousingLocation[] = [];
  filteredLocations: HousingLocation[] = [];

   constructor(){
    this.housingLocations = this.housingService.getAllHousingLocations();
    this.filteredLocations = this.housingLocations;
   }

   filterResults(text: string){
    if(!text){
      this.filteredLocations = this.housingLocations;
      return;
    }

    this.filteredLocations = this.housingLocations.filter((housingLocation) => housingLocation?.city.toLowerCase().includes(text.toLowerCase()));
   }
}
