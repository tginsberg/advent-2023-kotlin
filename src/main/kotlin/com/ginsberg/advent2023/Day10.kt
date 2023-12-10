/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 10 - Pipe Maze
 * Problem Description: http://adventofcode.com/2023/day/10
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day10/
 */
package com.ginsberg.advent2023

import com.ginsberg.advent2023.Point2D.Companion.EAST
import com.ginsberg.advent2023.Point2D.Companion.NORTH
import com.ginsberg.advent2023.Point2D.Companion.SOUTH
import com.ginsberg.advent2023.Point2D.Companion.WEST

class Day10(input: List<String>) {

    private val grid: Array<CharArray> = input.map { it.toCharArray() }.toTypedArray()
    private val start: Point2D = grid.indexOfFirst { 'S' in it }.let { y ->
        Point2D(grid[y].indexOf('S'), y)
    }

    fun solvePart1(): Int =
        traversePipe().size / 2

    fun solvePart2(): Int {
        val pipe = traversePipe()

        grid.forEachIndexed { y, row ->
            row.forEachIndexed { x, c ->
                val at = Point2D(x, y)
                if (at !in pipe) grid[at] = '.'
            }
        }
        val emptyCorner =
            listOf(
                Point2D(0, 0),
                Point2D(0, grid[0].lastIndex),
                Point2D(grid.lastIndex, 0),
                Point2D(grid.lastIndex, grid[0].lastIndex)
            )
                .first { grid[it] == '.' }

        traversePipe { current, direction, nextDirection ->
            grid.floodFill(current + markingDirection.getValue(direction), 'O')
            if (grid[current] in setOf('7', 'L', 'J', 'F')) {
                grid.floodFill(current + markingDirection.getValue(nextDirection), 'O')
            }
        }

        val find = if (grid[emptyCorner] == 'O') '.' else 'O'
        return grid.sumOf { row -> row.count { it == find } }
    }

    private fun traversePipe(preMove: (Point2D, Point2D, Point2D) -> (Unit) = { _, _, _ -> }): Set<Point2D> {
        val pipe = mutableSetOf(start)
        var current = start
            .cardinalNeighbors()
            .filter { grid.isSafe(it) }
            .first {
                val d = it - start
                (grid[it] to d in movements)
            }
        var direction = current - start
        while (current != start) {
            pipe += current
            movements[grid[current] to direction]?.let { nextDirection ->
                preMove(current, direction, nextDirection)
                direction = nextDirection
                current += direction
            } ?: error("Invalid movement detected: $current, $direction")
        }
        return pipe
    }

    private fun Array<CharArray>.floodFill(at: Point2D, c: Char) {
        if (!isSafe(at)) return
        val queue = ArrayDeque<Point2D>().apply { add(at) }
        while (queue.isNotEmpty()) {
            val next = queue.removeFirst()
            if (this[next] == '.') {
                this[next] = c
                queue.addAll(next.cardinalNeighbors().filter { isSafe(it) })
            }
        }
    }

    private val movements: Map<Pair<Char, Point2D>, Point2D> =
        mapOf(
            ('|' to SOUTH) to SOUTH,
            ('|' to NORTH) to NORTH,
            ('-' to EAST) to EAST,
            ('-' to WEST) to WEST,
            ('L' to WEST) to NORTH,
            ('L' to SOUTH) to EAST,
            ('J' to SOUTH) to WEST,
            ('J' to EAST) to NORTH,
            ('7' to EAST) to SOUTH,
            ('7' to NORTH) to WEST,
            ('F' to WEST) to SOUTH,
            ('F' to NORTH) to EAST
        )

    private val markingDirection: Map<Point2D, Point2D> =
        mapOf(
            SOUTH to EAST,
            NORTH to WEST,
            WEST to SOUTH,
            EAST to NORTH
        )
}
