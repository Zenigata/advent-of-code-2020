package com.zeni.day13;

import java.util.Comparator;

public class SchedulingOptimizer {

  private BusScheduling scheduling;

  public SchedulingOptimizer(BusScheduling scheduling) {
    this.scheduling = scheduling;
  }

  public long getProductOfBusIdAndWaitingMinutes() {
    DepartureTimeAndBus busFound = scheduling.getBusSchedules().stream()
        .map(b -> findTheEarlierBusStopAfter(scheduling.getDepartureTime(), b))
        .min(Comparator.comparing(DepartureTimeAndBus::getBusStopTime)).get();
    return (busFound.getBusStopTime() - scheduling.getDepartureTime()) * busFound.getBus();
  }

  private DepartureTimeAndBus findTheEarlierBusStopAfter(long departureTime, Integer bus) {
    long nextBusStopTime = 0;
    while (nextBusStopTime < departureTime) {
      nextBusStopTime += bus;
    }
    return new DepartureTimeAndBus(bus, nextBusStopTime);
  }

}
