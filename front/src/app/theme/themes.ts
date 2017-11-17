export interface Theme {
  name: string;
  mainColor: string;
  secColor: string;
  tetrColor?: string;
  highlightColor: string;
  fontColor: string;
  secFontColor?: string;
  backgroundCount: number;
}

export const defaultTheme: Theme = {
  name : 'default',
  mainColor : 'rgba(161, 157, 163, 0.93)',
  secColor : 'rgba(241, 247, 243, 0.95)',
  highlightColor : 'rgba(161, 157, 163, 0.4)',
  fontColor : 'rgba(43, 43, 43, 0.81)',
  backgroundCount : 1
};

export const pinkrazeTheme: Theme = {
  name : 'pinkraze',
  mainColor : 'rgba(221, 174, 230, 0.97)',
  secColor : 'rgba(88, 113, 238, 0.9)',
  tetrColor : 'rgb(45, 66, 192)',
  highlightColor : 'rgba(221, 174, 230, 0.5)',
  fontColor : 'rgba(43, 43, 43, 0.81)',
  secFontColor : 'rgba(220, 220, 220, 0.9)',
  backgroundCount : 5
};

export const themes: Theme[] = [ defaultTheme, pinkrazeTheme ];
