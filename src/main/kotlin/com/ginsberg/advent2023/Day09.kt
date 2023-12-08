/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 9 - Mirage Maintenance
 * Problem Description: http://adventofcode.com/2023/day/9
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day9/
 */
package com.ginsberg.advent2023

class Day09(input: List<String>) {

    private val rows: List<List<Int>> = input.map { it.split(" ").map { i -> i.toInt() } }

    fun solvePart1(): Int =
        rows.sumOf { extrapolate(it) }

    fun solvePart2(): Int =
        rows.map { it.reversed() }.sumOf { extrapolate(it) }

    private fun extrapolate(row: List<Int>): Int =
        if (row.all { it == 0 }) 0
        else {
            val differences = row.windowed(2, 1).map { it[1] - it[0] }
            row.last() + extrapolate(differences)
        }
}
