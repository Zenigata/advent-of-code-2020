package com.zeni;

public enum Square {
  Tree("#"), Open(".");

  private String symbol;

  private Square(String symbol) {
    this.symbol = symbol;
  }

}
