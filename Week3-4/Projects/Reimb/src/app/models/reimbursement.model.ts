import { Timestamp } from "rxjs";

export class Reimbursement {
    id: number;
    amount: number;
    submitted: Date;
    resolved: Date;
    description: string;
    receipt: Blob;
    author: any;
    resolver: any;
    statusid: any;
    typeid: any;
}