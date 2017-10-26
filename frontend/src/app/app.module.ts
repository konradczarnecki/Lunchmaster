import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';

import { WallModule } from './wall/wall.module';

import { AppComponent } from './app.component';
import { TopbarComponent } from './topbar/topbar.component';
import { LunchListComponent } from './wall/lunch-list/lunch-list.component';
import { AddMinutesPipe } from './add-minutes.pipe';

export const routes: Routes = [
  { path : '', component : LunchListComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    TopbarComponent,
    // AddMinutesPipe
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpModule,
    WallModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
