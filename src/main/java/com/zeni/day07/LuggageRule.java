package com.zeni.day07;

import java.util.List;

public class LuggageRule {

  private String currentType;
  private List<LuggageRule> children;

  public LuggageRule(String currentType, List<LuggageRule> children) {
    this.currentType = currentType;
    this.children = children;
  }

  public List<LuggageRule> getChildren() {
    return children;
  }

  public void setChildren(List<LuggageRule> children) {
    this.children = children;
  }

  public String getCurrentType() {
    return currentType;
  }

  public void setCurrentType(String currentType) {
    this.currentType = currentType;
  }

}
