/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 18")
class Day18Test {
    
    // Arrange
    val input = """
        R 6 (#70c710)
        D 5 (#0dc571)
        L 2 (#5713f0)
        D 2 (#d2c081)
        R 2 (#59c680)
        D 2 (#411b91)
        L 5 (#8ceee2)
        U 2 (#caa173)
        L 1 (#1b58a2)
        U 2 (#caa171)
        R 2 (#7807d2)
        U 3 (#a77fa3)
        L 2 (#015232)
        U 2 (#7a21e3)
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {

            // Act
            val answer = Day18(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(62)
        }
        

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day18(resourceAsListOfString("day18.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(41_019)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day18(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(952_408_144_115)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day18(resourceAsListOfString("day18.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(96_116_995_735_219)
        }
    }
}