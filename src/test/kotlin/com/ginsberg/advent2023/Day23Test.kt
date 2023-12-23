/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 23")
class Day23Test {
    
    // Arrange
    val input = resourceAsListOfString("day_23_sample.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example `() {
            
            // Act
            val answer = Day23(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(94)
        }
        
        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day23(resourceAsListOfString("day23.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(2294)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example `() {

            // Act
            val answer = Day23(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(154)
        }
        
        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day23(resourceAsListOfString("day23.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(6418)
        }
    }
}