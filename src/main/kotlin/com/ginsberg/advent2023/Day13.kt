/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 13 - Point of Incidence
 * Problem Description: http://adventofcode.com/2023/day/13
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day13/
 */
package com.ginsberg.advent2023

import kotlin.math.absoluteValue

class Day13(input: List<String>) {

    private val patterns: List<List<String>> = parseInput(input)

    fun solvePart1(): Int =
        patterns.sumOf { findMirror(it, 0) }

    fun solvePart2(): Int =
        patterns.sumOf { findMirror(it, 1) }

    private fun findMirror(pattern: List<String>, goalTotal: Int): Int =
        findHorizontalMirror(pattern, goalTotal) ?:
        findVerticalMirror(pattern, goalTotal) ?:
        throw IllegalStateException("Pattern does not mirror")

    private fun findHorizontalMirror(pattern: List<String>, goalTotal: Int): Int? =
        (0 until pattern.lastIndex).firstNotNullOfOrNull { start ->
            if (createMirrorRanges(start, pattern.lastIndex)
                    .sumOf { (up, down) ->
                        pattern[up] diff pattern[down]
                    } == goalTotal
            ) (start + 1) * 100
            else null
        }

    private fun findVerticalMirror(pattern: List<String>, goalTotal: Int): Int? =
        (0 until pattern.first().lastIndex).firstNotNullOfOrNull { start ->
            if (createMirrorRanges(start, pattern.first().lastIndex)
                    .sumOf { (left, right) ->
                        pattern.columnToString(left) diff pattern.columnToString(right)
                    } == goalTotal
            ) start + 1
            else null
        }

    private infix fun String.diff(other: String): Int =
        indices.count { this[it] != other[it] } + (length - other.length).absoluteValue

    private fun createMirrorRanges(start: Int, max: Int): List<Pair<Int, Int>> =
        (start downTo 0).zip(start + 1..max)

    private fun List<String>.columnToString(column: Int): String =
        this.map { it[column] }.joinToString("")

    private fun parseInput(input: List<String>): List<List<String>> =
        input.joinToString("\n").split("\n\n").map { it.lines() }
}
