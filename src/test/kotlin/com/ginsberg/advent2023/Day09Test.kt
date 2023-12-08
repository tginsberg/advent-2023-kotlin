/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 9")
class Day09Test {

    // Arrange
    val input = """
    0 3 6 9 12 15
    1 3 6 10 15 21
    10 13 16 21 30 45
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {

            // Act
            val answer = Day09(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(114)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day09(resourceAsListOfString("day09.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_731_106_378)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day09(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day09(resourceAsListOfString("day09.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_087)
        }
    }
}