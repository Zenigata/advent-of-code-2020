package com.zeni.day12;

public enum Direction {
  NORTH(1), WEST(2), SOUTH(3), EAST(0);

  private int number;

  private Direction(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public static Direction get(int source) {
    switch (Math.abs(source % 4)) {
      case 1:
        return NORTH;
      case 2:
        return WEST;
      case 3:
        return SOUTH;
      case 0:
        return EAST;
      default:
        System.out.println(source + " error: " + Math.abs(source % 4));
        return EAST;
    }
  }

}
