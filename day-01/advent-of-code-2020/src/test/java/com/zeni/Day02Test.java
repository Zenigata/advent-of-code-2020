package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Day02Test {
    @Test
    public void should_find_an_empty_policy_list() {

        List<Policy> policies = new ArrayList<>();

        int result = Day02.countValidPasswords(policies);
        assertEquals(0, result);
    }

    @Test
    public void should_find_a_valid_password() {

        List<Policy> policies = new ArrayList<>();
        Policy policy = new Policy(1, 3, "a", "abcde");
        policies.add(policy);

        int result = Day02.countValidPasswords(policies);
        assertEquals(1, result);
    }

    public void should_find_a_complex_solution_for_three() throws URISyntaxException, IOException {

        URL url = Thread.currentThread().getContextClassLoader().getResource("day02/input.txt");
        Path path = Paths.get(url.toURI());
        List<String> lines = Files.readAllLines(path);

        List<Integer> expenses = new ArrayList<>();
        for (String s : lines)
            expenses.add(Integer.valueOf(s));

        int result = Day01.multiplyThree(2020, expenses);
        assertEquals(92643264, result);
    }
}
