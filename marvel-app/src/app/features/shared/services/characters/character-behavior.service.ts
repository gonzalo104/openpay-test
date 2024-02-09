import { Injectable } from '@angular/core';
import { BehaviorSubject, lastValueFrom } from 'rxjs';
import { CharacterHttpService } from './character-http.service';


@Injectable({
  providedIn: 'root',
})
export class CharacterBehaviorService {
  private readonly error$ = new BehaviorSubject<string>('');
  private readonly loading$ = new BehaviorSubject<boolean>(false);

  constructor(private characterHttpService: CharacterHttpService) {}

  get error(): string {
    return this.error$.getValue();
  }

  set error(value: string) {
    this.error$.next(value);
  }

  get loading(): boolean {
    return this.loading$.getValue();
  }

  set loading(value: boolean) {
    this.loading$.next(value);
  }

  getImage(item: any) {
    const url = item?.thumbnail ? `${item?.thumbnail.path}/standard_fantastic.${item?.thumbnail?.extension}` : 'https://via.placeholder.com/150';
    return url;
  }

  async getCharacters(): Promise<any> {
    try {
      this.loading = true;
      const characters = await lastValueFrom(this.characterHttpService.getCharacters());
      this.loading = false;
      return characters;
    } catch (error: any) {
      this.loading = false;
      this.error = 'sorry, we could not get the characters';
      throw new Error(error?.message);
    }
  }

  async getCharacterById(id: number): Promise<any> {
    try {
      this.loading = true;
      const character = await lastValueFrom(this.characterHttpService.getCharacterById(id));
      this.loading = false;
      return character;
    } catch (error: any) {
      this.loading = false;
      this.error = 'sorry, we could not get the character';
      throw new Error(error?.message);
    }
  }

}
