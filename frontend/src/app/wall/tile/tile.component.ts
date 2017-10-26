import {ChangeDetectorRef, Component, ElementRef, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Lunch} from "../../model";
import anime from 'animejs';

@Component({
  selector: 'tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.scss']
})
export class TileComponent {

  @Input() lunch: Lunch;
  @Output() closed = new EventEmitter<number>();

  @ViewChild('tile') tile: ElementRef;
  @ViewChild('image') image: ElementRef;
  @ViewChild('collapsedContent') collapsedContent: ElementRef;
  @ViewChild('expandedContent') expandedContent: ElementRef;
  @ViewChild('frame') frame: ElementRef;

  expanded: boolean;
  clicked: boolean;
  clickable: boolean;
  showShadow: boolean;

  constructor(private cdRef: ChangeDetectorRef) {
    this.expanded = false;
    this.clicked = false;
    this.clickable = true;
    this.showShadow = true;
  }

  animateContent(direction: string): void {

    let expanding = direction == 'expand';

    let targetOp = expanding ? 0 : 1;
    let startOp = expanding ? 1 : 0;

    let imgSize = expanding ? 0.7 : 1;
    let imgTransp = expanding ? -40 : 0;

    this.cdRef.detectChanges();

    anime({
      targets : this.collapsedContent.nativeElement,
      opacity : [startOp, targetOp],
      duration : 400,
      easing : 'linear'
    });

    anime({
      targets : this.image.nativeElement,
      scale : imgSize,
      translateY : imgTransp,
      duration : 800,
      delay : 500
    })
  }

  fadeExpandedContent(direction: string){

    this.cdRef.detectChanges();

    let expanding = direction == 'expand';
    let opTarget = expanding ? 1 : 0;

    anime({
      targets : this.expandedContent.nativeElement,
      opacity : [Math.abs(opTarget-1), opTarget],
      duration : 250,
      easing : 'linear'
    })
  }

  close(): void {
    this.expanded = false;
    this.closed.emit(this.lunch.id);
  }
}
