package com.zeni.day07;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// This is not my solution
public class Day07 {

  public long bagThatCouldCarryAShinyGoldBag(List<String> allBags) {
    var bagNameToContent = allBags.stream().map(bag -> bag.split(" bags contain"))
        .collect(Collectors.toMap(split -> split[0], split -> split[1]));
    var allBagsThatCanContainShinyGoldBags = bagNameToContent.entrySet().stream()
        .filter(bag -> bag.getValue().contains("shiny gold")).map(Map.Entry::getKey).collect(Collectors.toSet());
    return recursivelyFindShinyGoldHolder(allBagsThatCanContainShinyGoldBags, bagNameToContent).size();
  }

  private Set<String> recursivelyFindShinyGoldHolder(Set<String> allThatCanContainSGB, final Map<String, String> bags) {
    var newValues = allThatCanContainSGB.stream()
        .flatMap(
            color -> bags.entrySet().stream().filter(line -> line.getValue().contains(color)).map(Map.Entry::getKey))
        .collect(Collectors.toSet());
    return allThatCanContainSGB.addAll(newValues) ? recursivelyFindShinyGoldHolder(allThatCanContainSGB, bags)
        : allThatCanContainSGB;
  }

  public int bagsInOneShinyGoldBag(List<String> allBags) {
    return bagsInOne("shiny gold", allBags);
  }

  private int bagsInOne(String bagColor, List<String> allBags) {
    return allBags.stream().filter(line -> line.startsWith(bagColor + " bags contain")).map(BAG_WITH_CONTENT::matcher)
        .flatMap(Matcher::results)
        .mapToInt(matcher -> Integer.parseInt(matcher.group(2)) * (1 + bagsInOne(matcher.group(3), allBags))).sum();

  }

  private static final Pattern BAG_WITH_CONTENT = Pattern.compile("(.?(\\d+) (\\w+ \\w+) bags?,?)");

}
