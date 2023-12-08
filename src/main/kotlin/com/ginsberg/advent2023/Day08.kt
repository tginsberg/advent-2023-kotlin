/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 8 - Haunted Wasteland
 * Problem Description: http://adventofcode.com/2023/day/8
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day8/
 */
package com.ginsberg.advent2023

class Day08(input: List<String>) {

    private val instructions: String = input.first()
    private val routeMap: Map<String, Pair<String, String>> = parseRouteMap(input)

    fun solvePart1(): Int =
        countSteps("AAA")

    fun solvePart2(): Long =
        routeMap.keys
            .filter { it.endsWith("A") }
            .map { countSteps(it).toLong() }
            .reduce { prev, next -> prev.lcm(next) }

    private fun countSteps(start: String): Int {
        var steps = 0
        var current = start
        while (!current.endsWith("Z")) {
            current = routeMap.getValue(current).let { route ->
                val instruction = instructions[steps++ % instructions.length]
                if (instruction == 'L') route.first
                else route.second
            }
        }
        return steps
    }

    private fun parseRouteMap(input: List<String>): Map<String, Pair<String, String>> =
        input
            .drop(2)
            .associate {
                it.substring(0..2) to (it.substring(7..9) to it.substring(12..14))
            }
}
