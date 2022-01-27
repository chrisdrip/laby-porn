package com.github.chrissdrip.laby.porn.util;

public class ModelInformation {

  private final String name;

  private final int rank;

  private final long subscribers;

  private final long views;

  public ModelInformation(String name, int rank, long subscribers, long views) {
    this.name = name;
    this.rank = rank;
    this.subscribers = subscribers;
    this.views = views;
  }

  public String getName() {
    return this.name;
  }

  public int getRank() {
    return this.rank;
  }

  public long getSubscribers() {
    return this.subscribers;
  }

  public long getViews() {
    return this.views;
  }
}