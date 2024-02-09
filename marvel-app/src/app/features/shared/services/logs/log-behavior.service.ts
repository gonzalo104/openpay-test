import { Injectable } from '@angular/core';
import { BehaviorSubject, lastValueFrom } from 'rxjs';
import { LogHttpService } from './log-http.service';


@Injectable({
  providedIn: 'root',
})
export class LogBehaviorService {
  private readonly error$ = new BehaviorSubject<string>('');
  private readonly loading$ = new BehaviorSubject<boolean>(false);

  constructor(private logHttpService: LogHttpService) {}

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

  async getLogs(): Promise<any> {
    try {
      this.loading = true;
      const logs = await lastValueFrom(this.logHttpService.getLogs());
      this.loading = false;
      return logs;
    } catch (error: any) {
      this.loading = false;
      this.error = 'sorry, we could not get the logs';
      throw new Error(error?.message);
    }
  }
}
