package com.zeni.day13;

public class BusSchedule {

  private int index;
  private long minutes;

  public BusSchedule(int index, long minutes) {
    this.index = index;
    this.minutes = minutes;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public long getMinutes() {
    return minutes;
  }

  public void setMinutes(long minutes) {
    this.minutes = minutes;
  }

}
