export class Reimb {

    id: number;
    amount: number;
    submitted: Date;
    resolved: Date;
    desc: string;
    receipt: string;
    author: string;
    resolver: string;
    status: string;
    type: string;

    constructor (toInput: [number, number, Date, Date, string, string, string, string, string, string]) {
        this.id = toInput[0];
        this.amount = toInput[1];
        this.submitted = toInput[2];
        this.resolved = toInput[3];
        this.desc = toInput[4];
        this.receipt = toInput[5];
        this.author = toInput[6];
        this.resolver = toInput[7];
        this.status = toInput[8];
        this.type = toInput[9];
        console.log(this.author);
      }
      getUserID():number {
          return this.id;
      }

}