import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnergyTableComponent } from './energy-table.component';

describe('EnergyTableComponent', () => {
  let component: EnergyTableComponent;
  let fixture: ComponentFixture<EnergyTableComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EnergyTableComponent]
    });
    fixture = TestBed.createComponent(EnergyTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
