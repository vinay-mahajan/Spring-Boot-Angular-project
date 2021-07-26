import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User;
  login: boolean;

  constructor(private route: ActivatedRoute, 
    private router: Router, 
    private userService: UserService) {
      this.user = new User();
      this.login = false;
     }

  ngOnInit(): void {
  }

  setLogin(login: boolean): void {
    this.login = login;
  }

  onSubmit() {
    console.log(this.user);
    this.userService.saveUser(this.user);
    this.login = true;
    this.router.navigate(['../login']);
  }

}
