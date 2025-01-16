import { Injectable } from '@angular/core';
import { UrlConstants } from '../constants/url-constants.constants';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GreenEnergy } from '../models/green-energy.model';

@Injectable({
  providedIn: 'root'
})
export class GreenEnergyService {

  private apiUrl = UrlConstants.apiUrl + '/green-energy'

  constructor(private http: HttpClient) { }

  getAllGreenEnergy(): Observable<GreenEnergy[]> {
    return this.http.get<GreenEnergy[]>(this.apiUrl);
  }
  
  createGreenEnergy(greenEnergy: GreenEnergy):
     Observable<GreenEnergy>{
    return this.http.post<GreenEnergy>(this.apiUrl,GreenEnergy);
  }
  
  updateGreenEnergy(id: number, greenEnergy: GreenEnergy): 
    Observable<GreenEnergy>{
    return this.http.put<GreenEnergy>(`${this.apiUrl}/${id}`, greenEnergy);
  }

  deleteGreenEnergy(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }


}
