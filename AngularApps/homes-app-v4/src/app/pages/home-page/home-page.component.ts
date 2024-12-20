import { Component, inject } from '@angular/core';
import { HousingLocationComponent } from '../../components/housing-location/housing-location.component';
import { HousingLocation } from '../../interfaces/housing-location';
import { CommonModule } from '@angular/common';
import { HousingService } from '../../services/housing.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home-page',
  imports: [CommonModule, HousingLocationComponent, FormsModule],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})
export class HomePageComponent {
  housingService: HousingService = inject(HousingService);
  housingLocations: HousingLocation[] = [];
  filteredLocations: HousingLocation[] = [];
  inputValue: string = '';


  currentPage: number = 1;
  itemsPerPage: number = 3;
  totalPages: number = 1;

   constructor(){
    this.housingService.getAllHousingLocations().then((housingLocations: HousingLocation[])=>{
      this.housingLocations = housingLocations;
      this.filteredLocations = housingLocations;
      this.totalPages = Math.ceil(this.filteredLocations.length/this.itemsPerPage);
    })
   }

   filterResults(text: string){
    if(!text){
      this.filteredLocations = this.housingLocations;
      return;
    }

    this.filteredLocations = this.housingLocations.filter((housingLocation) => housingLocation?.city.toLowerCase().includes(text.toLowerCase()));
   }

   clearInput(){
    this.inputValue = '';
    this.filteredLocations = this.housingLocations;
   }

   isResultsEmpty(): Boolean{
    return this.filteredLocations.length === 0;
   }

   // Pagination Methods
   get paginatedHomes(){
    const startIndex = (this.currentPage -1) * this.itemsPerPage;
    const endIndex = startIndex + this.itemsPerPage;
    return this.housingLocations.slice(startIndex, endIndex);
   }

   prevPage(){
    if(this.currentPage > 1){
      this.currentPage--;
    }
   }

   nextPage(){
    if(this.currentPage < this.totalPages){
      this.currentPage++;
    }
   }

   goToPage(page: number){
    this.currentPage = page;
   }

}
