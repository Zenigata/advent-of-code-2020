package com.zeni;

import org.apache.commons.lang3.StringUtils;

public class Policy {

  private int min;
  private int max;
  private String character;
  private String password;

  public Policy(int min, int max, String character, String password) {
    this.min = min;
    this.max = max;
    this.character = character;
    this.password = password;
  }

  boolean isValid() {
    int countMatches = StringUtils.countMatches(password, character);
    return countMatches >= min && countMatches <= max;
  }

  boolean isValidNewPolicy() {
    String first = password.substring(min-1, min);
    String second = password.substring(max-1, max);
    return (character.equals(first) && !character.equals(second))
        || (!character.equals(first) && character.equals(second));
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public String getCharacter() {
    return character;
  }

  public void setCharacter(String character) {
    this.character = character;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
