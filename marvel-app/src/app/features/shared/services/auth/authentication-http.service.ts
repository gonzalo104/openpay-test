import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from '../../../../../enviroments/environment';
import { Authentication, AuthPayload } from '../../models/authentication.model';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationHttpService {
  private urlBase = `${environment.apiUrlBase}`;

  constructor(private http: HttpClient) {}

  login(payload: AuthPayload): Observable<Authentication> {
    return this.http
      .post(`${this.urlBase}/login`, payload)
      .pipe(map(response => response as Authentication));
  }
}
