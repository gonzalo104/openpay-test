import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpTokenInterceptor } from './token-interceptor';
import { ErrorHandlerInterceptor } from './error-interceptor';

export const interceptorProviders = [
  {
    provide: HTTP_INTERCEPTORS,
    useClass: HttpTokenInterceptor,
    multi: true,
  },
  {
    provide: HTTP_INTERCEPTORS,
    useClass: ErrorHandlerInterceptor,
    multi: true,
  },
];
