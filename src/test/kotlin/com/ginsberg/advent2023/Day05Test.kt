/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05_sample.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(35)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(462_648_396)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05_sample.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(46)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day05(resourceAsListOfString("day05.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(2_520_479)
        }
    }
}