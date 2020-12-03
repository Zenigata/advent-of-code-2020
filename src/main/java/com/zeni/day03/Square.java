package com.zeni.day03;

public enum Square {
  Tree('#'), Open('.');

  private char symbol;

  private Square(char symbol) {
    this.symbol = symbol;
  }

  public static Square get(char character) {
    return Tree.getSymbol() == character ? Tree : Open;
  }

  public char getSymbol() {
    return symbol;
  }

  public void setSymbol(char symbol) {
    this.symbol = symbol;
  }
}
