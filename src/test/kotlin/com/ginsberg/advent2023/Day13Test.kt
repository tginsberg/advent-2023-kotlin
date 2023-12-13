/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 13")
class Day13Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example - vertical`() {
            // Arrange
            val input = """
                #.##..##.
                ..#.##.#.
                ##......#
                ##......#
                ..#.##.#.
                ..##..##.
                #.#.##.#.
            """.trimIndent().lines()

            // Act
            val answer = Day13(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Matches example - horizontal`() {
            // Arrange
            val input = """
                #...##..#
                #....#..#
                ..##..###
                #####.##.
                #####.##.
                ..##..###
                #....#..#
            """.trimIndent().lines()

            // Act
            val answer = Day13(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(400)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day13(resourceAsListOfString("day13.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(35_210)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Arrange
            val input = """
                #.##..##.
                ..#.##.#.
                ##......#
                ##......#
                ..#.##.#.
                ..##..##.
                #.#.##.#.

                #...##..#
                #....#..#
                ..##..###
                #####.##.
                #####.##.
                ..##..###
                #....#..#
            """.trimIndent().lines()

            // Act
            val answer = Day13(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(400)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day13(resourceAsListOfString("day13.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(31_974)
        }
    }
}