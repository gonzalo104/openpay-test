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

  async getCharacterById(id: number): Promise<void> {
    this.character = {};

    const res = await this.characterBehaviorService.getCharacterById(id);

    if (this.modal) {
      this.modal.show();
    }

    this.character = res?.results[0] || {};
  }

  async onCharacterClick(character: any) {
    await this.getCharacterById(character.id);
  }

  getImage(item: any) {
    return this.characterBehaviorService.getImage(item);
  }
}
