package uk.tojourn


import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.lang.Exception

class PracticeTest() : StringSpec({
    val extractor = Practice()

    "given string never allows b to proceed a " {
        forAll(
            row("aabbb", true),
            row("ba", false),
            row("aaa", true),
            row("b", true),
            row("abba", false),
            row("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", true),
            row("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaba", false),
        ) { input, expected ->
            extractor.checkPattern(input) shouldBe expected
        }
    }

    "given a list of binary then the 1 and 0s always alternate"{
        forAll(
            row(mutableListOf(0, 1, 0, 0, 1), mutableListOf(0, 1, 0, 1, 0)),
            row(mutableListOf(1, 1, 1, 1, 1), mutableListOf(1, 0, 1, 0, 1)),
            row(mutableListOf(0, 0, 0, 0, 0), mutableListOf(0, 1, 0, 1, 0)),
        ) { input, expected ->
            extractor.processList(input) shouldBe expected

        }
    }
    "given numbers in list are not 1s or 0s" {
        shouldThrow<Exception> {
            // code in here that you expect to throw an IllegalAccessException
            extractor.processList(mutableListOf(7, 2, 1, 0, 8))
        }
    }
})

