import { Component } from '@angular/core';
import { CharacterBehaviorService } from 'src/app/features/shared/services/characters/character-behavior.service';
declare let bootstrap: any;

@Component({
  selector: 'app-characters',
  templateUrl: './characters.component.html',
  styleUrls: ['./characters.component.scss'],
})
export class CharactersComponent {
  characters: any[] = [];
  character: any;
  modal: any;

  constructor(public characterBehaviorService: CharacterBehaviorService) {
    this.getCharacters();
  }

  ngAfterViewInit(): void {
    this.modal = new bootstrap.Modal(document.getElementById('modal'));
  }

  async getCharacters(): Promise<void> {
    const response = await this.characterBehaviorService.getCharacters();
    this.characters = response?.results || [];
  }

  onCharacterClick(character: any) {
    this.character = character;
    if (this.modal) {
      this.modal.show();
    }
  }

  getImage(item: any) {
    return this.characterBehaviorService.getImage(item);
  }
}
