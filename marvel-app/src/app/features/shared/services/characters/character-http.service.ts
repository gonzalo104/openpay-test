import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from '../../../../../enviroments/environment';
import { MarvelData } from '../../models/response.model';

@Injectable({
  providedIn: 'root',
})
export class CharacterHttpService {
  private urlBase = `${environment.apiUrlBase}/characters`;

  constructor(private http: HttpClient) {}

  getCharacters(): Observable<MarvelData> {
    return this.http
      .get(this.urlBase)
      .pipe(map((response) => response as MarvelData));
  }

  getCharacterById(id: number): Observable<MarvelData> {
    return this.http
      .get(`${this.urlBase}/${id}`)
      .pipe(map((response) => response as MarvelData));
  }
}
