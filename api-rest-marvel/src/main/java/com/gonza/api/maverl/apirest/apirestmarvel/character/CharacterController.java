package com.gonza.api.maverl.apirest.apirestmarvel.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonza.consumer.marvel.consumermarvel.services.CharacterService;
import com.gonza.consumer.marvel.consumermarvel.models.CharacterData;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {
  @Autowired
  private CharacterService characterService;

  @GetMapping
  public CharacterData getCharacters() {
    return characterService.getCharacters();
  }

  @GetMapping("/{id}")
  public CharacterData getMethodName(@PathVariable Long id) {
    return characterService.getCharacterById(id);
  }
}
