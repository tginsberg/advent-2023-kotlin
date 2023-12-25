/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 21 - Step Counter
 * Problem Description: http://adventofcode.com/2023/day/21
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day21/
 */
package com.ginsberg.advent2023

class Day21(input: List<String>) {

    private val gardenMap: Array<CharArray> = input.map { it.toCharArray() }.toTypedArray()
    private val start: Point2D = gardenMap.mapIndexedNotNull { y, row ->
        if ('S' in row) Point2D(row.indexOf('S'), y) else null
    }.first()

    fun solvePart1(goal: Int): Int =
        countSteps(goal).values.count { it % 2 == 0 }

    // Thanks https://github.com/villuna
    // @see https://github.com/villuna/aoc23/wiki/A-Geometric-solution-to-advent-of-code-2023,-day-21
    fun solvePart2(stepCount: Int): Long {
        val steps = countSteps()
        val oddCorners = steps.count { it.value % 2 == 1 && it.value > 65 }.toLong()
        val evenCorners = steps.count { it.value % 2 == 0 && it.value > 65 }.toLong()
        val evenBlock = steps.values.count { it % 2 == 0 }.toLong()
        val oddBlock = steps.values.count { it % 2 == 1 }.toLong()
        val n: Long = ((stepCount.toLong() - (gardenMap.size / 2)) / gardenMap.size)

        val even: Long = n * n
        val odd: Long = (n + 1) * (n + 1)
        return (odd * oddBlock) + (even * evenBlock) - ((n + 1) * oddCorners) + (n * evenCorners)
    }

    private fun countSteps(max: Int = gardenMap.size): Map<Point2D, Int> = buildMap {
        val queue = ArrayDeque<Pair<Point2D, Int>>().apply {
            add(start to 0)
        }
        while (queue.isNotEmpty()) {
            queue.removeFirst().let { (location, distance) ->
                if (location !in this && distance <= max) {
                    this[location] = distance
                    queue.addAll(
                        location
                            .cardinalNeighbors()
                            .filter { it !in this }
                            .filter { gardenMap.isSafe(it) }
                            .filter { gardenMap[it] != '#' }
                            .map { it to distance + 1 }
                    )
                }
            }
        }
    }
}