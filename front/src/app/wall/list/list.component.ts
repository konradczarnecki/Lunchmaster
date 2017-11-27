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

  sections: Section[];

  nameBorder: string;
  dishBorder: string;

  constructor(public theme: ThemeService) { }

  ngOnInit() {

    this.setSorting('name');
  }

  clickClose(){

    this.close.emit(true);
  }

  setSorting(sort: string){

    this.sections = [];

    this.nameBorder = sort === 'name' ? this.theme.border1px : 'none';
    this.dishBorder = sort === 'dish' ? this.theme.border1px : 'none';

    if(sort === 'name'){

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

    } else if(sort === 'dish'){

      const sections: Section[] = [];

      for(const order of this.lunch.orders){

        for(const dish of order.dishes){

          const section = sections.find(sec => sec.header.textLeft === dish.name);

          const item: Item = {
            textLeft : order.user.firstName + ' ' + order.user.lastName,
            textRight : ''
          };

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
}

interface Section {
  header: Item;
  items: Item[];
}

interface Item {
  textLeft: string;
  textRight: string;
}
