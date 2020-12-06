package com.zeni.day06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomDeclaration {

  public int countUniquePositiveAnswers(String answers) {
    Set<Character> uniqueAnswers = new HashSet<>();
    for (Character character : answers.replaceAll("\n", "").toCharArray()) {
      uniqueAnswers.add(character);
    }
    return uniqueAnswers.size();
  }

  public int countUniquePositiveAnswers(List<String> answers) {
    return answers.stream().mapToInt(a -> countUniquePositiveAnswers(a)).sum();
  }

}
