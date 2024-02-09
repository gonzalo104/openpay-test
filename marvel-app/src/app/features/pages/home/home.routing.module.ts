import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home.component';
import { NgModule } from '@angular/core';
import { CharactersComponent } from './pages/characters/characters.component';
import { LogsComponent } from './pages/logs/logs.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      { path: 'characters', component: CharactersComponent },
      { path: 'logs', component: LogsComponent },
      { path: '**', redirectTo: 'characters' },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})

export class HomeRoutingModule {}
