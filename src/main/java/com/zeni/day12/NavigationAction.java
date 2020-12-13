package com.zeni.day12;

public enum NavigationAction {
  NORTH, SOUTH, EAST, WEST, LEFT, RIGHT, FORWARD;

  public static NavigationAction get(String source) {
    switch (source) {
      case "N":
        return NORTH;
      case "S":
        return SOUTH;
      case "E":
        return EAST;
      case "W":
        return WEST;
      case "L":
        return LEFT;
      case "R":
        return RIGHT;
      case "F":
        return FORWARD;
      default:
        return null;
    }
  }
}
