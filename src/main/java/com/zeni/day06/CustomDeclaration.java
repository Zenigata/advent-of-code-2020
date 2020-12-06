package com.zeni.day06;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

  public int countFullPositiveAnswers(List<String> answers) {
    return answers.stream().mapToInt(a -> countFullPositiveAnswers(a)).sum();
  }

  private int countFullPositiveAnswers(String answers) {
    Set<Character> commonAnswers = new HashSet<>();
    String[] split = answers.split("\n");
    commonAnswers.addAll(split[0].chars().mapToObj(c -> (char) c).collect(Collectors.toList()));

    for (int i = 1; i < split.length; i++) {
      List<Character> chars = split[i].chars().mapToObj(c -> (char) c).collect(Collectors.toList());
      commonAnswers.retainAll(chars);
    }
    return commonAnswers.size();
  }

}
