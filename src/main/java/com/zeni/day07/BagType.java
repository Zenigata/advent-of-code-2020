package com.zeni.day07;

public enum BagType {
  LightRed, DarkOrange, BrightWhite, MutedYellow, ShinyGold, DarkOlive, VibrantPlume, FadedBlue, DottedBlack;

  private BagType() {
  }

  public static BagType get(String name) {
    switch (name) {
      case "light red":
        return LightRed;

      case "dark orange":
        return DarkOrange;

      case "bright white":
        return BrightWhite;

      case "muted yellow":
        return MutedYellow;

      case "shiny gold":
        return ShinyGold;

      case "dark olive":
        return DarkOlive;

      case "vibrant plum":
        return VibrantPlume;

      case "faded blue":
        return FadedBlue;

      case "dotted black":
        return DottedBlack;

      default:
        return null;
    }
  }

}
