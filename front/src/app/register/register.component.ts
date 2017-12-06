import { Component, OnInit } from '@angular/core';
import { ThemeService } from '../theme/theme.service';
import { User } from '../model';
import { LoginService } from '../login/login.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  fields: [{ label: string, binding: string, required: boolean }];
  user: User;

  constructor(public theme: ThemeService, private loginService: LoginService) { }

  ngOnInit() {

    this.fields = fields;
    this.user = {};
  }

  submit() {

    this.loginService.register(this.user);
  }

}

const fields: [{ label: string, binding: string, required: boolean }] = [
  { label : 'Email', binding : 'email', required : true },
  { label : 'Password', binding : 'password', required : true },
  { label : 'First Name', binding : 'firstName', required : true },
  { label : 'Last Name', binding : 'lastName', required : true },
  { label : 'Phone', binding : 'mobile', required : false },
  { label : 'Bank account', binding : 'bankAccount', required : false },
  { label : 'Part', binding : 'part', required : false },
  { label : 'Group', binding : 'group', required : false },
  { label : 'Team', binding : 'team', required : false },
  { label : 'Floor', binding : 'floor', required : false }
];
