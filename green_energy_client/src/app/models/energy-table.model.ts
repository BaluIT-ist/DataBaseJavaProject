import { GreenEnergySource } from "./enums/green-energy-source.enum";

export class EnergyTable {
    index: number;
    consum: number;
    prod: number;
    county: string;
    mainType: string;

    constructor(
        index: number,
        consum: number,
        prod: number,
        county: string,
        mainType: string
    ) {
        this.index = index;
        this.consum = consum;
        this.prod = prod;
        this.county = county;
        this.mainType = mainType;
    }

}