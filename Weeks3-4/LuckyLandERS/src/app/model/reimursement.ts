export class Reimbursement {

    reimbID: number;
    amount: number;
    submitted: Date;
    resolved: Date;
    description: string;
    receipt: ByteString;
    author: number;
    resolver: number;
    statusID: number;
    typeID:  number;

}