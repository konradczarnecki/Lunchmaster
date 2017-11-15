import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { WallModule } from './wall/wall.module';
import { AppComponent } from './app.component';
import { TopbarComponent } from './topbar/topbar.component';
import { WallComponent } from './wall/wall.component';
import { ThemeService } from './theme/theme.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

const routes: Routes = [
  { path : '', redirectTo : '/wall', pathMatch : 'full'},
  { path : 'wall', component: WallComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    TopbarComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    WallModule,
    HttpModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule
  ],
  providers: [ ThemeService ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
