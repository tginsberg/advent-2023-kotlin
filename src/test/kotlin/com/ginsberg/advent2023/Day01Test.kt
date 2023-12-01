/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {


    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        // Arrange
        private val input = """
            1abc2
            pqr3stu8vwx
            a1b2c3d4e5f
            treb7uchet
        """.trimIndent().lines()

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(142)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(55_834)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        // Arrange
        private val input = """
            two1nine
            eightwothree
            abcone2threexyz
            xtwone3four
            4nineeightseven2
            zoneight234
            7pqrstsixteen
        """.trimIndent().lines()

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(281)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(53_221)
        }
    }
}