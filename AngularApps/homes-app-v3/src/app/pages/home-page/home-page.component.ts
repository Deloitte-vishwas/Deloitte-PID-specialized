import { Component, inject } from '@angular/core';
import { HousingLocationComponent } from '../../components/housing-location/housing-location.component';
import { HousingLocation } from '../../interfaces/housing-location';
import { AsyncPipe, CommonModule } from '@angular/common';
import { HousingService } from '../../services/housing.service';
import { FormsModule } from '@angular/forms';
import { map, Observable } from 'rxjs';

@Component({
  selector: 'app-home-page',
  imports: [CommonModule, HousingLocationComponent, FormsModule, AsyncPipe],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {
  housingService: HousingService = inject(HousingService);
  housingLocations$!: Observable<HousingLocation[]>;
  filteredLocations: HousingLocation[] = [];
  inputValue: string = '';

   ngOnInit(){
    this.housingLocations$ = this.housingService.getAllHousingLocations();
        // Subscribe to the Observable and update filteredLocations
        this.housingLocations$.subscribe(locations => {
          this.filteredLocations = locations;
        });
   }

   filterResults(text: string){
    if (!text) {
      this.housingLocations$ = this.housingService.getAllHousingLocations();
      return;
    }
  
    this.housingLocations$ = this.housingService.getAllHousingLocations().pipe(
      map(locations => locations.filter(location => location.city.toLowerCase().includes(text.toLowerCase())))
    );
   }

   clearInput(){
    this.inputValue = '';
    this.housingLocations$ = this.housingService.getAllHousingLocations();
   }

   isResultsEmpty(): Boolean{
    return this.filteredLocations.length === 0;
   }

}
