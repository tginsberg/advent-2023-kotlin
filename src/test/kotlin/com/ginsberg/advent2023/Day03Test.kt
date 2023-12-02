/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day03Test {

    // Arrange
    private val input = """
        467..114..
        ...*......
        ..35..633.
        ......#...
        617*......
        .....+.58.
        ..592.....
        ......755.
        ...${'$'}.*....
        .664.598..
        """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day03(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(4_361)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(resourceAsListOfString("day03.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(532_331)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day03(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(467_835)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(resourceAsListOfString("day03.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(82_301_120)
        }
    }
}