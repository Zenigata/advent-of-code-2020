package com.zeni.day08;

public enum Operation {
  ACC, JMP, NOP;

  public static Operation get(String trigram) {
    switch (trigram) {
      case "jmp":
        return JMP;
      case "acc":
        return ACC;
      case "nop":
        return NOP;
      default:
        return null;
    }
  }

}
