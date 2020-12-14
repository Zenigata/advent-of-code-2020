package com.zeni.day13;

import java.util.Comparator;
import java.util.List;

public class SchedulingOptimizer {

  private BusScheduling scheduling;

  public SchedulingOptimizer(BusScheduling scheduling) {
    this.scheduling = scheduling;
  }

  public long getProductOfBusIdAndWaitingMinutes() {
    DepartureTimeAndBus busFound = scheduling.getBusSchedules().stream()
        .map(b -> findTheEarlierBusStopAfter(scheduling.getDepartureTime(), b.getMinutes()))
        .min(Comparator.comparing(DepartureTimeAndBus::getBusStopTime)).get();
    return (busFound.getBusStopTime() - scheduling.getDepartureTime()) * busFound.getBus();
  }

  private DepartureTimeAndBus findTheEarlierBusStopAfter(long departureTime, Long bus) {
    long nextBusStopTime = 0;
    while (nextBusStopTime < departureTime) {
      nextBusStopTime += bus;
    }
    return new DepartureTimeAndBus(bus, nextBusStopTime);
  }

  public long getTheEarlierTimestampForTheContest() {
    List<BusSchedule> busSchedules = scheduling.getBusSchedules();

    long timestamp = lcm(busSchedules).getMinutes();

    /*
     * boolean found = false; long i = 100000000000000l; // long i = 0; long
     * timestamp = busSchedules.get(0).getMinutes(); while (!found) { timestamp =
     * ++i * busSchedules.get(0).getMinutes(); for (int j = 1; j <
     * busSchedules.size(); j++) { if (!((timestamp +
     * busSchedules.get(j).getIndex()) % busSchedules.get(j).getMinutes() == 0)) {
     * break; } else if (j == busSchedules.size() - 1) { found = true; } } }
     */
    return timestamp;
  }

  public static long gcdExtended(long a, long b, long x, long y) {
    // Base Case
    if (a == 0) {
      x = 0;
      y = 1;
      return b;
    }

    long x1 = 1, y1 = 1; // To store results of recursive call
    long gcd = gcdExtended(b % a, a, x1, y1);

    // Update x and y using results of recursive
    // call
    x = y1 - (b / a) * x1;
    y = x1;

    return gcd;
  }

  private static BusSchedule lcm(BusSchedule a, BusSchedule b) {
    a.setMinutes(
        a.getMinutes() * (b.getMinutes() / gcdExtended(a.getMinutes(), b.getMinutes(), a.getIndex(), b.getIndex())));
    return a;
  }

  private static BusSchedule lcm(List<BusSchedule> input) {
    BusSchedule result = new BusSchedule(0, input.get(0).getMinutes());
    for (int i = 1; i < input.size(); i++) {
      System.out.print(result.getMinutes() + " | ");
      result = lcm(result, input.get(i));
      System.out.println(input.get(i) + " | " + result.getMinutes());
    }
    return result;
  }

  private static long gcd(long a, long b) {
    while (b > 0) {
      long temp = b;
      b = a % b; // % is remainder
      a = temp;
    }
    return a;
  }

}
