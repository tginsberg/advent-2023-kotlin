/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 7")
class Day07Test {

    private val input = """
        32T3K 765
        T55J5 684
        KK677 28
        KTJJT 220
        QQQJA 483
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day07(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(6_440)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(246_163_188)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day07(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(5_905)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(245_794_069)
        }
    }
}