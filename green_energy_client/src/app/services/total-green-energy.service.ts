import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlConstants } from '../constants/url-constants.constants';
import { TotalGreenEnergy } from '../models/total-green-energy.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TotalGreenEnergyService {

 private apiUrl = UrlConstants.apiUrl + '/total-green-energy'

  constructor(private http: HttpClient) { }

  getAllTotalGreenEnergy(): Observable<TotalGreenEnergy[]> {
    return this.http.get<TotalGreenEnergy[]>(this.apiUrl);
  }
  
  createTotalGreenEnergy(totalgreenEnergy: TotalGreenEnergy):
     Observable<TotalGreenEnergy>{
    return this.http.post<TotalGreenEnergy>(this.apiUrl,TotalGreenEnergy);
  }
  
  updateTotalGreenEnergy(id: number, totalgreenEnergy: TotalGreenEnergy): 
    Observable<TotalGreenEnergy>{
    return this.http.put<TotalGreenEnergy>(`${this.apiUrl}/${id}`, totalgreenEnergy);
  }

  deleteTotalGreenEnergy(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
