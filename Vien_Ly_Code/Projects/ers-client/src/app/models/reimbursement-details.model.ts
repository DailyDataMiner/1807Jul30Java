import { ReimbursementStatus } from './reimbursement-status.enum';
import { ReimbursementType } from './reimbursement-type.enum';

export class ReimbursementDetails {
    id: number;
    amount: number;
    submittedTime: Date;
    resolvedTime?: Date;
    description?: string;
    authorUsername: string;
    authorFirstName: string;
    authorLastName: string;
    resolverUsername?: string;
    resolverFirstName?: string;
    resolverLastName?: string;
    status: ReimbursementStatus;
    type: ReimbursementType;
}
