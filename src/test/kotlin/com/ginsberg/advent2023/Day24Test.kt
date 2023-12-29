/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 24")
class Day24Test {
    
    // Arrange
    val input = """
        19, 13, 30 @ -2,  1, -2
        18, 19, 22 @ -1, -1, -2
        20, 25, 34 @ -2, -2, -4
        12, 31, 28 @ -1, -2, -1
        20, 19, 15 @  1, -5, -3
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example `() {
            
            // Act
            val answer = Day24(input).solvePart1(7.0..27.0)

            // Assert
            assertThat(answer).isEqualTo(2)
        }
        
        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day24(resourceAsListOfString("day24.txt")).solvePart1(200000000000000.0..400000000000000.0)

            // Assert
            assertThat(answer).isEqualTo(20847)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example `() {

            // Act
            val answer = Day24(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(47)
        }
        
        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day24(resourceAsListOfString("day24.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(908621716620524)
        }
    }
}