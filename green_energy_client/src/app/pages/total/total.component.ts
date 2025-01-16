import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Observable, Subscription } from 'rxjs';
import { Total } from 'src/app/models/total.model';
import { TotalService } from 'src/app/services/total.service';

@Component({
  selector: 'app-total',
  templateUrl: './total.component.html',
  styleUrls: ['./total.component.scss']
})
export class TotalComponent implements OnInit {
  public totals: Total[] = [];
  public totalCons: number = 0;
  public totalProd: number = 0;
  getTotals: Subscription = new Subscription;
  public selectedYear: number;
  public form: FormGroup;
  @Output() updatedYear = new EventEmitter<string>();

  constructor(private totalService: TotalService) { 
    this.form = new FormGroup({
      selectedYear: new FormControl('')
  });
  this.selectedYear=2021;
  }

  ngOnInit(): void {
    this.getTotals = this.totalService.getAllTotal().subscribe((totals) => this.totals = totals);
  }

  ngOnChange(): void {
    this.updateTotal();
  }

  updateTotal(): void {
    this.selectedYear = this.form.get('selectedYear')?.value;
    this.updatedYear.emit(this.selectedYear.toString())
    this.totals.forEach((total) => {
      if (total.referencedYear == this.selectedYear) {
        this.totalProd = total.totalProd;
        this.totalCons = total.totalConsum;
      }
    })

  }
}
