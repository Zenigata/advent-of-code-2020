package com.zeni.day05;

import java.util.List;

public class BinaryBoarding {

  public int getRowNumber(String source) {
    String binary = convertRowToBinary(source);
    return Integer.parseInt(binary, 2);
  }

  private String convertRowToBinary(String source) {
    return source.replaceAll("F", "0").replaceAll("B", "1");
  }

  public int getColumnNumber(String source) {
    String binary = convertColumnToBinary(source);
    return Integer.parseInt(binary, 2);
  }

  private String convertColumnToBinary(String source) {
    return source.replaceAll("R", "1").replaceAll("L", "0");
  }

  public int getSeatID(String source) {
    return getRowNumber(source.substring(0, 7)) * 8 + getColumnNumber(source.substring(7));
  }

  public int findTheHighestSeatIDIn(List<String> sourceList) {
    return sourceList.stream().map(s -> getSeatID(s)).max(Integer::compare).get();
  }

}
