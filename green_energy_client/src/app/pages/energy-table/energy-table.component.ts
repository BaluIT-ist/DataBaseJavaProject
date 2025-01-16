import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { subscribeOn, Subscription } from 'rxjs';
import { EnergyTable } from 'src/app/models/energy-table.model';
import { GreenEnergySource } from 'src/app/models/enums/green-energy-source.enum';
import { RomanianCounty } from 'src/app/models/enums/romanian-county.enum';
import { GreenEnergy } from 'src/app/models/green-energy.model';
import { MainType } from 'src/app/models/main-type.model';
import { TotalGreenEnergy } from 'src/app/models/total-green-energy.model';
import { GreenEnergyService } from 'src/app/services/green-energy.service';
import { MainTypeService } from 'src/app/services/main-type.service';
import { TotalGreenEnergyService } from 'src/app/services/total-green-energy.service';

@Component({
  selector: 'app-energy-table',
  templateUrl: './energy-table.component.html',
  styleUrls: ['./energy-table.component.scss']
})
export class EnergyTableComponent implements OnChanges {
  public rows: EnergyTable[] = [];
  public greenEnergies: GreenEnergy[] = [];
  getGreenEnergyTable: Subscription = new Subscription;
  @Input() inputFromTotalComponent: number = 0;

  public mainType: MainType[] = [];
  getMainTypeTable: Subscription = new Subscription;

  public totalGreenEnergies: TotalGreenEnergy[] = [];
  getTotalGreenEnergyTable: Subscription = new Subscription;


  constructor(private greenEnergyService: GreenEnergyService, private mainTypeService: MainTypeService, private totalGreenEnergyService: TotalGreenEnergyService) { }
  ngOnChanges(changes: SimpleChanges): void {
    this.ngOnInit();
  }

  ngOnInit(): void {
    this.rows = [];
    this.getGreenEnergyTable = this.greenEnergyService.getAllGreenEnergy().subscribe((greenEnergies) => this.greenEnergies = greenEnergies);

    this.getMainTypeTable = this.mainTypeService.getAllMainType().subscribe((mainType) => this.mainType = mainType);

    this.getTotalGreenEnergyTable = this.totalGreenEnergyService.getAllTotalGreenEnergy().subscribe((totalGreenEnergies) => this.totalGreenEnergies = totalGreenEnergies);

    var index = 1;
    for (let totalGreenEnergy of this.totalGreenEnergies) {
      if (totalGreenEnergy.referencedYear.referencedYear == this.inputFromTotalComponent) {
        var row = new EnergyTable(
          index,
          totalGreenEnergy.greenEnergy.consum,
          totalGreenEnergy.greenEnergy.prod,
          this.getCountyName(totalGreenEnergy.greenEnergy.county),
          this.getMainTypeID(totalGreenEnergy.greenEnergy.mainTypeID.mainType)
        );
        this.rows.push(row);
        index++;
      }
    }

  }

  getCountyName(countyNumber: number): string {
    const countyName: string | undefined = RomanianCounty[countyNumber];

    if (countyName) {
      return countyName;
    } else {
      return "Unknown County";
    }
  }
  getMainTypeID(mainTypeIDnumber: number): string {
    const mainTypeID: string | undefined = GreenEnergySource[mainTypeIDnumber];

    if (mainTypeID) {
      return mainTypeID;
    } else {
      return "Unknown MainType";
    }
  }



}
