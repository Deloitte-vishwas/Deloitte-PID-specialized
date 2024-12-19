import { Injectable } from '@angular/core';
import { HousingLocation } from '../interfaces/housing-location';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HousingService {
  url = 'http://localhost:3000/locations';

  constructor(private http: HttpClient) { }

  getAllHousingLocations(): Observable<HousingLocation[]> {
    return this.http.get<HousingLocation[]>(this.url);
  }

  getHousingLocationById(id: number): Observable<HousingLocation | undefined> {
    return this.http.get<HousingLocation>(`${this.url}/${id}`);
  }

  submitApplication(firstName: string, lastName: string, email: string){
    console.log(`${firstName} ${lastName} with the emailid ${email} submitted an application`);
    
  }

}
