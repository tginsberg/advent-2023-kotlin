/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day06Test {

    private val input = """
        Time:      7  15   30
        Distance:  9  40  200
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day06(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(288)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(503_424)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day06(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(71_503)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(32_607_562)
        }
    }
}