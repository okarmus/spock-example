package org.okarmus

import spock.lang.Specification

/**
 * Created by mateusz on 14.11.16.
 */
class BasicCalculatorTest extends Specification {

    BasicCalculator underTest = new BasicCalculator()

    def setupSpec() {
        System.out.println("Setup spec method invoked once before whole suite")
    }

    def setup() {
        System.out.println("Setup method invoked before each method")
    }

    def cleanup() {
        System.out.println("Cleanup method invoked after each method")
    }

    def cleanupSpec() {
        System.out.println("Cleanup spec method invoked once after whole suite")
    }

    def "should add two numbers"() {
        setup:
            def x = 4
            def y = 6
            def expected = 10

        when:
            def actual = underTest.add(2, 8)
        then:
            actual == 10
            System.out.println("Add test invoked")

    }

    def "parametrized test" () {
        expect:
        underTest.add(first, second) == result

        where:
        first | second || result
        4     | 7      || 11
        3     | 5      || 8
        2     | 13     || 15
    }




    def "multiple when working"() {
        when:
        def actual = underTest.add(5, 6)
        then:
            actual == 11
        when:
            actual = actual = underTest.add(2, 3)
        then:
            actual == 5
    }


    def "multiple then working"() {
        when:
            def addResult = underTest.add(6, 5)

            def substractResult = underTest.minus(6,5)
        then:
            addResult == 11
        then:
            substractResult == 1
    }




    def "should subtract two numbers"() {
        given:
            def x = 4
            def y = 6
            def expected = -2
        when:
            def actual = underTest.minus(x, y)
        then:
            actual == expected
            System.out.println("Substract test invoked")
        when:
            actual = underTest.minus(x, y)
        then:
            actual == expected
        System.out.println("Substract test invoked")
    }
}
