/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 15 - Lens Library
 * Problem Description: http://adventofcode.com/2023/day/15
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day15/
 */
package com.ginsberg.advent2023

class Day15(input: String) {

    private val instructions = input.split(',')

    fun solvePart1(): Int =
        instructions.sumOf { it.hash() }

    fun solvePart2(): Int {
        val boxes = List<MutableMap<String, Int>>(256) { mutableMapOf() }

        instructions.forEach { instruction ->
            if (instruction.endsWith("-")) {
                val label = instruction.substringBefore('-')
                boxes[label.hash()].remove(label)
            } else {
                val label = instruction.substringBefore('=')
                boxes[label.hash()][label] = instruction.substringAfter("=").toInt()
            }
        }

        return boxes.withIndex().sumOf { (boxNumber, lenses) ->
            lenses.values.withIndex().sumOf { (lensNumber, lens) ->
                (boxNumber + 1) * (lensNumber + 1) * lens
            }
        }
    }

    private fun String.hash(): Int =
        this.fold(0) { carry, char ->
            ((carry + char.code) * 17).rem(256)
        }
}
