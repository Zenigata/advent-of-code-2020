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

    @Test
    public void should_find_a_basic_solution() {

        List<Policy> policies = new ArrayList<>();
        policies.add(new Policy(1, 3, "a", "abcde"));
        policies.add(new Policy(1, 3, "b", "cdefg"));
        policies.add(new Policy(2, 9, "c", "ccccccccc"));

        int result = Day02.countValidPasswords(policies);
        assertEquals(2, result);
    }

    @Test
    public void should_find_a_complex_solution() throws URISyntaxException, IOException {

        URL url = Thread.currentThread().getContextClassLoader().getResource("day02/input.txt");
        Path path = Paths.get(url.toURI());
        List<String> lines = Files.readAllLines(path);

        List<Policy> policies = new ArrayList<>();
        for (String s : lines) {
            int min = Integer.valueOf(s.substring(0, s.indexOf("-")));
            int max = Integer.valueOf(s.substring(s.indexOf("-") + 1, s.indexOf(" ")));
            String character = s.substring(s.indexOf(" ") + 1, s.indexOf(" ") + 2);
            String password = s.substring(s.indexOf(": ") + 2);

            policies.add(new Policy(min, max, character, password));
        }

        int result = Day02.countValidPasswords(policies);
        assertEquals(500, result);
    }

    @Test
    public void should_find_a_basic_solution_new_policy() {

        List<Policy> policies = new ArrayList<>();
        policies.add(new Policy(1, 3, "a", "abcde"));
        policies.add(new Policy(1, 3, "b", "cdefg"));
        policies.add(new Policy(2, 9, "c", "ccccccccc"));

        int result = Day02.countValidPasswordsNewPolicy(policies);
        assertEquals(1, result);
    }

    @Test
    public void should_find_a_complex_solution_new_policy() throws URISyntaxException, IOException {

        URL url = Thread.currentThread().getContextClassLoader().getResource("day02/input.txt");
        Path path = Paths.get(url.toURI());
        List<String> lines = Files.readAllLines(path);

        List<Policy> policies = new ArrayList<>();
        for (String s : lines) {
            int min = Integer.valueOf(s.substring(0, s.indexOf("-")));
            int max = Integer.valueOf(s.substring(s.indexOf("-") + 1, s.indexOf(" ")));
            String character = s.substring(s.indexOf(" ") + 1, s.indexOf(" ") + 2);
            String password = s.substring(s.indexOf(": ") + 2);

            policies.add(new Policy(min, max, character, password));
        }

        int result = Day02.countValidPasswordsNewPolicy(policies);
        assertEquals(313, result);
    }
}
