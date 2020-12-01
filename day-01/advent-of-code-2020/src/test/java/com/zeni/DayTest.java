package com.zeni;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DayTest {
    @Test
    public void should_not_find_any_solution() {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(500);
        expenses.add(1000);
        int result = Day.multiply(2000, expenses);
        assertEquals(0, result);
    }

    @Test
    public void should_not_find_any_solution2() {
        List<Integer> expenses = new ArrayList<>();
        expenses.add(500);
        expenses.add(1500);
        int result = Day.multiply(2000, expenses);
        assertEquals(750000, result);
    }
}
