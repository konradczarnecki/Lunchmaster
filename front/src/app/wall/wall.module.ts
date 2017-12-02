import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { WallComponent } from './wall.component';
import { TileComponent } from './tile/tile.component';
import { WallService } from './service/wall.service';
import { DetailsComponent } from './details/details.component';
import { EditLunchComponent } from './edit-lunch/edit-lunch.component';
import { ListComponent } from './list/list.component';


@NgModule({
  imports: [
    CommonModule,
    FormsModule
  ],
  declarations: [ WallComponent, TileComponent, DetailsComponent, EditLunchComponent, ListComponent ],
  providers: [ WallService ]
})
export class WallModule { }
