package com.zeni.day13;

import java.util.List;

public class BusScheduling {

  private long departureTime;
  private List<BusSchedule> busSchedules;

  public BusScheduling(long departureTime, List<BusSchedule> busSchedules) {
    this.departureTime = departureTime;
    this.busSchedules = busSchedules;
  }

  public long getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(long departureTime) {
    this.departureTime = departureTime;
  }

  public List<BusSchedule> getBusSchedules() {
    return busSchedules;
  }

  public void setBusSchedules(List<BusSchedule> busSchedules) {
    this.busSchedules = busSchedules;
  }

}
