import { Injectable } from '@angular/core';
import { AuthenticationHttpService } from './authentication-http.service';
import { AuthPayload, Authentication } from '../../models/authentication.model';
import { BehaviorSubject, lastValueFrom } from 'rxjs';
import { Router } from '@angular/router';
import { StorageService } from '../storage/storage.service';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationBehaviorService {
  private readonly key = 'authentication';
  private readonly authToken$ = new BehaviorSubject<Authentication>(
    {} as Authentication
  );
  private readonly error$ = new BehaviorSubject<string>('');
  private readonly loading$ = new BehaviorSubject<boolean>(false);
  private readonly loadingVerifyToken$ = new BehaviorSubject<boolean>(false);

  constructor(
    private authenticationHttpService: AuthenticationHttpService,
    private router: Router,
  ) {
    this.authToken = StorageService.get(this.key);
  }

  get authToken(): Authentication {
    return this.authToken$.getValue();
  }

  set authToken(value: Authentication) {
    this.authToken$.next(value);
  }

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

  get loadingVerifyToken(): boolean {
    return this.loadingVerifyToken$.getValue();
  }

  set loadingVerifyToken(value: boolean) {
    this.loadingVerifyToken$.next(value);
  }

  async login(payload: AuthPayload) {
    try {
      this.loading = true;

      const loginData = await lastValueFrom(
        this.authenticationHttpService.login(payload)
      );

      this.loading = false;

      this.authToken = loginData.token;

      StorageService.set(this.key, loginData);

      this.router.navigateByUrl('/home/characters');
    } catch (error: any) {
      this.loading = false;
      this.error = 'password or username is incorrect';
      throw new Error(error?.message);
    }
  }

  async logout() {
    StorageService.clear();
    window.location.href = `${window.location.protocol}//${window.location.host}/login`;
  }

}
