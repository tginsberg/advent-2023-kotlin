/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 1 - Trebuchet?!
 * Problem Description: http://adventofcode.com/2023/day/1
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day1/
 */
package com.ginsberg.advent2023

class Day01(private val input: List<String>) {

    private val words: Map<String, Int> = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
    )

    fun solvePart1(): Int =
        input.sumOf { calibrationValue(it) }

    fun solvePart2(): Int =
        input.sumOf { row ->
           calibrationValue(
                // Run through each character and turn it into a digit or a null,
                // and then map each of them to a String. In theory, we could take
                // the first and last digits from the resulting list instead of joining.
                row.mapIndexedNotNull { index, c ->
                    // If it is a digit, take it as-is
                    if (c.isDigit()) c
                    else
                        // Otherwise, see if this is the start of a word and if so map to the
                        // digit that it represents.
                        row.possibleWordsAt(index).firstNotNullOfOrNull { candidate ->
                            words[candidate]
                        }
                }.joinToString()
            )
        }

    private fun calibrationValue(row: String): Int =
        "${row.first { it.isDigit() }}${row.last { it.isDigit() }}".toInt()

    private fun String.possibleWordsAt(startingAt: Int): List<String> =
        (3..5).map { len ->
            substring(startingAt, (startingAt + len).coerceAtMost(length))
        }
}