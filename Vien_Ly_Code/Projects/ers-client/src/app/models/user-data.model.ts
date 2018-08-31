import { UserRole } from './user-role.enum';

export class UserData {
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    email: string;
    role: UserRole;
}
