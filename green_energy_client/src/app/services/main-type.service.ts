import { Injectable } from '@angular/core';
import { UrlConstants } from '../constants/url-constants.constants';
import { HttpClient } from '@angular/common/http';
import { MainType } from '../models/main-type.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MainTypeService{

private apiUrl = UrlConstants.apiUrl + '/main-type'

  constructor(private http: HttpClient) { }

  getAllMainType(): Observable<MainType[]> {
    return this.http.get<MainType[]>(this.apiUrl);
  }
  
  createMainType(maintype: MainType):
     Observable<MainType>{
    return this.http.post<MainType>(this.apiUrl,MainType);
  }
  
  updateMainType(id: number, maintype: MainType): 
    Observable<MainType>{
    return this.http.put<MainType>(`${this.apiUrl}/${id}`, maintype);
  }

  deleteGMainType(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
