/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 6 - Wait For It
 * Problem Description: http://adventofcode.com/2023/day/6
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day6/
 */
package com.ginsberg.advent2023

class Day06(private val input: List<String>) {

    fun solvePart1(): Long {
        val times = input.first().substringAfter(":").split(" ").filter { it.isNotEmpty() }.map { it.toLong() }
        val distances = input.drop(1).first().substringAfter(":").split(" ").filter { it.isNotEmpty() }.map { it.toLong() }

        return times.zip(distances)
            .map { race(it.first, it.second) }
            .reduce(Long::times)
    }

    fun solvePart2(): Long {
        val time = input.first().substringAfter(":").filter { it.isDigit() }.toLong()
        val distance = input.drop(1).first().substringAfter(":").filter { it.isDigit() }.toLong()

        return race(time, distance)
    }

    private fun race(time: Long, distance: Long): Long {
        val start = (1 .. time).first { hold ->
            ((time-hold)) * hold > distance
        } -1

        val end = (time downTo 1).first { hold ->
            ((time-hold)) * hold > distance
        }

        return end-start
    }
}