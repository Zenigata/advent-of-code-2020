package com.zeni.day09;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Xmas {

  public long findAnErrorIn(int preambleSize, List<Long> numbers) {
    if (numbers.size() <= preambleSize) {
      return -1;
    }

    for (int i = preambleSize; i < numbers.size(); i++) {
      Set<Long> possibilities = generateAllPossibilities(numbers, i - preambleSize, i);
      if (!possibilities.contains(numbers.get(i))) {
        return numbers.get(i);
      }
    }
    return -1;
  }

  private Set<Long> generateAllPossibilities(List<Long> numbers, int start, int end) {
    Set<Long> possibilities = new HashSet<>();
    for (int i = start; i < end; i++) {
      for (int j = start; j < end; j++) {
        if (i != j) {
          possibilities.add(numbers.get(i) + numbers.get(j));
        }
      }
    }
    return possibilities;
  }
}
