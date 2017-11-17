import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';

import { WallModule } from './wall/wall.module';
import { AppComponent } from './app.component';
import { TopbarComponent } from './topbar/topbar.component';
import { WallComponent } from './wall/wall.component';
import { ThemeService } from './theme/theme.service';
import { LoginService } from './login/login.service';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path : '', redirectTo : '/wall', pathMatch : 'full'},
  { path : 'wall', component: WallComponent },
  { path : 'login', component: LoginComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    TopbarComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    WallModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule
  ],
  providers: [ ThemeService, LoginService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
