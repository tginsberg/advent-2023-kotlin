/*
 * Copyoutgoing (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 5 - If You Give A Seed A Fertilizer
 * Problem Description: http://adventofcode.com/2023/day/5
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day5/
 */
package com.ginsberg.advent2023

class Day05(input: List<String>) {

    private val seedsPart1: List<Long> = parsePart1Seeds(input)
    private val seedsPart2: Set<LongRange> = parsePart2Seeds(input)
    private val ranges = parseRanges(input)

    fun solvePart1(): Long =
        seedsPart1.minOf { seed ->
            ranges.fold(seed) { acc, ranges ->
                ranges.firstOrNull { acc in it }?.translate(acc) ?: acc
            }
        }

    fun solvePart2(): Long {
        val rangesReversed = ranges.map { range -> range.map { it.flip() } }.reversed()
        return generateSequence(0L, Long::inc).first { location ->
            val seed = rangesReversed.fold(location) { acc, ranges ->
                ranges.firstOrNull { acc in it }?.translate(acc) ?: acc
            }
            seedsPart2.any { seedRange -> seed in seedRange }
        }
    }

    private fun parseRanges(input: List<String>): List<Set<RangePair>> =
        input.drop(2).joinToString("\n").split("\n\n").map {
            it.split("\n").drop(1).map { line -> RangePair.of(line) }.toSet()
        }

    private fun parsePart1Seeds(input: List<String>): List<Long> =
        input.first().substringAfter(":").trim().split(" ").map { it.toLong() }

    private fun parsePart2Seeds(input: List<String>): Set<LongRange> =
        input.first().substringAfter(":").trim().split(" ")
            .map { it.toLong() }.chunked(2).map {
                it.first()..<it.first() + it.last()
            }.toSet()

    private data class RangePair(
        private val source: LongRange,
        private val destination: LongRange
    ) {
        fun flip(): RangePair =
            RangePair(destination, source)

        fun translate(num: Long): Long =
            destination.first + (num - source.first)

        operator fun contains(num: Long): Boolean =
            num in source

        companion object {
            fun of(row: String): RangePair {
                val parts = row.split(" ").map { it.toLong() }
                return RangePair(
                    parts[1]..<(parts[1] + parts[2]),
                    parts[0]..<(parts[0] + parts[2])
                )
            }
        }
    }
}