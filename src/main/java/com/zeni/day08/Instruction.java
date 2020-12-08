package com.zeni.day08;

public class Instruction {

  private Operation operation;
  private int argument;

  public Instruction(Operation operation, int argument) {
    this.operation = operation;
    this.argument = argument;
  }

  public Operation getOperation() {
    return operation;
  }

  public void setOperation(Operation operation) {
    this.operation = operation;
  }

  public int getArgument() {
    return argument;
  }

  public void setArgument(int argument) {
    this.argument = argument;
  }

}
