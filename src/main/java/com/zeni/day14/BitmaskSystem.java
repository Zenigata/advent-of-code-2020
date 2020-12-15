package com.zeni.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BitmaskSystem {

  public long getValueInMemoryAfterLoading(InitializingProgram program) {
    Map<Integer, Long> memory = new HashMap<>();

    for (String bitmask : program.getProgram().keySet()) {
      System.out.println(bitmask + " : " + program.getProgram().get(bitmask).size());
      for (MemoryValue value : program.getProgram().get(bitmask)) {
        memory.put(value.getIndex(), updateValueWithMask(bitmask, value.getValue()));
      }
    }

    return memory.values().stream().reduce(0l, Long::sum);
  }

  private Long updateValueWithMask(String bitmask, long value) {
    String maskReverse = new StringBuilder(bitmask).reverse().toString();

    String origin = Long.toBinaryString(value);
    StringBuilder originReverse = new StringBuilder(origin).reverse();
    StringBuilder destination = new StringBuilder();
    for (int i = 0; i < maskReverse.toCharArray().length; i++) {
      String bit = "0";
      if (maskReverse.charAt(i) != 'X') {
        bit = Character.toString(maskReverse.charAt(i));
      } else if (i < originReverse.length()) {
        bit = Character.toString(originReverse.charAt(i));
      }
      destination.insert(0, bit);
    }

    return Long.parseLong(destination.toString(), 2);
  }

  public long getValueInMemoryAfterLoading2(InitializingProgram program) {
    Map<Integer, Long> memory = new HashMap<>();

    for (String bitmask : program.getProgram().keySet()) {
      for (MemoryValue value : program.getProgram().get(bitmask)) {
        writeFloatsToMemory(memory, bitmask, value);
      }
    }

    return memory.values().stream().reduce(0l, Long::sum);
  }

  private void writeFloatsToMemory(Map<Integer, Long> memory, String bitmask, MemoryValue memoryValue) {
    String maskReverse = new StringBuilder(bitmask).reverse().toString();

    String origin = Long.toBinaryString(memoryValue.getIndex());
    StringBuilder originReverse = new StringBuilder(origin).reverse();
    StringBuilder template = new StringBuilder();

    List<Integer> indexOfX = new ArrayList<>();

    for (int i = 0; i < maskReverse.toCharArray().length; i++) {
      String bit = "0";
      if (maskReverse.charAt(i) == 'X') {
        bit = "X";
        indexOfX.add(i);
      } else if (maskReverse.charAt(i) == '1') {
        bit = "1";
      } else if (i < originReverse.length()) {
        bit = Character.toString(originReverse.charAt(i));
      }
      template.insert(0, bit);
    }

    List<String> addresses = multiplies(template.toString(), indexOfX);

    for (String address : addresses) {
      memory.put(Integer.parseInt(address, 2), memoryValue.getValue());
    }
  }

  public List<String> multiplies(String template, List<Integer> indexOfX) {
    List<String> addresses = new ArrayList<>();
    for (int i = 0; i < Math.pow(2, indexOfX.size()); i++) {
      addresses.add(template);
    }

    for (int i = 0; i < indexOfX.size(); i++) {
      for (int j = 0; j < addresses.size(); j++) {
        if (j % 2 == 0) {
          addresses.set(j, addresses.get(j).replaceFirst("X", "1"));
        } else {
          addresses.set(j, addresses.get(j).replaceFirst("X", "0"));
        }
      }
    }
    return addresses;
  }

}
