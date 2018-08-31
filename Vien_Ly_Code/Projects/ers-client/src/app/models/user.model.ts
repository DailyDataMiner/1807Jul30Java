import { UserRole } from './user-role.enum';

export class User {
    id: number;
    username: string;
    firstName: string;
    lastName: string;
    email: string;
    role: UserRole;
}
