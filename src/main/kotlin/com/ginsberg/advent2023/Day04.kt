/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 4 - Scratchcards
 * Problem Description: http://adventofcode.com/2023/day/4
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day4/
 */
package com.ginsberg.advent2023

import kotlin.math.pow

class Day04(input: List<String>) {

    private val cardMatches = input.map { parseCard(it) }

    fun solvePart1(): Int =
        cardMatches.sumOf { 2.0.pow(it-1).toInt() }

    fun solvePart2(): Int {
        val cards = IntArray(cardMatches.size) { 1 }
        cardMatches.forEachIndexed { index, score ->
            repeat(score) {
                cards[index+it+1] += cards[index]
            }
        }
        return cards.sum()
    }

    private fun parseCard(input: String): Int {
        val winningNumbers = input.substringAfter(":").substringBefore("|").split(" ").filter { it.isNotEmpty() }.toSet()
        val ourNumbers = input.substringAfter("|").split(" ").filter { it.isNotEmpty() }.toSet()
        return winningNumbers.intersect(ourNumbers).size
    }
}