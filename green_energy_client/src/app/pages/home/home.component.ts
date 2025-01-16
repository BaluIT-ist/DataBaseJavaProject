import { Component, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  public selectedYear: number;

  constructor() { 
    this.selectedYear=2021;
    }

    getData(year:String): void {
      var aux: number;
      aux=+year;

        this.selectedYear=aux;
    }
  

}
