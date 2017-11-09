export interface Theme {
  mainColor: string;
  secColor: string;
  fontColor: string;
}

export const pinkrazeTheme: Theme = {
  mainColor : 'rgba(221, 174, 230, 0.97)',
  secColor : 'rgba(88, 113, 238, 0.95)',
  fontColor : 'rgba(43, 43, 43, 0.81)'
};

export const themes: Theme[] = [pinkrazeTheme];
