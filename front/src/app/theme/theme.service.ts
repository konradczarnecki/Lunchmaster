import { Injectable } from '@angular/core';

import { Theme, themes } from './themes';

@Injectable()
export class ThemeService {

  themes: Theme[];
  current: number;
  backgroundIdx: number;

  constructor() {

    this.themes = themes;
    this.backgroundIdx = 1;
    this.current = Number(localStorage.getItem('theme'));
  }

  get mainColor(){
    return this.themes[this.current].mainColor;
  }

  get secColor(){
    return this.themes[this.current].secColor;
  }

  get tetrColor(){

    return this.themes[this.current].tetrColor === undefined ?
      this.themes[this.current].secColor : this.themes[this.current].tetrColor;
  }

  get highlightColor(){
    return this.themes[this.current].highlightColor;
  }

  get fontColor(){
    return this.themes[this.current].fontColor;
  }

  get secFontColor(){

    return this.themes[this.current].secFontColor === undefined ?
      this.themes[this.current].fontColor : this.themes[this.current].secFontColor;
  }

  get backgroundCount(){
    return this.themes[this.current].backgroundCount;
  }

  get background(){
    return this.backgroundIdx;
  }

  get name() {
    return this.themes[this.current].name;
  }

  setTheme(index: number){

    this.current = index;
    localStorage.setItem('theme', String(index));
    this.pickBackground();
  }

  pickBackground() {

    this.backgroundIdx = Math.floor(1 + Math.random() * this.themes[this.current].backgroundCount);
  }

}
