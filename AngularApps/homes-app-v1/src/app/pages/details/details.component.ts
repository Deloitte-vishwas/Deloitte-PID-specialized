import { CommonModule, TitleCasePipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { HousingService } from '../../services/housing.service';
import { HousingLocation } from '../../interfaces/housing-location';
import { FormControl, FormGroup, ReactiveFormsModule} from '@angular/forms';

@Component({
  selector: 'app-details',
  imports: [CommonModule, ReactiveFormsModule, RouterLink, TitleCasePipe],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent {
  housingService: HousingService = inject(HousingService);
  route: ActivatedRoute = inject(ActivatedRoute);
  // housingLocationId = 0;
  housingLocation: HousingLocation | undefined;
  showAlert = false;
  currentDate: Date = new Date();

  applyForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl('')
  });

  constructor(){
    // this.housingLocationId = Number(this.route.snapshot.params['id']);
    const housingLocationId = Number(this.route.snapshot.params['id']);
    this.housingLocation = this.housingService.getHousingLocationById(housingLocationId);

  }
  submitApplication(){
    this.housingService.submitApplication(
      this.applyForm.value.firstName ?? '',
      this.applyForm.value.lastName ?? '',
      this.applyForm.value.email ?? ''
    );

    this.showAlert = true;
    setTimeout(()=>{
      this.showAlert = false;
    }, 3000);
  }



}
