package com.zeni.day13;

import java.util.List;

public class BusScheduling {

  private long departureTime;
  private List<Integer> busSchedules;

  public BusScheduling(long departureTime, List<Integer> busSchedules) {
    this.departureTime = departureTime;
    this.busSchedules = busSchedules;
  }

  public long getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(long departureTime) {
    this.departureTime = departureTime;
  }

  public List<Integer> getBusSchedules() {
    return busSchedules;
  }

  public void setBusSchedules(List<Integer> busSchedules) {
    this.busSchedules = busSchedules;
  }

}
