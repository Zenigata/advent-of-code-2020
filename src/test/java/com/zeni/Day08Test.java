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

import com.zeni.day08.BootCode;
import com.zeni.day08.Instruction;
import com.zeni.day08.Operation;

import org.junit.Test;

public class Day08Test {

    @Test
    public void should_have_no_loop() throws URISyntaxException, IOException {
        BootCode bootCode = new BootCode();

        int result = bootCode.showTheAccumulatorValueWhenLoopStartsAgain(getInput("day08/simple.txt"));
        assertEquals(0, result);
    }

    @Test
    public void should_have_a_small_loop() throws URISyntaxException, IOException {
        BootCode bootCode = new BootCode();

        int result = bootCode.showTheAccumulatorValueWhenLoopStartsAgain(getInput("day08/basic.txt"));
        assertEquals(5, result);
    }

    @Test
    public void should_have_a_big_loop() throws URISyntaxException, IOException {
        BootCode bootCode = new BootCode();

        int result = bootCode.showTheAccumulatorValueWhenLoopStartsAgain(getInput("day08/input.txt"));
        assertEquals(1087, result);
    }

    @Test
    public void should_fix_the_small_loop() throws URISyntaxException, IOException {
        BootCode bootCode = new BootCode();

        int result = bootCode.showTheFinalAccumulatorValue(getInput("day08/basic.txt"));
        assertEquals(8, result);
    }

    @Test
    public void should_fix_the_big_loop() throws URISyntaxException, IOException {
        BootCode bootCode = new BootCode();

        int result = bootCode.showTheFinalAccumulatorValue(getInput("day08/input.txt"));
        assertEquals(780, result);
    }

    private List<Instruction> getInput(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());

        List<Instruction> instructions = new ArrayList<>();

        for (String line : Files.readAllLines(path)) {
            Operation operation = Operation.get(line.substring(0, 3));
            int argument = Integer.parseInt(line.substring(4).replace("+", ""));
            Instruction instruction = new Instruction(operation, argument);
            instructions.add(instruction);
        }

        return instructions;
    }
}
