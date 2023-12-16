/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 16 - The Floor Will Be Lava
 * Problem Description: http://adventofcode.com/2023/day/16
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day156/
 */
package com.ginsberg.advent2023

import com.ginsberg.advent2023.Point2D.Companion.EAST
import com.ginsberg.advent2023.Point2D.Companion.NORTH
import com.ginsberg.advent2023.Point2D.Companion.SOUTH
import com.ginsberg.advent2023.Point2D.Companion.WEST

class Day16(input: List<String>) {

    private val grid: Array<CharArray> =
        input.map { it.toCharArray() }.toTypedArray()

    private val movements = mapOf(
        '-' to NORTH to listOf(EAST, WEST),
        '-' to SOUTH to listOf(EAST, WEST),
        '|' to EAST to listOf(NORTH, SOUTH),
        '|' to WEST to listOf(NORTH, SOUTH),
        '\\' to NORTH to listOf(WEST),
        '\\' to WEST to listOf(NORTH),
        '\\' to SOUTH to listOf(EAST),
        '\\' to EAST to listOf(SOUTH),
        '/' to NORTH to listOf(EAST),
        '/' to WEST to listOf(SOUTH),
        '/' to SOUTH to listOf(WEST),
        '/' to EAST to listOf(NORTH)
    )

    fun solvePart1(): Int =
        energize(Point2D(0, 0), EAST)

    fun solvePart2(): Int =
        listOf(
            grid.first().indices.map { Point2D(it, 0) to SOUTH },
            grid.first().indices.map { Point2D(it, grid.lastIndex) to NORTH },
            grid.indices.map { Point2D(0, it) to EAST },
            grid.indices.map { Point2D(grid.first().lastIndex, it) to WEST }
        )
            .flatten()
            .maxOf { energize(it.first, it.second) }


    private fun energize(startPoint: Point2D, startDirection: Point2D): Int {
        val seen = mutableSetOf(startPoint to startDirection)
        val queue = ArrayDeque<Pair<Point2D, Point2D>>().apply {
            add(startPoint to startDirection)
        }
        while (queue.isNotEmpty()) {
            val (place, direction) = queue.removeFirst()
            val nextDirections = movements[grid[place] to direction] ?: listOf(direction)
            nextDirections.forEach { nextDirection ->
                val nextPlace = place + nextDirection
                val nextPair = nextPlace to nextDirection
                if (nextPair !in seen && grid.isSafe(nextPlace)) {
                    queue.add(nextPair)
                    seen += nextPair
                }
            }
        }

        return seen.map { it.first }.toSet().size
    }
}
