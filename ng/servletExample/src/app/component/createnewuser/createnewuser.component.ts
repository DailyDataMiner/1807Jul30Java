import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/user.model';
import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-createnewuser',
  templateUrl: './createnewuser.component.html',
  styleUrls: ['./createnewuser.component.css']
})
export class CreatenewuserComponent implements OnInit {

  private username: string;
  private password: string;
  private firstname: string;
  private lastname: string;
  private email: string;
  show = false;
  hidden = false;

  // user: User;

  constructor(
    private authService: AuthService,
    private route: RouterModule,
    private router: Router
  ) { }

  ngOnInit() {
  }

  createNewUser() {
    if (this.username == null || this.password == null || this.firstname == null || this.lastname == null || this.email == null) {
      alert('please enter in something.');
    } else {
      this.hidden = !this.hidden;
      this.show = !this.show;

      this.authService.createNewUser(this.username, this.password,
        this.firstname, this.lastname, this.email).subscribe(
          data => {
            console.log(data)

            this.authService.isLoggedIn = true; // JUST IN CASE
            this.router.navigate(['userinfo']);
          }
        )

    }

  }

  goBack() {
    this.authService.isLoggedIn = true;
    this.router.navigate(['userinfo']);
  }



}
