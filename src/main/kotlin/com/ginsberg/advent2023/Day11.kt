/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 11 - Cosmic Expansion
 * Problem Description: http://adventofcode.com/2023/day/11
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day11/
 */
package com.ginsberg.advent2023

class Day11(input: List<String>) {

    private val galaxies: List<Point2D> = parseGalaxies(input)

    fun solvePart1(): Int =
        spreadGalaxies()
            .cartesianPairs()
            .sumOf { it.first.distanceTo(it.second) }

    fun solvePart2(expansion: Int): Long =
        spreadGalaxies(expansion)
            .cartesianPairs()
            .sumOf { it.first.distanceTo(it.second).toLong() }

    private fun spreadGalaxies(spreadFactor: Int = 2): List<Point2D> {
        val xOffsets = findEmptySpace { it.x }
        val yOffsets = findEmptySpace { it.y }

        return galaxies.map { point ->
            Point2D(
                x = point.x + (xOffsets[point.x] * (spreadFactor - 1)),
                y = point.y + (yOffsets[point.y] * (spreadFactor - 1))
            )
        }
    }

    private fun findEmptySpace(axis: (Point2D) -> Int): IntArray {
        val counts: Set<Int> = galaxies.map(axis).toSet()

        return IntArray(counts.max() + 1)
            .scanIndexed(if (0 in counts) 0 else 1) { index, acc, _ ->
                acc + if (index !in counts) 1 else 0
            }.toIntArray()
    }

    private fun parseGalaxies(input: List<String>): List<Point2D> =
        input.flatMapIndexed { y, row ->
            row.mapIndexedNotNull { x, c ->
                if (c == '#') Point2D(x, y)
                else null
            }
        }
}
