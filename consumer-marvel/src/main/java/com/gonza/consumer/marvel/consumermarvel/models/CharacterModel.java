package com.gonza.consumer.marvel.consumermarvel.models;

import java.util.List;

public class CharacterModel {
  private int id;
  private String name;
  private String description;
  private String modified;
  private Thumbnail thumbnail;
  private String resourceURI;
  private Product comics;
  private Product series;
  private Product stories;
  private Product events;
  private List<Url> urls;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getModified() {
    return modified;
  }

  public void setModified(String modified) {
    this.modified = modified;
  }

  public Thumbnail getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getResourceURI() {
    return resourceURI;
  }

  public void setResourceURI(String resourceURI) {
    this.resourceURI = resourceURI;
  }

  public Product getComics() {
    return comics;
  }

  public void setComics(Product comics) {
    this.comics = comics;
  }

  public Product getSeries() {
    return series;
  }

  public void setSeries(Product series) {
    this.series = series;
  }

  public Product getStories() {
    return stories;
  }

  public void setStories(Product stories) {
    this.stories = stories;
  }

  public Product getEvents() {
    return events;
  }

  public void setEvents(Product events) {
    this.events = events;
  }

  public List<Url> getUrls() {
    return urls;
  }

  public void setUrls(List<Url> urls) {
    this.urls = urls;
  }

}
