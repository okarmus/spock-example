package org.okarmus;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by mateusz on 25.11.16.
 */
public class QuoteGenerator {

    private final Random random;
    private final List<String> quotes;


    public QuoteGenerator(List<String> quotes, Random random) {
        this.random = random;
        this.quotes = quotes;
    }

    public String getRandomQuote() {
        int quotesSize = quotes.size();
        int selectedQuote = random.nextInt(quotesSize - 1);
        return quotes.get(selectedQuote);
    }
}
