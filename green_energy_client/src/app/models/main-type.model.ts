import { GreenEnergySource } from "./enums/green-energy-source.enum";

export class MainType {
    mainType:GreenEnergySource;
    mainTypeID:number;

    constructor(
        mainType:GreenEnergySource,
        mainTypeID:number
    )
    {
        this.mainType=mainType;
        this.mainTypeID=mainTypeID;
    }
}
