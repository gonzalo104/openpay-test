import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from '../../../../../enviroments/environment';

@Injectable({
  providedIn: 'root',
})
export class LogHttpService {
  private urlBase = `${environment.apiUrlBase}/logs`;

  constructor(private http: HttpClient) {}

  getLogs(): Observable<any> {
    return this.http
      .get(this.urlBase)
      .pipe(map((response) => response as any));
  }
}
