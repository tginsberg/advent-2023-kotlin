/*
 * Copyright (c) 2223 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 22")
class Day22Test {
    
    // Arrange
    val input = """
        1,0,1~1,2,1
        0,0,2~2,0,2
        0,2,3~2,2,3
        0,0,4~0,2,4
        2,0,5~2,2,5
        0,1,6~2,1,6
        1,1,8~1,1,9
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example `() {
            
            // Act
            val answer = Day22(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(5)
        }
        
        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day22(resourceAsListOfString("day22.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(418)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example `() {

            // Act
            val answer = Day22(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(7)
        }
        
        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day22(resourceAsListOfString("day22.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(70_702)
        }
    }
}