/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 8")
class Day08Test {



    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example 1`() {
            // Arrange
            val input = """
                RL
        
                AAA = (BBB, CCC)
                BBB = (DDD, EEE)
                CCC = (ZZZ, GGG)
                DDD = (DDD, DDD)
                EEE = (EEE, EEE)
                GGG = (GGG, GGG)
                ZZZ = (ZZZ, ZZZ)
            """.trimIndent().lines()

            // Act
            val answer = Day08(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Matches example 2`() {

            val input = """
                LLR

                AAA = (BBB, BBB)
                BBB = (AAA, ZZZ)
                ZZZ = (ZZZ, ZZZ)
            """.trimIndent().lines()

            // Act
            val answer = Day08(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(6)
        }


        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(16_697)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Arrange
            val input = """
                LR

                11A = (11B, XXX)
                11B = (XXX, 11Z)
                11Z = (11B, XXX)
                22A = (22B, XXX)
                22B = (22C, 22C)
                22C = (22Z, 22Z)
                22Z = (22B, 22B)
                XXX = (XXX, XXX)
            """.trimIndent().lines()

            // Act
            val answer = Day08(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(6)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(10_668_805_667_831L)
        }
    }
}