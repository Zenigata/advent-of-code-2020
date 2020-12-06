package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.zeni.day06.CustomDeclaration;

import org.junit.Test;

public class Day06Test {
    @Test
    public void should_count_answers_from_one_person() throws URISyntaxException, IOException {
        CustomDeclaration declaration = new CustomDeclaration();

        int result = declaration.countUniquePositiveAnswers("abcx");
        assertEquals(4, result);
    }

    @Test
    public void should_count_answers_from_one_person_with_duplicates() throws URISyntaxException, IOException {
        CustomDeclaration declaration = new CustomDeclaration();

        int result = declaration.countUniquePositiveAnswers("abcxabcxy");
        assertEquals(5, result);
    }

    @Test
    public void should_count_answers_from_one_group() throws URISyntaxException, IOException {
        CustomDeclaration declaration = new CustomDeclaration();

        int result = declaration.countUniquePositiveAnswers("abcx\nabcy\nabcz");
        assertEquals(6, result);
    }

    @Test
    public void should_count_answers_from_multiple_groups() throws URISyntaxException, IOException {
        CustomDeclaration declaration = new CustomDeclaration();

        List<String> answers = getFilledForms("day06/basic.txt");

        int result = declaration.countUniquePositiveAnswers(answers);
        assertEquals(11, result);
    }

    @Test
    public void should_count_answers_from_all_groups() throws URISyntaxException, IOException {
        CustomDeclaration declaration = new CustomDeclaration();

        List<String> answers = getFilledForms("day06/input.txt");

        int result = declaration.countUniquePositiveAnswers(answers);
        assertEquals(6714, result);
    }

    private List<String> getFilledForms(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());
        String text = new String(Files.readAllBytes(path));

        return Arrays.asList(text.split("\n\n"));
    }
}
