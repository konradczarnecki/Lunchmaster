import { Injectable } from '@angular/core';

import { Theme, themes } from './themes';

@Injectable()
export class ThemeService {

  themes: Theme[];
  current: number;
  back: number;

  constructor() {

    this.themes = themes;
    this.current = 0;
    this.back = 1;
  }

  get mainColor(){
    return this.themes[this.current].mainColor;
  }

  get secColor(){
    return this.themes[this.current].secColor;
  }

  get highlightColor(){
    return this.themes[this.current].highlightColor;
  }

  get fontColor(){
    return this.themes[this.current].fontColor;
  }

  get backgroundCount(){
    return this.themes[this.current].backgroundCount;
  }

  get background(){
    return this.back;
  }

  get name() {
    return this.themes[this.current].name;
  }

  setTheme(index: number){

    this.current = index;
    this.pickBackground();
  }

  pickBackground() {
    this.back = Math.floor(1 + Math.random() * this.themes[this.current].backgroundCount);
  }

}
