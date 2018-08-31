import { ReimbursementStatus } from './reimbursement-status.enum';
import { ReimbursementType } from './reimbursement-type.enum';

export class Reimbursement {
    id: number;
    amount: number;
    submittedTime: Date;
    resolvedTime?: Date;
    description?: string;
    authorId: number;
    resolverId?: number;
    status: ReimbursementStatus;
    type: ReimbursementType;
}
