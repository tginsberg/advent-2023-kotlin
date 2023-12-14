/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Day14Test {

    // Arrange
    val input = """
        O....#....
        O.OO#....#
        .....##...
        OO.#O....O
        .O.....O#.
        O.#..O.#.#
        ..O..#O..O
        .......O..
        #....###..
        #OO..#....
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day14(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(136)
        }
        
        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day14(resourceAsListOfString("day14.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(106_990)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day14(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(64)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day14(resourceAsListOfString("day14.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(100_531)
        }
    }
}