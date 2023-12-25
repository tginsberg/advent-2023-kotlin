/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 21")
class Day21Test {
    
    // Arrange
    val input = """
        ...........
        .....###.#.
        .###.##..#.
        ..#.#...#..
        ....#.#....
        .##..S####.
        .##..#...#.
        .......##..
        .##.#.####.
        .##..##.##.
        ...........
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day21(input).solvePart1(6)

            // Assert
            assertThat(answer).isEqualTo(16)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day21(resourceAsListOfString("day21.txt")).solvePart1(64)

            // Assert
            assertThat(answer).isEqualTo(3646)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day21(resourceAsListOfString("day21.txt")).solvePart2(26501365)

            // Assert
            assertThat(answer).isEqualTo(606188414811259)
        }
    }
}