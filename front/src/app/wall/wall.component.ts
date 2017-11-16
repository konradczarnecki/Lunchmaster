import { ChangeDetectorRef, Component, OnInit} from '@angular/core';

import { WallService } from './service/wall.service';
import { ThemeService} from '../theme/theme.service';
import { Lunch } from '../model';

import { fadeAnimation, slideAnimation } from './animations';

@Component({
  selector: 'app-wall',
  templateUrl: './wall.component.html',
  styleUrls: ['./wall.component.scss'],
  animations : [ slideAnimation, fadeAnimation ],
})
export class WallComponent implements OnInit {

  lunches: Lunch[];
  selected: number;

  constructor(private service: WallService,
              private changeDet: ChangeDetectorRef,
              public theme: ThemeService) { }

  ngOnInit() {

    this.fetchLunches();
    this.selected = -1;

    window.onresize = this.adjustGrid.bind(this);
  }

  get detailsState(): string {

    return this.selected === -1 ? 'hidden' : 'shown';
  }

  fetchLunches() {

    this.service.getLunches().then(lunches => {

      this.lunches = lunches;
      this.adjustGrid();
    });
  }

  adjustGrid() {

    const tileWidth = 400;
    const tilesInWindow = 0.8 * window.innerWidth / tileWidth;
    const extraGap = tilesInWindow - Math.floor(tilesInWindow);
    const multiplier = extraGap > 0.3 ? Math.floor(tilesInWindow + 0.3) : tilesInWindow;
    const gridWidth =  multiplier  * (tileWidth + 15);

    document.getElementById('grid').style.width = gridWidth + 'px';
    this.changeDet.detectChanges();
  }

}
