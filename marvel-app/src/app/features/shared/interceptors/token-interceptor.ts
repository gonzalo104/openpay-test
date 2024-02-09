import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationBehaviorService } from '../services/auth/authenticcation-behavior.service';

@Injectable()
export class HttpTokenInterceptor implements HttpInterceptor {
  constructor(
    private authenticationBehaviorService: AuthenticationBehaviorService
  ) {}

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    let cloneReq = this.setToken(req);
    return next.handle(cloneReq);
  }

  private setToken = (req: HttpRequest<any>): HttpRequest<any> => {
    let cloneReq = req.clone();

    const access_token =
      this.authenticationBehaviorService.authToken || '';

    if (access_token) {
      cloneReq = req.clone({
        headers: req.headers.set('Authorization', `Bearer ${access_token}`),
      });
    }

    return cloneReq;
  };
}
