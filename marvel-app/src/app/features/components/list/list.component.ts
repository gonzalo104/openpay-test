import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CharacterBehaviorService } from '../../shared/services/characters/character-behavior.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent {

  constructor(private characterBehaviorService: CharacterBehaviorService)  {}

  @Input() items: any[] = [];
  @Input() key: string = 'name';
  @Output() onItemClickEvent = new EventEmitter();

  onItemClick(item: any) {
    this.onItemClickEvent.emit(item);
  }

  getImage(item: any) {
    return this.characterBehaviorService.getImage(item);
  }
}
