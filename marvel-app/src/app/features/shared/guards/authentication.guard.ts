import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  CanActivate,
  Router,
  RouterStateSnapshot,
} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationBehaviorService } from '../services/auth/authenticcation-behavior.service';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationGuard implements CanActivate {
  constructor(
    private route: Router,
    private authenticationBehaviorService: AuthenticationBehaviorService
  ) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean> | Promise<boolean> | boolean {
    const token = this.authenticationBehaviorService.authToken || null;
    console.log('token: AuthenticationGuard', token);
    if (!token || token === null || token === '') {
      this.route.navigateByUrl('login');
      return false;
    } else {
      return true;
    }
  }
}
