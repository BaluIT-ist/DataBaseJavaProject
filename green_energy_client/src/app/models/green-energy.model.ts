import { RomanianCounty } from "./enums/romanian-county.enum";
import { MainType } from "./main-type.model";

export class GreenEnergy {
    GreenEnergySource(GreenEnergySource: any): any {
      throw new Error('Method not implemented.');
    }
    id:number;
    mainTypeID:MainType;
    consum:number;
    prod:number;
    county:RomanianCounty;

    constructor(
        id:number,
        mainTypeID:MainType,
        consum:number,
        prod:number,
        county:RomanianCounty
    )
    {
        this.id=id;
        this.mainTypeID=mainTypeID;
        this.consum=consum;
        this.prod=prod;
        this.county=county;
    }
    
}
