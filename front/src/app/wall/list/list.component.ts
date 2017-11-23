import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Lunch} from '../../model';
import {ThemeService} from '../../theme/theme.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  @Input() lunch: Lunch | Lunch;
  @Output() close = new EventEmitter<boolean>();

  sections: any[];

  nameBorder: string;
  dishBorder: string;
  sortBy: string;

  constructor(public theme: ThemeService) { }

  ngOnInit() {

    this.setSorting('name');
  }

  clickClose(){

    this.close.emit(true);
  }

  setSorting(sort: string){

    this.sortBy = sort;
    this.nameBorder = sort === 'name' ? this.theme.border1px : 'none';
    this.dishBorder = sort === 'dish' ? this.theme.border1px : 'none';
  }

}
