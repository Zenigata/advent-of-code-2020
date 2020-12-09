package com.zeni.day09;

import java.util.Collections;
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

  public long findTheEncryptionWeakness(int preambleSize, List<Long> numbers) {
    long error = findAnErrorIn(preambleSize, numbers);

    Set<Long> contiguousNumbers = findTheContiguousNumbers(error, numbers);
    return Collections.min(contiguousNumbers) + Collections.max(contiguousNumbers);
  }

  private Set<Long> findTheContiguousNumbers(long error, List<Long> numbers) {
    Set<Long> contiguousNumbers = new HashSet<>();

    for (int i = 0; i < numbers.size() - 1; i++) {
      contiguousNumbers = new HashSet<>();
      long total = 0;
      for (int j = 0; total < error; j++) {
        contiguousNumbers.add(numbers.get(i + j));
        total += numbers.get(i + j);
      }
      if (total == error) {
        return contiguousNumbers;
      }
    }

    return contiguousNumbers;
  }
}
