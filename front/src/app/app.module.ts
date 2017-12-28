import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule, Routes } from '@angular/router';
import { MatCommonModule, MatButtonModule } from '@angular/material';
import { WallModule } from './wall/wall.module';
import { AppComponent } from './app.component';
import { TopbarComponent } from './topbar/topbar.component';
import { WallComponent } from './wall/wall.component';
import { ThemeService } from './theme/theme.service';
import { LoginService } from './login/login.service';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RestaurantsComponent } from './restaurant/restaurants.component';
import { RestaurantModule } from './restaurant/restaurant.module';
import { RegisterComponent } from './register/register.component';
import { BillingComponent } from './billing/billing.component';
import { BillingModule } from './billing/billing.module';

const routes: Routes = [
  { path : '', redirectTo : '/login', pathMatch : 'full'},
  { path : 'wall', component : WallComponent, canActivate : [LoginService] },
  { path : 'profile', component : RegisterComponent, canActivate : [LoginService] },
  { path : 'restaurants', component : RestaurantsComponent, canActivate : [LoginService]},
  { path : 'billing', component : BillingComponent, canActivate : [LoginService]},
  { path : 'login', component : LoginComponent },
  { path : 'register', component : RegisterComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    TopbarComponent,
    LoginComponent,
    ProfileComponent,
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    WallModule,
    RestaurantModule,
    BillingModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule,
    MatCommonModule,
    MatButtonModule
  ],
  providers: [ ThemeService, LoginService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
