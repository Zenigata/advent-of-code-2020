package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.zeni.day14.BitmaskSystem;
import com.zeni.day14.InitializingProgram;
import com.zeni.day14.MemoryValue;

import org.junit.Test;

public class Day14Test {

    @Test
    public void should_do_the_easy_input() throws URISyntaxException, IOException {
        BitmaskSystem bitmaskSystem = new BitmaskSystem();
        long result = bitmaskSystem.getValueInMemoryAfterLoading(getInput("day14/easy.txt"));

        assertEquals(0, result);
    }

    @Test
    public void should_do_the_basic_input() throws URISyntaxException, IOException {
        BitmaskSystem bitmaskSystem = new BitmaskSystem();
        long result = bitmaskSystem.getValueInMemoryAfterLoading(getInput("day14/basic.txt"));

        assertEquals(165, result);
    }

    @Test
    public void should_do_the_complex_input() throws URISyntaxException, IOException {
        BitmaskSystem bitmaskSystem = new BitmaskSystem();
        long result = bitmaskSystem.getValueInMemoryAfterLoading(getInput("day14/input.txt"));

        assertEquals(17481577045893l, result);
    }

    private InitializingProgram getInput(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());

        List<String> lines = Files.readAllLines(path);
        Map<String, List<MemoryValue>> program = new LinkedHashMap<>();
        String bitmask = lines.get(0).substring(7);

        List<MemoryValue> values = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.startsWith("mask")) {
                program.put(bitmask, values);
                values = new ArrayList<>();
                bitmask = line.substring(7);
            } else {
                MemoryValue value = new MemoryValue(Integer.parseInt(line.substring(4, line.indexOf("]"))),
                        Long.parseLong(line.substring(line.indexOf("= ") + 2)));
                values.add(value);
            }
        }
        program.put(bitmask, values);

        System.out.println(program.keySet().size());
        return new InitializingProgram(program);
    }
}
