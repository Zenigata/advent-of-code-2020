package com.zeni;

import java.util.List;

public class Day {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int multiply(int sum, List<Integer> expenses) {
        if (expenses.get(0) + expenses.get(1) == sum) {
            return expenses.get(0) * expenses.get(1);
        }
        return 0;
    }
}
