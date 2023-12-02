/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 3 - Gear Ratios
 * Problem Description: http://adventofcode.com/2023/day/3
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day3/
 */
package com.ginsberg.advent2023

class Day03(private val input: List<String>) {

    fun solvePart1(): Int {
        val (numbers, symbols) = parseInput(input)
        return numbers
            .filter { number -> number.isAdjacentToAny(symbols) }
            .sumOf { it.toInt() }
    }

    fun solvePart2(): Int {
        val (numbers, symbols) = parseInput(input) { it == '*' }
        return symbols
            .sumOf { symbol ->
                val neighbors = numbers.filter { it.isAdjacentTo(symbol) }
                if(neighbors.size == 2) {
                    neighbors.first().toInt() * neighbors.last().toInt()
                } else 0
            }
    }

    private fun parseInput(
        input: List<String>,
        takeSymbol: (Char) -> Boolean = { it != '.' }
    ): Pair<Set<NumberLocation>, Set<Point2D>> {
        val numbers = mutableSetOf<NumberLocation>()
        val symbols = mutableSetOf<Point2D>()
        var workingNumber = NumberLocation()

        input
            .forEachIndexed { y, row ->
                row.forEachIndexed { x, c ->
                    if (c.isDigit()) {
                        workingNumber.add(c, Point2D(x, y))
                    } else {
                        if (workingNumber.isNotEmpty()) {
                            numbers.add(workingNumber)
                            workingNumber = NumberLocation()
                        }
                        if(takeSymbol(c)) {
                            symbols.add(Point2D(x, y))
                        }
                    }
                }
                // Check at end of row that we don't miss a number.
                if (workingNumber.isNotEmpty()) {
                    numbers.add(workingNumber)
                    workingNumber = NumberLocation()
                }
            }
        return numbers to symbols
    }

    private class NumberLocation {
        val number = mutableListOf<Char>()
        val locations = mutableSetOf<Point2D>()

        fun add(c: Char, location: Point2D) {
            number.add(c)
            locations.addAll(location.neighbors())
        }

        fun isNotEmpty() =
            number.isNotEmpty()

        fun isAdjacentToAny(points: Set<Point2D>): Boolean =
            locations.intersect(points).isNotEmpty()

        fun isAdjacentTo(point: Point2D): Boolean =
            point in locations

        fun toInt(): Int =
            number.joinToString("").toInt()
    }
}