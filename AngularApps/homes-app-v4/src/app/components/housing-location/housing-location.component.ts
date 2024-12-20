import { Component, Input } from '@angular/core';
import { HousingLocation } from '../../interfaces/housing-location';
import { RouterLink } from '@angular/router';
import { TitleCasePipe } from '@angular/common';

@Component({
  selector: 'app-housing-location',
  imports: [RouterLink, TitleCasePipe],
  templateUrl: './housing-location.component.html',
  styleUrl: './housing-location.component.css'
})
export class HousingLocationComponent {
  @Input() housingLocation!: HousingLocation;
}
