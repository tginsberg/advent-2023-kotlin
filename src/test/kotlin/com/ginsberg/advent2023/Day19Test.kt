/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

package com.ginsberg.advent2023

import com.ginsberg.advent2023.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 19")
class Day19Test {
    
    // Arrange
    val input = """
        px{a<2006:qkq,m>2090:A,rfg}
        pv{a>1716:R,A}
        lnx{m>1548:A,A}
        rfg{s<537:gd,x>2440:R,A}
        qs{s>3448:A,lnx}
        qkq{x<1416:A,crn}
        crn{x>2662:A,R}
        in{s<1351:px,qqz}
        qqz{s>2770:qs,m<1801:hdj,R}
        gd{a>3333:R,R}
        hdj{m>838:A,pv}

        {x=787,m=2655,a=1222,s=2876}
        {x=1679,m=44,a=2067,s=496}
        {x=2036,m=264,a=79,s=2244}
        {x=2461,m=1339,a=466,s=291}
        {x=2127,m=1623,a=2188,s=1013}
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `Matches example`() {

            // Act
            val answer = Day19(input).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(19_114)
        }
        

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day19(resourceAsListOfString("day19.txt")).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(397_134)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Matches example`() {
            // Act
            val answer = Day19(input).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(167_409_079_868_000)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day19(resourceAsListOfString("day19.txt")).solvePart2()

            // Assert
            assertThat(answer).isEqualTo(127517902575337)
        }
    }
}