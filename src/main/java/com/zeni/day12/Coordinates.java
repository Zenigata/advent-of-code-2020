package com.zeni.day12;

public class Coordinates {

  private int x;
  private int y;

  public Coordinates(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void moveNorth(int value) {
    this.y -= value;
  }

  public void moveSouth(int value) {
    this.y += value;
  }

  public void moveEast(int value) {
    this.x += value;
  }

  public void moveWest(int value) {
    this.x -= value;
  }

  public long getManhattanDistance() {
    return Math.abs(this.x) + Math.abs(this.y);
  }

}
