/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 11")
class Day11Test {
    
    // Arrange
    val input = """
        ...#......
        .......#..
        #.........
        ..........
        ......#...
        .#........
        .........#
        ..........
        .......#..
        #...#.....
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {

            // Act
            val answer = Day11(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(374)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day11(resourceAsListOfString("day11.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(9_724_940)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example - 10ly`() {
            // Act
            val answer = Day11(input).solvePart2(10)

            // Assert
            assertThat(answer).isEqualTo(1_030)
        }

        @Test
        fun `Matches example - 100ly`() {
            // Act
            val answer = Day11(input).solvePart2(100)

            // Assert
            assertThat(answer).isEqualTo(8_410)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day11(resourceAsListOfString("day11.txt")).solvePart2(1_000_000)

            // Assert
            assertThat(answer).isEqualTo(569_052_586_852L)
        }
    }
}