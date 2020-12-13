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

import com.zeni.day13.BusScheduling;
import com.zeni.day13.SchedulingOptimizer;

import org.junit.Test;

public class Day13Test {

    @Test
    public void should_do_the_easy_input() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/easy.txt"));
        long result = schedulingOptimizer.getProductOfBusIdAndWaitingMinutes();

        assertEquals(6, result);
    }

    @Test
    public void should_do_the_basic_input() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/basic.txt"));
        long result = schedulingOptimizer.getProductOfBusIdAndWaitingMinutes();

        assertEquals(295, result);
    }

    @Test
    public void should_do_the_complex_input() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/input.txt"));
        long result = schedulingOptimizer.getProductOfBusIdAndWaitingMinutes();

        assertEquals(4135, result);
    }

    private BusScheduling getInput(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());

        List<String> lines = Files.readAllLines(path);
        long departureTime = Long.parseLong(lines.get(0));

        List<Integer> busSchedules = new ArrayList<>();
        for (String bus : lines.get(1).split(",")) {
            if (!"x".equals(bus)) {
                busSchedules.add(Integer.parseInt(bus));
            }
        }

        return new BusScheduling(departureTime, busSchedules);
    }
}
