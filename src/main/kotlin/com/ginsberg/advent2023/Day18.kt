/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 18 - Lavaduct Lagoon
 * Problem Description: http://adventofcode.com/2023/day/18
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day18/
 */
package com.ginsberg.advent2023

import com.ginsberg.advent2023.Point2D.Companion.EAST
import com.ginsberg.advent2023.Point2D.Companion.NORTH
import com.ginsberg.advent2023.Point2D.Companion.ORIGIN
import com.ginsberg.advent2023.Point2D.Companion.SOUTH
import com.ginsberg.advent2023.Point2D.Companion.WEST

class Day18(private val input: List<String>) {

    fun solvePart1(): Long =
        calculateLava(input.map { parseRowPart1(it) })

    fun solvePart2(): Long =
        calculateLava(input.map { parseRowPart2(it) })

    private fun calculateLava(instructions: List<Pair<Point2D, Int>>): Long {
        val area = instructions
            .runningFold(ORIGIN) { acc, (direction, distance) ->
                acc + (direction * distance)
            }
            .zipWithNext()
            .sumOf { (a, b) ->
                (a.x.toLong() * b.y.toLong()) - (a.y.toLong() * b.x.toLong())
            } / 2
        val perimeter = instructions.sumOf { it.second }
        return area + (perimeter / 2) + 1
    }

    private fun parseRowPart1(input: String): Pair<Point2D, Int> =
        when (input[0]) {
            'U' -> NORTH
            'D' -> SOUTH
            'L' -> WEST
            'R' -> EAST
            else -> throw IllegalStateException("Bad direction $input")
        } to input.substringAfter(" ").substringBefore(" ").toInt()

    private fun parseRowPart2(input: String): Pair<Point2D, Int> =
        with(input.substringAfter("#").substringBefore(")")) {
            when (last()) {
                '0' -> EAST
                '1' -> SOUTH
                '2' -> WEST
                '3' -> NORTH
                else -> throw IllegalStateException("Bad direction $input")
            } to dropLast(1).toInt(16)
        }

}