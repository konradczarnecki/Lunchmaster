export interface Theme {
  name: string;
  mainColor: string;
  secColor: string;
  highlightColor: string;
  fontColor: string;
  backgroundCount: number;
}

export const defaultTheme: Theme = {
  name : 'default',
  mainColor : 'rgba(161, 157, 163, 0.93)',
  secColor : 'rgba(231, 227, 233, 0.88)',
  highlightColor : 'rgba(161, 157, 163, 0.4)',
  fontColor : 'rgba(43, 43, 43, 0.81)',
  backgroundCount : 1
};

export const pinkrazeTheme: Theme = {
  name : 'pinkraze',
  mainColor : 'rgba(221, 174, 230, 0.97)',
  secColor : 'rgba(88, 113, 238, 0.95)',
  highlightColor : 'rgba(221, 174, 230, 0.7)',
  fontColor : 'rgba(43, 43, 43, 0.81)',
  backgroundCount : 5
};

export const themes: Theme[] = [ defaultTheme, pinkrazeTheme ];
