package com.gonza.consumer.marvel.consumermarvel.models;

import java.util.List;

public class Product {
  private int available;
  private String collectionURI;
  private List<Item> items;

  public int getAvailable() {
    return available;
  }

  public void setAvailable(int available) {
    this.available = available;
  }

  public String getCollectionURI() {
    return collectionURI;
  }

  public void setCollectionURI(String collectionURI) {
    this.collectionURI = collectionURI;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

}
