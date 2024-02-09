package com.gonza.consumer.marvel.consumermarvel.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gonza.consumer.marvel.consumermarvel.models.CharacterData;
import com.gonza.consumer.marvel.consumermarvel.models.CharacterResponse;

@Service
public class CharacterService {
  private final String BASE_URL = "https://gateway.marvel.com:443/v1/public/characters";

  private RestTemplate restTemplate;

  public CharacterService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public CharacterData getCharacters(int offset, int limit) {
    String url = BASE_URL + "?offset=" + offset + "&limit=" + limit;
    CharacterResponse response = restTemplate.getForObject(url, CharacterResponse.class);

    if (response == null) {
      throw new RuntimeException("No characters found");
    }

    return response.getData();
  }

  public CharacterData getCharacterById(Long id) {
    String url = BASE_URL + "/" + id;
    CharacterResponse response = restTemplate.getForObject(url, CharacterResponse.class);

    if (response == null) {
      throw new RuntimeException("No character found with id: " + id);
    }

    return response.getData();
  }
}
