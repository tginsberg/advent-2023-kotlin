/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 16")
class Day16Test {
    
    // Arrange
    val input = """
        .|...\....
        |.-.\.....
        .....|-...
        ........|.
        ..........
        .........\
        ..../.\\..
        .-.-/..|..
        .|....-|.\
        ..//.|....
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {

            // Act
            val answer = Day16(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(46)
        }
        

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day16(resourceAsListOfString("day16.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(6_855)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day16(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(51)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day16(resourceAsListOfString("day16.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(7_513)
        }
    }
}