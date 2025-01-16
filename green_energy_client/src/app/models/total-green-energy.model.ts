import { GreenEnergy } from "./green-energy.model";
import { Total } from "./total.model";

export class TotalGreenEnergy {
    greenEnergyID:number;
    referencedYearID:number;
    greenEnergy:GreenEnergy;
    referencedYear:Total;
    
    
    constructor(
        greenEnergyID:number,
        referencedYearID:number,
        greenEnergy:GreenEnergy,
        referencedYear:Total
    )
    {
        this.greenEnergyID=greenEnergyID;
        this.referencedYearID=referencedYearID;
        this.greenEnergy=greenEnergy;
        this.referencedYear=referencedYear;
    }
}
