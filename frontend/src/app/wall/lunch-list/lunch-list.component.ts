import {Component, ElementRef, OnInit, QueryList, ViewChild, ViewChildren} from '@angular/core';
import anime from 'animejs';


import { WallService } from '../wall.service';
import {TileComponent} from "../tile/tile.component";
import {Lunch} from "../../model";

@Component({
  selector: 'lunch-list',
  templateUrl: './lunch-list.component.html',
  styleUrls: ['./lunch-list.component.scss']
})
export class LunchListComponent implements OnInit {

  @ViewChildren(TileComponent) tiles: QueryList<TileComponent>;
  @ViewChild('wall') wall: ElementRef;
  baseSize: [number, number];

  lunches: Lunch[];

  constructor(private service: WallService) { }

  ngOnInit() {

    this.service.getLunches().then(lunches => {
      this.lunches = lunches;
    });

    window.onresize = () => this.ngOnInit();
  }

  expand(id: number): void {

    let chosenTile: TileComponent = this.getTileByLunchId(id);

    if(chosenTile.clicked == true || chosenTile.clickable == false) return;
    else chosenTile.clicked = true;

    this.getOtherTiles([chosenTile]).forEach(tile => tile.clickable = false);

    chosenTile.animateContent('expand');
    this.animateTile('expand', chosenTile);
  }

  collapse(id: number): void {

    let chosenTile: TileComponent = this.getTileByLunchId(id);

    this.getOtherTiles([chosenTile]).forEach(tile => tile.clickable = true);

    chosenTile.animateContent('collapse');
    this.animateTile('collapse', chosenTile);
  }

  getTileByLunchId(id: number): TileComponent { // first element in return array is the selected tile, and second is array of all other tiles

    return this.tiles.toArray().find(tile => tile.lunch.id == id);
  }

  getOtherTiles(tiles: TileComponent[]): TileComponent[] {

    return this.tiles.filter(tile => !tiles.includes(tile));
  }

  getOtherHtmlElements(tiles: TileComponent[]): HTMLElement[] { // returns arrays of HTML elements of all tiles except of the ones passed as argument

    return this.getOtherTiles(tiles).map(component => component.tile.nativeElement);
  }

  animateTile(direction: string, chosenTile: TileComponent): void {

    let expanding: boolean = direction == 'expand';

    let el = chosenTile.tile.nativeElement;
    let frame = chosenTile.frame.nativeElement;

    let otherElements = this.getOtherHtmlElements([chosenTile]);

    let windowWidth: any  = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
    let windowHeight: any = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;

    let targetWidth, targetHeight, frameHeight;

    if(expanding) {
      targetWidth = windowWidth > windowHeight + 200 ? windowWidth / 2.3 : windowWidth * 0.85;
      targetHeight = windowHeight / 1.1;
      this.baseSize = [el.offsetWidth, el.offsetHeight];
    } else {
      targetWidth = this.baseSize[0];
      targetHeight = this.baseSize[1];
    }

    let transX = expanding ?  (windowWidth - targetWidth) / 2 - el.offsetLeft : 0;
    let transY = expanding ? window.scrollY + (windowHeight - targetHeight) / 2 - el.offsetTop : 0;

    let targetOpacity = expanding ? 0.2 : 1;
    chosenTile.showShadow = false;

    anime({
      targets : el,
      translateX : transX,
      translateY : transY,
      width : targetWidth,
      height : targetHeight,
      easing : 'easeInOutElastic',
      elasticity : 150,
      duration : 1000,
      complete : function(){
        chosenTile.expanded = expanding;
        chosenTile.clicked = expanding;
        chosenTile.showShadow = true;
        // chosenTile.fadeExpandedContent(direction);
      }
    });

    anime({
      targets: frame,
      height: targetHeight - 40,
      duration: 1000,
      delay: 500,
      elasticity: 250
    });

    anime({
      targets : otherElements,
      opacity : targetOpacity,
      duration : 800,
      easing : 'linear'
    })
  }
}
