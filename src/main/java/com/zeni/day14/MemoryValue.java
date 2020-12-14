package com.zeni.day14;

public class MemoryValue {

  private int index;
  private long value;

  public MemoryValue(int index, long value) {
    this.index = index;
    this.value = value;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }

}
