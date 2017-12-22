import { ChangeDetectorRef, ElementRef, Injectable, Renderer2 } from '@angular/core';

@Injectable()
export class ThemeService {

  themes: string[];
  current: string;

  constructor() {

    this.themes = themes;
    const saved = localStorage.getItem('theme');
    this.current = saved ? saved : this.themes[0];
  }

  get typeA(){
    return this.current + '-a';
  }

  get typeB(){
    return this.current + '-b';
  }

  get typeC(){
    return this.current + '-c';
  }

  get tile(){
    return this.current + '-tile';
  }

  get border(){
    return this.current + '-border1px';
  }

  get borderB(){
    return this.current + '-border1pxB';
  }

  get borderRight(){
    return this.current + '-border1pxRight';
  }

  get borderRightB(){
    return this.current + '-border1pxRightB';
  }

  get font(){
    return this.current + '-font';
  }

  get fontB(){
    return this.current + '-fontB';
  }

  get input(){
    return this.current + '-input';
  }

  static adjustGrid(component: {renderer: Renderer2, changeDet: ChangeDetectorRef, grid: ElementRef}) {

    const tileWidth = 400;
    const tilesInWindow = 0.8 * window.innerWidth / tileWidth;
    const extraGap = tilesInWindow - Math.floor(tilesInWindow);
    const multiplier = extraGap > 0.3 ? Math.floor(tilesInWindow + 0.3) : tilesInWindow;
    const gridWidth =  multiplier  * (tileWidth + 15);

    component.renderer.setStyle(component.grid.nativeElement, 'width', gridWidth + 'px');
    component.changeDet.detectChanges();
  }

  setTheme(theme: string){

    this.current = theme;
    localStorage.setItem('theme', theme);
  }
}

export const themes: string[] = ['blue', 'red', 'grass', 'pinkraze'];

