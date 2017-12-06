import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { ThemeService } from '../../theme/theme.service';
import { Lunch } from '../../model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  @Input() lunch: Lunch | Lunch;
  @Output() close = new EventEmitter<boolean>();

  sections: Section[];
  borders: {name: boolean, dish: boolean};

  constructor(public theme: ThemeService) { }

  ngOnInit() {

    this.borders = {
      name : true,
      dish : false
    };

    this.setSorting('name');
  }

  clickClose(){

    this.close.emit(true);
  }


  setSorting(sort: string){

    this.sections = [];

    this.borders.name = sort === 'name';
    this.borders.dish = sort === 'dish';

    if(sort === 'name') this.sortByName();
    else if(sort === 'dish') this.sortByDish();

    let lunchTotal = 0;

    for(const order of this.lunch.orders)
      for(const dish of order.dishes) lunchTotal += dish.price;

    const lastLine: Item = {
      textLeft : 'Total',
      textRight : lunchTotal + ' PLN'
    };

    const total: Section = {
      header : lastLine,
      items: []
    };

    this.sections.push(total);
  }

  sortByName(){

    for(const order of this.lunch.orders){

      const items: Item[] = [];
      let total = 0;

      for(const dish of order.dishes){

        const item: Item = {
          textLeft : dish.name,
          textRight : dish.price + ''
        };

        items.push(item);
        total += dish.price;
      }

      const section: Section = {
        header : {
          textLeft : order.user.firstName + ' ' + order.user.lastName,
          textRight : total + ''
        },
        items : items
      };

      this.sections.push(section);
    }
  }

  sortByDish(){

    const sections: Section[] = [];

    for(const order of this.lunch.orders){

      for(const dish of order.dishes){

        const item: Item = {
          textLeft : order.user.firstName + ' ' + order.user.lastName,
          textRight : ''
        };

        const section = sections.find(sec => sec.header.textLeft === dish.name);

        if(section) section.items.push(item);
        else {

          const newSection: Section = {
            header : {
              textLeft : dish.name,
              textRight : ''
            },
            items : [item]
          };

          sections.push(newSection);
        }
      }
    }

    for(const section of sections) section.header.textRight = 'x' + section.items.length;

    this.sections = sections;
  }
}

interface Section {
  header: Item;
  items: Item[];
}

interface Item {
  textLeft: string;
  textRight: string;
}
