package org.okarmus;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by mateusz on 25.11.16.
 */
public class QuoteGenerator {

    private final Random random;
    private final List<String> quotesList;


    public QuoteGenerator() {
        this.random = new Random();
        quotesList = createListOfQuotes();
    }

    private List<String> createListOfQuotes() {
        return Arrays.asList("");
    }
}
