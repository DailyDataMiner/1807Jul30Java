export class User {

    id: number;
    username: string;
    firstname: string;
    lastname: string;
    email: string;
    role: string;

    constructor (toInput: [number, string, string, string, string, string]) {
        this.id = toInput[0];
        this.username = toInput[1];
        this.firstname = toInput[2];
        this.lastname = toInput[3];
        this.email = toInput[4];
        this.role = toInput[5];
        console.log(this.id);
      }
      getUserID():number {
          return this.id;
      }

}