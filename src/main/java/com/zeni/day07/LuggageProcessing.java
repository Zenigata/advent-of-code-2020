package com.zeni.day07;

import java.util.List;
import java.util.Map;

public class LuggageProcessing {

  private Map<String, List<LuggageRule>> luggageRules;

  public LuggageProcessing(Map<String, List<LuggageRule>> luggageRules) {
    this.luggageRules = luggageRules;
  }

  public long findUniqueContainersFor(String typeToFind) {
    return luggageRules.values().stream().mapToInt(r -> hasBagType(r, typeToFind)).sum();
  }

  int hasBagType(List<LuggageRule> rules, String typeToFind) {
    if (rules.size() != 0) {
      for (LuggageRule child : rules) {
        if (typeToFind.equals(child.getCurrentType())) {
          return 1;
        } else {
          return hasBagType(luggageRules.get(child.getCurrentType()), typeToFind);
        }
      }
    }
    return 0;
  }

}
