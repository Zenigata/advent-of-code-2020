package com.zeni.day13;

public class DepartureTimeAndBus {

  private int bus;
  private long busStopTime;

  public DepartureTimeAndBus(int bus, long busStopTime) {
    this.bus = bus;
    this.busStopTime = busStopTime;
  }

  public int getBus() {
    return bus;
  }

  public void setBus(int bus) {
    this.bus = bus;
  }

  public long getBusStopTime() {
    return busStopTime;
  }

  public void setBusStopTime(long busStopTime) {
    this.busStopTime = busStopTime;
  }

}
