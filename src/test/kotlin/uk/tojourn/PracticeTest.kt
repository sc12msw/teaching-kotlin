package uk.tojourn


import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

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
           // row(mutableListOf(0, 0, 0, 0, 0), mutableListOf(0, 1, 0, 1, 0)),
        ) { input, expected ->
            extractor.processList(input) shouldBe expected

        }
    }
})

