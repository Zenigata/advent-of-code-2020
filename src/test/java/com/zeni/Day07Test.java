package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zeni.day07.Day07;
import com.zeni.day07.LuggageProcessing;
import com.zeni.day07.LuggageRule;

import org.junit.Test;

public class Day07Test {

    @Test
    public void should_have_no_rule() throws URISyntaxException, IOException {
        LuggageProcessing luggageProcessing = new LuggageProcessing(getRules("day07/one.txt"));

        long result = luggageProcessing.findUniqueContainersFor("shiny gold");
        assertEquals(0, result);
    }

    @Test
    public void should_have_some_rules() throws URISyntaxException, IOException {
        LuggageProcessing luggageProcessing = new LuggageProcessing(getRules("day07/basic.txt"));

        long result = luggageProcessing.findUniqueContainersFor("shiny gold");
        assertEquals(4, result);
    }

    @Test
    public void should_have_a_lot_of_rules() throws URISyntaxException, IOException {
        LuggageProcessing luggageProcessing = new LuggageProcessing(getRules("day07/input.txt"));

        long result = luggageProcessing.findUniqueContainersFor("shiny gold");
        assertEquals(19, result);
    }

    @Test
    public void should_verify_another_implementation_part_1() throws URISyntaxException, IOException {
        List<String> allBags = getRules2("day07/input.txt");
        Day07 day = new Day07();
        long result = day.bagThatCouldCarryAShinyGoldBag(allBags);
        assertEquals(289, result);
    }

    @Test
    public void should_verify_another_implementation_part_2() throws URISyntaxException, IOException {
        List<String> allBags = getRules2("day07/input.txt");
        Day07 day = new Day07();
        int result = day.bagsInOneShinyGoldBag(allBags);
        assertEquals(30055, result);
    }

    private List<String> getRules2(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());

        return Files.readAllLines(path);
    }

    private Map<String, List<LuggageRule>> getRules(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());

        Map<String, List<LuggageRule>> rules = new HashMap<>();

        for (String raw : Files.readAllLines(path)) {
            List<LuggageRule> children = new ArrayList<>();
            if (!raw.contains("contain no other bags")) {
                String[] split = raw.substring(raw.indexOf("contain") + 7).split(",");
                for (String ruleRaw : split) {
                    String text = ruleRaw.trim();
                    LuggageRule rule = new LuggageRule(text.substring(text.indexOf(" ") + 1, text.indexOf(" bag")),
                            new ArrayList<>());
                    children.add(rule);
                }
            }
            rules.put(raw.substring(0, raw.indexOf(" bags")), children);
        }

        return rules;
    }
}
