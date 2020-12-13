package com.zeni.day12;

public class NavigationInstruction {

  private NavigationAction action;
  private int value;

  public NavigationInstruction(NavigationAction action, int value) {
    this.action = action;
    this.value = value;
  }

  public NavigationAction getAction() {
    return action;
  }

  public void setAction(NavigationAction action) {
    this.action = action;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

}
