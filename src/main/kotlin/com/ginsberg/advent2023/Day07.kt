/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 7 - Camel Cards
 * Problem Description: http://adventofcode.com/2023/day/7
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day7/
 */
package com.ginsberg.advent2023

class Day07(private val input: List<String>) {

    fun solvePart1(): Int =
        playCamelCards()

    fun solvePart2(): Int =
        playCamelCards(true)

    private fun playCamelCards(jokersWild: Boolean = false): Int =
        input
            .asSequence()
            .map { row -> row.split(" ") }
            .map { parts -> Hand(parts.first(), parts.last().toInt(), jokersWild) }
            .sorted()
            .mapIndexed { index, hand -> hand.bid * (index + 1) }
            .sum()

    private class Hand(cards: String, val bid: Int, jokersWild: Boolean) : Comparable<Hand> {
        private val identity: Int = calculateIdentity(
            cards,
            if (jokersWild) STRENGTH_WITH_JOKERS else STRENGTH_WITHOUT_JOKERS,
            if (jokersWild) this::calculateCategoryWithJokers else this::calculateCategoryWithoutJokers
        )

        private fun calculateIdentity(
            cards: String,
            strength: String,
            categoryCalculation: (String) -> List<Int>
        ): Int {
            val category = categoryCalculation(cards)
            return cards.fold(CATEGORIES.indexOf(category)) { acc, card ->
                (acc shl 4) or strength.indexOf(card)
            }
        }

        private fun calculateCategoryWithoutJokers(cards: String): List<Int> =
            cards.groupingBy { it }.eachCount().values.sortedDescending()

        private fun calculateCategoryWithJokers(cards: String): List<Int> {
            val cardsWithoutJokers = cards.filterNot { it == 'J' }
            val numberOfJokers = cards.length - cardsWithoutJokers.length

            return if (numberOfJokers == 5) listOf(5)
            else calculateCategoryWithoutJokers(cardsWithoutJokers).toMutableList().apply {
                this[0] += numberOfJokers
            }
        }

        override fun compareTo(other: Hand): Int =
            this.identity - other.identity

        companion object {
            private val CATEGORIES = listOf(
                listOf(1, 1, 1, 1, 1),
                listOf(2, 1, 1, 1),
                listOf(2, 2, 1),
                listOf(3, 1, 1),
                listOf(3, 2),
                listOf(4, 1),
                listOf(5)
            )

            private const val STRENGTH_WITHOUT_JOKERS = "23456789TJQKA"
            private const val STRENGTH_WITH_JOKERS = "J23456789TQKA"
        }
    }
}
