import { Component, OnInit } from '@angular/core';
import { ThemeService } from '../theme/theme.service';
import { User } from '../model';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  rightColumn: [{ label: string, binding: string, required: boolean }];
  leftColumn: [{ label: string, binding: string, required: boolean }];
  user: User;

  constructor(public theme: ThemeService, private loginService: LoginService) { }

  ngOnInit() {

    this.rightColumn = rightColumn;
    this.leftColumn = leftColumn;
    if(this.loginService.logged) this.user = this.loginService.user;
    else this.user = {};
  }

  register() {

    this.loginService.register(this.user);
  }

  logout() {

    this.loginService.logout();
  }

}

const leftColumn: [{ label: string, binding: string, required: boolean }] = [
  { label : 'Email', binding : 'email', required : true },
  { label : 'Password', binding : 'password', required : true },
  { label : 'First Name', binding : 'firstName', required : true },
  { label : 'Last Name', binding : 'lastName', required : true },
  { label : 'Phone', binding : 'mobile', required : false },
];

const rightColumn: [{ label: string, binding: string, required: boolean }] = [
  { label : 'Bank account', binding : 'bankAccount', required : false },
  { label : 'Part', binding : 'part', required : false },
  { label : 'Group', binding : 'group', required : false },
  { label : 'Team', binding : 'team', required : false },
  { label : 'Floor', binding : 'floor', required : false }
];
