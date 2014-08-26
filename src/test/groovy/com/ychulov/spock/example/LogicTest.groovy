package com.ychulov.spock.example

import spock.lang.*

/**
 * Created by yuriy on 8/26/14.
 */

@Title("This is easy to read title")
@Narrative("""This is test narrative.
 It can be very-very long!
 I mean veeeeery long!""")
class LogicTest extends spock.lang.Specification {

    @Issue("http://my.issues.org/FOO-2")
    def "Check sum of 2 numbers"() {
        given: "Everything is OK"
        def a = 2
        def b = 3

        when: "We try to sum"
        def s = Logic.sum(a, b)

        then: "result is the following"
        s == 5
    }

    @Issue(["http://my.issues.org/FOO-3", "http://my.issues.org/FOO-4"])
    @See(["http://google.com", "http://spock-framework.readthedocs.org/en/latest/extensions.html"])
    def "this gonna fail"() {
        given:
        def a = 2
        def b = 3
        println "some output in test"

        when:
        def s = Logic.sum(a, b)
        System.err.println "some error output"
        System.err.println "and again error output"

        then:
        s == 4
    }

    @Issue("http://my.issues.org/FOO-5")
    @Unroll("maximum of #a and #b is #c")
    def "test unroll"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        3 | 7 | 7
        5 | 4 | 5
        9 | 9 | 9
    }
}
