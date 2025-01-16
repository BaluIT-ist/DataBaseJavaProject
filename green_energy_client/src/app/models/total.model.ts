export class Total {

    public totalProd:number;
    public totalConsum:number;
    public referencedYear:number;

    constructor(
        totalProd:number,
        totalConsum:number,
        referencedYear:number
    )
    {
        this.totalProd=totalProd;
        this.totalConsum=totalConsum;
        this.referencedYear=referencedYear;
    }
}
