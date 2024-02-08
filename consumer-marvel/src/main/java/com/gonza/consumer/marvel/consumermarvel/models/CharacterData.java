package com.gonza.consumer.marvel.consumermarvel.models;

import java.util.List;

public class CharacterData {
  private int offset;
  private int limit;
  private int total;
  private int count;
  private List<CharacterModel> results;

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public List<CharacterModel> getResults() {
    return results;
  }

  public void setResults(List<CharacterModel> results) {
    this.results = results;
  }

}
