package org.okarmus

import spock.lang.Specification

/**
 * Created by mateusz on 25.11.16.
 */
class QuoteGeneratorTest extends Specification {

    QuoteGenerator underTest


    def "should test using mock method" () {
        given:
            List<String> quotes = createListOfQuotes()

            Random random = Mock()                      //mock creation
            random.nextInt(quotes.size()-1) >> drawn    //specifying behaviour of mock method
            underTest = new QuoteGenerator(quotes, random)
        expect:
            underTest.getRandomQuote() == quotes.get(drawn)
        where:
            drawn << [1,2,3,0]
    }


    def "should test using stub method" () {
        given:
            List<String> quotes = createListOfQuotes()

            Random random = Stub()                       //stub creation
            random.nextInt(quotes.size()-1) >> drawn    //specifying behaviour of mock method
            underTest = new QuoteGenerator(quotes, random)
        expect:
            underTest.getRandomQuote() == quotes.get(drawn)
        where:
            drawn << [1,2,3,0]
    }

    def "should test using spy method" () {
        given:
        List<String> quotes = createListOfQuotes()

        Random random = Spy()                       //spu creation
        random.nextInt(quotes.size()-1) >> drawn    //specifying behaviour of mock method
        underTest = new QuoteGenerator(quotes, random)
        expect:
        underTest.getRandomQuote() == quotes.get(drawn)

        System.out.println(random.nextInt())
        System.out.println(random.nextInt(12))

        where:
            drawn << [1,2,3,0]
    }

    def "should test using multiple invocation method" () {
        given:
            Random random = Mock()
            random.nextInt(12) >>> [1,2,3,0]
        when:
            random.nextInt(12) == 1
            random.nextInt(12) == 2
            random.nextInt(12) == 3
            random.nextInt(12) == 0
        then:
            4 * random.nextInt(12)
            !random.nextInt(10)
    }

    List<String> createListOfQuotes() {
        return ["You can do anything, but not everything.",
                "The richest man is not he who has the most, but he who needs the least.",
                "You must be the change you wish to see in the world.",
                "A wise man gets more use from his enemies than a fool from his friends.",
                "Do not seek to follow in the footsteps of the men of old; seek what they sought"] as List;
        }
}
