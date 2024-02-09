import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './features/pages/login/login.component';
import { LoggedInGuard } from './features/shared/guards/logged-in.guard';
import { AuthenticationGuard } from './features/shared/guards/authentication.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [LoggedInGuard],
  },
  {
    path: 'home',
    loadChildren: () => import('./features/pages/home/home.module').then((m) => m.HomeModule),
    canActivate: [AuthenticationGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
