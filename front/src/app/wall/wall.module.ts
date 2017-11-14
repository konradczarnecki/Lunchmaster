import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WallComponent } from './wall.component';
import { TileComponent } from './tile/tile.component';
import { WallService } from './service/wall.service';
import { DetailsComponent } from './details/details.component';


@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [WallComponent, TileComponent, DetailsComponent],
  providers: [ WallService ]
})
export class WallModule { }
