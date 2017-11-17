import {animate, keyframes, state, style, transition, trigger} from '@angular/animations';

export const slideAnimation = trigger('slide', [

  transition('void => *', [
    style({transform : 'translate(0, -100%)'}),
    animate('300ms cubic-bezier(.58,.7,.46,1.02)')
  ]),

  transition('* => void', [
    animate('300ms cubic-bezier(.58,.7,.46,1.02)', style({transform : 'translate(0, -100%)'}))
  ])
]);

export const fadeAnimation = trigger('fade', [

  state('hidden', style({opacity : 1})),
  state('shown', style({opacity : 0.25})),
  transition('shown <=> hidden',animate('300ms ease-out'))
]);
