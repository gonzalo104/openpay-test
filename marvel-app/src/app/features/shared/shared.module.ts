import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthenticationBehaviorService } from './services/auth/authenticcation-behavior.service';
import { AuthenticationHttpService } from './services/auth/authentication-http.service';
import { CharacterBehaviorService } from './services/characters/character-behavior.service';
import { CharacterHttpService } from './services/characters/character-http.service';
import { ListGroupComponent } from '../components/list-group/list-group.component';
import { LogBehaviorService } from './services/logs/log-behavior.service';
import { LogHttpService } from './services/logs/log-http.service';

@NgModule({
  declarations: [],
  imports: [CommonModule],
  exports: [],
  providers: [
    AuthenticationBehaviorService,
    AuthenticationHttpService,
    CharacterBehaviorService,
    CharacterHttpService,
    LogBehaviorService,
    LogHttpService,
  ],
})
export class SharedModule {}
