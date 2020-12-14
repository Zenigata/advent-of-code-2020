package com.zeni.day14;

import java.util.HashMap;
import java.util.Map;

public class BitmaskSystem {

  public long getValueInMemoryAfterLoading(InitializingProgram program) {
    Map<Integer, Long> memory = new HashMap<>();

    for (String bitmask : program.getProgram().keySet()) {
      for (MemoryValue value : program.getProgram().get(bitmask)) {
        memory.put(value.getIndex(), updateValueWithMask(bitmask, value.getValue()));
      }
    }

    return memory.values().stream().reduce(0l, Long::sum);
  }

  private Long updateValueWithMask(String bitmask, long value) {
    String maskReverse = new StringBuilder(bitmask).reverse().toString();

    StringBuilder origin = new StringBuilder(Long.toBinaryString(value)).reverse();
    StringBuilder destination = new StringBuilder();
    for (int i = 0; i < maskReverse.toCharArray().length; i++) {
      String bit = "0";
      if (maskReverse.charAt(i) != 'X') {
        bit = Character.toString(maskReverse.charAt(i));
      } else if (i < origin.length()) {
        bit = Character.toString(origin.charAt(i));
      }
      destination.insert(0, bit);
    }

    return Long.parseLong(destination.toString(), 2);
  }

}
