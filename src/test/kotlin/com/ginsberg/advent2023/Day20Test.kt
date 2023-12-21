/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 20")
class Day20Test {
    
    // Arrange
    val input = """
        broadcaster -> a, b, c
        %a -> b
        %b -> c
        %c -> inv
        &inv -> a
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example 1`() {
            // Arrange
            val input = """
                broadcaster -> a, b, c
                %a -> b
                %b -> c
                %c -> inv
                &inv -> a
            """.trimIndent().lines()


            // Act
            val answer = Day20(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(32000000)
        }
        
        @Test
        fun `Matches example 2`() {
            // Arrange
            val input = """
                broadcaster -> a
                %a -> inv, con
                &inv -> b
                %b -> con
                &con -> output
            """.trimIndent().lines()

            // Act
            val answer = Day20(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(11687500)
        }


        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(899_848_294)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(247_454_898_168_563)
        }
    }
}