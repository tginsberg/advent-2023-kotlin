/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 17 - Clumsy Crucible
 * Problem Description: http://adventofcode.com/2023/day/17
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day17/
 */
package com.ginsberg.advent2023

import com.ginsberg.advent2023.Point2D.Companion.EAST
import com.ginsberg.advent2023.Point2D.Companion.NORTH
import com.ginsberg.advent2023.Point2D.Companion.SOUTH
import com.ginsberg.advent2023.Point2D.Companion.WEST
import java.util.PriorityQueue


class Day17(input: List<String>) {

    private val grid = input.map { row -> row.map { it.digitToInt() } }
    private val directions = mapOf(
        NORTH to setOf(NORTH, EAST, WEST),
        WEST to setOf(WEST, NORTH, SOUTH),
        SOUTH to setOf(SOUTH, EAST, WEST),
        EAST to setOf(EAST, NORTH, SOUTH)
    )

    fun solvePart1(): Int =
        calculateHeatLoss { state, nextDirection ->
            state.steps < 3 || state.direction != nextDirection
        }

    fun solvePart2(): Int =
        calculateHeatLoss(4) { state, nextDirection ->
            if (state.steps > 9) state.direction != nextDirection
            else if (state.steps < 4) state.direction == nextDirection
            else true
        }

    private fun calculateHeatLoss(minSteps: Int = 1, isValidNextMove: (State, Point2D) -> Boolean): Int {
        val goal = Point2D(grid.first().lastIndex, grid.lastIndex)
        val seen = mutableSetOf<State>()
        val queue = PriorityQueue<Work>()

        State(Point2D(0, 0), EAST, 0).apply {
            queue += Work(this, 0)
            seen += this
        }

        while (queue.isNotEmpty()) {
            val (current, heatLoss) = queue.poll()
            if (current.location == goal && current.steps >= minSteps) return heatLoss

            directions
                .getValue(current.direction)
                .filter { direction -> grid.isSafe(current.location + direction) }
                .filter { direction -> isValidNextMove(current, direction) }
                .map { direction -> current.next(direction) }
                .filterNot { state -> state in seen }
                .forEach { state ->
                    queue += Work(state, heatLoss + grid[state.location])
                    seen += state
                }
        }
        throw IllegalStateException("No route to goal")
    }

    private data class State(val location: Point2D, val direction: Point2D, val steps: Int) {
        fun next(nextDirection: Point2D): State =
            State(location+nextDirection, nextDirection, if(direction == nextDirection) steps+1 else 1)
    }

    private data class Work(val state: State, val heatLoss: Int) : Comparable<Work> {
        override fun compareTo(other: Work): Int =
            heatLoss - other.heatLoss
    }
}