package com.zeni.day11;

public enum Position {
  EmptySeat('L'), OccupiedSeat('#'), Floor('.');

  private char symbol;

  private Position(char symbol) {
    this.symbol = symbol;
  }

  public static Position get(char character) {
    switch (character) {
      case 'L':
        return EmptySeat;
      case '#':
        return OccupiedSeat;
      case '.':
        return Floor;
      default:
        return null;
    }
  }

  public char getSymbol() {
    return symbol;
  }

  public void setSymbol(char symbol) {
    this.symbol = symbol;
  }
}
