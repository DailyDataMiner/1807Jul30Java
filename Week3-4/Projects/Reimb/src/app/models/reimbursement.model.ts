import { Timestamp } from "rxjs";

export class Reimbursement {
    id: number;
    amount: number;
    submitted: Date;
    resolved: Date;
    description: string;
    receipt?: Blob;
    sauthor: any;
    sresolver: any;
    sstatusid: any;
    stypeid: any;
}