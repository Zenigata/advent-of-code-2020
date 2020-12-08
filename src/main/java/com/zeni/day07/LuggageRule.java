package com.zeni.day07;

import java.util.List;

public class LuggageRule {

  private BagType currentType;
  private List<LuggageRule> children;

  public LuggageRule(BagType currentType, List<LuggageRule> children) {
    this.currentType = currentType;
    this.children = children;
  }

  public List<LuggageRule> getChildren() {
    return children;
  }

  public void setChildren(List<LuggageRule> children) {
    this.children = children;
  }

  public BagType getCurrentType() {
    return currentType;
  }

  public void setCurrentType(BagType currentType) {
    this.currentType = currentType;
  }

}
