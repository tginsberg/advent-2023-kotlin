/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 25")
class Day25Test {
    
    // Arrange
    val input = """
        jqt: rhn xhk nvd
        rsh: frs pzl lsr
        xhk: hfx
        cmg: qnr nvd lhk bvb
        rhn: xhk bvb hfx
        bvb: xhk hfx
        pzl: lsr hfx nvd
        qnr: nvd
        ntq: jqt hfx bvb xhk
        nvd: lhk
        lsr: lhk
        rzs: qnr cmg lsr rsh
        frs: qnr lhk lsr
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example `() {
            
            // Act
            val answer = Day25(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(54)
        }
        
        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day25(resourceAsListOfString("day25.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(602151)
        }
    }

}