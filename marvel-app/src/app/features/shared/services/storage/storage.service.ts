import { Injectable } from '@angular/core';

@Injectable()
export class StorageService {
  constructor() {}

  public static get(key: string): any {
    let value = localStorage.getItem(key) || '';
    //return JSON.parse(value);
    return value;
  }

  public static set(key: string, value: any) {
    localStorage.setItem(key, JSON.stringify(value));
  }

  public static clear = (key?: string) => {
    if (key) {
      localStorage.removeItem(key);
    } else {
      localStorage.clear();
    }
  };
}
