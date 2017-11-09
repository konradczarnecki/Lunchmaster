import { ChangeDetectorRef, Component, OnInit} from '@angular/core';

import { WallService } from './service/wall.service';
import { ThemeService} from "../theme/theme.service";
import { Lunch } from '../model';

@Component({
  selector: 'app-wall',
  templateUrl: './wall.component.html',
  styleUrls: ['./wall.component.scss']
})
export class WallComponent implements OnInit {

  lunches: Lunch[];

  constructor(private service: WallService,
              private changeDet: ChangeDetectorRef,
              private theme: ThemeService) { }

  ngOnInit() {

    this.fetchLunches();

    window.onresize = this.adjustGrid.bind(this);
  }

  fetchLunches() {

    this.service.getLunches().then(lunches => {

      this.lunches = lunches;
      this.changeDet.detectChanges();
      setTimeout(this.adjustGrid.bind(this), 150);
    });
  }

  adjustGrid() {

    const tileWidthStr: string = getComputedStyle(document.getElementsByTagName('app-tile')[0]).getPropertyValue('width');
    const tileWidth: number = Number(tileWidthStr.substring(0, tileWidthStr.indexOf('p')));
    const tilesInWindow = 0.8 * window.innerWidth / tileWidth;
    const extraGap = tilesInWindow - Math.floor(tilesInWindow);
    const multiplier = extraGap > 0.3 ? Math.floor(tilesInWindow + 0.3) : tilesInWindow;
    const gridWidth =  multiplier  * (tileWidth + 15);
    document.getElementById('grid').style.width = gridWidth + 'px';
    this.changeDet.detectChanges();
  }

}
