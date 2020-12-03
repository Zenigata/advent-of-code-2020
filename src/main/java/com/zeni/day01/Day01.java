package com.zeni.day01;

import java.util.List;

public class Day01 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static int multiply(int sum, List<Integer> expenses) {
        for (int i = 0; i < expenses.size() - 1; i++) {
            int first = expenses.get(i);

            for (int j = 1; j < expenses.size(); j++) {
                int second = expenses.get(j);
                if (first + second == sum) {
                    return first * second;
                }
            }
        }

        return 0;
    }

    public static int multiplyThree(int sum, List<Integer> expenses) {
        for (int i = 0; i < expenses.size() - 2; i++) {
            int first = expenses.get(i);

            for (int j = 1; j < expenses.size() - 1; j++) {
                int second = expenses.get(j);

                for (int k = 0; k < expenses.size(); k++) {
                    int third = expenses.get(k);
                    if (first + second + third == sum) {
                        return first * second * third;
                    }
                }
            }
        }

        return 0;
    }
}
