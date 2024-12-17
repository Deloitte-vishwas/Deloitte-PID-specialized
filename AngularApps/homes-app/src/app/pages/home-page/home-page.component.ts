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

   constructor(){
    this.housingLocations = this.housingService.getAllHousingLocations();
   }
}
