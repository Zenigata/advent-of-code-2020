package com.zeni.day13;

public class DepartureTimeAndBus {

  private long bus;
  private long busStopTime;

  public DepartureTimeAndBus(long bus, long busStopTime) {
    this.bus = bus;
    this.busStopTime = busStopTime;
  }

  public long getBus() {
    return bus;
  }

  public void setBus(long bus) {
    this.bus = bus;
  }

  public long getBusStopTime() {
    return busStopTime;
  }

  public void setBusStopTime(long busStopTime) {
    this.busStopTime = busStopTime;
  }

}
