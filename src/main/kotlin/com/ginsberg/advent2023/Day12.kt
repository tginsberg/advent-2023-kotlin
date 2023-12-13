/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 12 -Hot Springs
 * Problem Description: http://adventofcode.com/2023/day/12
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day12/
 */
package com.ginsberg.advent2023

class Day12(private val input: List<String>) {

    fun solvePart1(): Long =
        input
            .map { parseRow(it) }
            .sumOf { (springs, damage) -> countArrangements(springs, damage) }

    fun solvePart2(): Long =
        input
            .map { parseRow(it) }
            .map { unfold(it) }
            .sumOf { (springs, damage) -> countArrangements(springs, damage) }

    private fun countArrangements(
        springs: String,
        damage: List<Int>,
        cache: MutableMap<Pair<String, List<Int>>, Long> = HashMap()
    ): Long {
        val key = springs to damage
        cache[key]?.let {
            return it
        }
        if (springs.isEmpty()) return if (damage.isEmpty()) 1 else 0

        return when (springs.first()) {
            '.' -> countArrangements(springs.dropWhile { it == '.' }, damage, cache)

            '?' -> countArrangements(springs.substring(1), damage, cache) +
                    countArrangements("#${springs.substring(1)}", damage, cache)

            '#' -> when {
                damage.isEmpty() -> 0
                else -> {
                    val thisDamage = damage.first()
                    val remainingDamage = damage.drop(1)
                    if (thisDamage <= springs.length && springs.take(thisDamage).none { it == '.' }) {
                        when {
                            thisDamage == springs.length -> if (remainingDamage.isEmpty()) 1 else 0
                            springs[thisDamage] == '#' -> 0
                            else -> countArrangements(springs.drop(thisDamage + 1), remainingDamage, cache)
                        }
                    } else 0
                }
            }

            else -> throw IllegalStateException("Invalid springs: $springs")
        }.apply {
            cache[key] = this
        }
    }

    private fun unfold(input: Pair<String, List<Int>>): Pair<String, List<Int>> =
        (0..4).joinToString("?") { input.first } to (0..4).flatMap { input.second }

    private fun parseRow(input: String): Pair<String, List<Int>> =
        input.split(" ").run {
            first() to last().split(",").map { it.toInt() }
        }
}
