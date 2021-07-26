import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  showLogin: boolean;

  constructor(
    private router: Router,
    private userService: UserService
  ) {
    this.showLogin = true;
    this.user = new User();
  }

  ngOnInit(): void {
  }

  setShowlogin(showLogin: boolean): void {
    this.showLogin = showLogin;
  }

  async onSubmit() {
    const fetchedUser = await this.userService.findUser(this.user).toPromise();
    console.log(fetchedUser);
    if (fetchedUser.password === this.user.password) {
      this.showLogin = false;
      this.router.navigate(['../user-blog']);
      sessionStorage.setItem('userId', String(fetchedUser.id));
    }
  }

}
