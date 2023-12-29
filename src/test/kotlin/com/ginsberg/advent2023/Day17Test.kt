/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 17")
class Day17Test {
    
    // Arrange
    val input = """
        2413432311323
        3215453535623
        3255245654254
        3446585845452
        4546657867536
        1438598798454
        4457876987766
        3637877979653
        4654967986887
        4564679986453
        1224686865563
        2546548887735
        4322674655533
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {

            // Act
            val answer = Day17(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(102)
        }
        

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day17(resourceAsListOfString("day17.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_013)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day17(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(94)
        }

        @Test
        fun `Actual answer EAST`() {
            // Act
            val answer = Day17(resourceAsListOfString("day17.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_215)
        }

        @Test
        fun `Actual answer SOUTH`() {
            // Act
            val answer = Day17(resourceAsListOfString("day17_south.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(1_197)
        }
    }
}