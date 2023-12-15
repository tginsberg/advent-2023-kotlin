/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 15")
class Day15Test {


    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example - HASH`() {
            // Arrange
            val input = "HASH"

            // Act
            val answer = Day15(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(52)
        }

        @Test
        fun `Matches example - sample`() {
            // Arrange
            val input = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"

            // Act
            val answer = Day15(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(1_320)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day15(resourceAsString("day15.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(507_769)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Arrange
            val input = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"

            // Act
            val answer = Day15(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(145)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day15(resourceAsString("day15.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(269_747)
        }
    }
}