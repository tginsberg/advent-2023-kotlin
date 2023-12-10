/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {


    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {
            // Arrange
            val input = """
                ..F7.
                .FJ|.
                SJ.L7
                |F--J
                LJ...
            """.trimIndent().lines()

            // Act
            val answer = Day10(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(6_831)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example 1`() {
            // Arrange
            val input = """
                ..........
                .S------7.
                .|F----7|.
                .||OOOO||.
                .||OOOO||.
                .|L-7F-J|.
                .|II||II|.
                .L--JL--J.
                ..........
            """.trimIndent().lines()

            // Act
            val answer = Day10(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Matches example 2`() {
            // Arrange
            val input = """
                .F----7F7F7F7F-7....
                .|F--7||||||||FJ....
                .||.FJ||||||||L7....
                FJL7L7LJLJ||LJ.L-7..
                L--J.L7...LJS7F-7L7.
                ....F-J..F7FJ|L7L7L7
                ....L7.F7||L7|.L7L7|
                .....|FJLJ|FJ|F7|.LJ
                ....FJL-7.||.||||...
                ....L---J.LJ.LJLJ...
            """.trimIndent().lines()

            // Act
            val answer = Day10(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Matches example 3`() {
            // Arrange
            val input = """
                FF7FSF7F7F7F7F7F---7
                L|LJ||||||||||||F--J
                FL-7LJLJ||||||LJL-77
                F--JF--7||LJLJ7F7FJ-
                L---JF-JLJ.||-FJLJJ7
                |F|F-JF---7F7-L7L|7|
                |FFJF7L7F-JF7|JL---7
                7-L-JL7||F7|L7F-7F7|
                L.L7LFJ|||||FJL7||LJ
                L7JLJL-JLJLJL--JLJ.L
            """.trimIndent().lines()

            // Act
            val answer = Day10(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(10)
        }


        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(305)
        }
    }
}