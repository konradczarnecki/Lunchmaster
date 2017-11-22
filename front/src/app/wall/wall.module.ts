import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { WallComponent } from './wall.component';
import { TileComponent } from './tile/tile.component';
import { WallService } from './service/wall.service';
import { DetailsComponent } from './details/details.component';
import { NewLunchComponent } from './new-lunch/new-lunch.component';


@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  declarations: [ WallComponent, TileComponent, DetailsComponent, NewLunchComponent ],
  providers: [ WallService ]
})
export class WallModule { }
