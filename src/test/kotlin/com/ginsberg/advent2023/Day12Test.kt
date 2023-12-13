/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 12")
class Day12Test {
    
    // Arrange
    val input = """
        ???.### 1,1,3
        .??..??...?##. 1,1,3
        ?#?#?#?#?#?#?#? 1,3,1,6
        ????.#...#... 4,1,1
        ????.######..#####. 1,6,5
        ?###???????? 3,2,1
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {

            // Act
            val answer = Day12(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(21)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day12(resourceAsListOfString("day12.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(7_236)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day12(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(525_152)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day12(resourceAsListOfString("day12.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(11_607_695_322_318)
        }
    }
}