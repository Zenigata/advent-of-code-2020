package com.zeni.day07;

import java.util.List;
import java.util.Map;

public class LuggageProcessing {

  private Map<BagType, List<LuggageRule>> luggageRules;

  public LuggageProcessing(Map<BagType, List<LuggageRule>> luggageRules) {
    this.luggageRules = luggageRules;
  }

  public long findUniqueContainersFor(BagType typeToFind) {
    return luggageRules.values().stream().mapToInt(r -> hasBagType(r, typeToFind)).sum();
  }

  int hasBagType(List<LuggageRule> rules, BagType typeToFind) {
    if (rules.size() != 0) {
      for (LuggageRule child : rules) {
        if (child.getCurrentType() == typeToFind) {
          return 1;
        } else {
          return hasBagType(luggageRules.get(child.getCurrentType()), typeToFind);
        }
      }
    }
    return 0;
  }

}
