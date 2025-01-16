import { Injectable } from '@angular/core';
import { UrlConstants } from '../constants/url-constants.constants';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Total } from '../models/total.model';

@Injectable({
  providedIn: 'root'
})
export class TotalService{

 private apiUrl = UrlConstants.apiUrl + '/total'
 
   constructor(private http: HttpClient) { }
 
   getAllTotal(): Observable<Total[]> {
     return this.http.get<Total[]>(this.apiUrl);
   }
   
   createGreenEnergy(greenEnergy: Total):
      Observable<Total>{
     return this.http.post<Total>(this.apiUrl,Total);
   }
   
   updateGreenEnergy(id: number, greenEnergy: Total): 
     Observable<Total>{
     return this.http.put<Total>(`${this.apiUrl}/${id}`, greenEnergy);
   }
 
   deleteGreenEnergy(id: number): Observable<void> {
     return this.http.delete<void>(`${this.apiUrl}/${id}`);
   }
 
 
}
