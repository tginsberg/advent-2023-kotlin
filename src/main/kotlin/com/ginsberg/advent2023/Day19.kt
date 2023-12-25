/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 19 -
 * Problem Description: http://adventofcode.com/2023/day/19
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day19/
 */
package com.ginsberg.advent2023

class Day19(input: List<String>) {

    private val workflows = input.takeWhile { it.isNotBlank() }.map { Workflow.of(it) }.associateBy { it.name }
    private val partRatings = input.dropWhile { it.isNotBlank() }.drop(1).map { PartRating.of(it) }

    fun solvePart1(): Int =
        partRatings.filter { rating ->
            workflows.getValue("in").evaluate(rating, workflows) == "A"
        }.sumOf { it.total }

    fun solvePart2(): Long =
        workflows.getValue("in")
            .countRanges(
                workflows.withDefault { Workflow(it, emptyList()) },
                "xmas".associateWith { 1..4000 }
            )

    private data class PartRating(val categories: Map<Char, Int>) {

        val total: Int = categories.values.sum()

        operator fun get(category: Char): Int =
            categories.getValue(category)

        companion object {
            fun of(input: String): PartRating =
                PartRating(
                    input
                        .removeSurrounding("{", "}")
                        .split(",")
                        .associate {
                            it.first() to it.substring(2).toInt()
                        }
                )
        }
    }

    private data class Workflow(val name: String, val rules: List<Rule>) {
        fun evaluate(part: PartRating, workflows: Map<String, Workflow>): String =
            rules.firstNotNullOf { rule ->
                when (val answer = rule.eval(part)) {
                    null, in setOf("A", "R") -> answer
                    else -> workflows.getValue(answer).evaluate(part, workflows)
                }
            }

        fun countRanges(allWorkflows: Map<String, Workflow>, ranges: Map<Char, IntRange>): Long =
            when (name) {
                "R" -> 0
                "A" -> ranges.values.map { it.length().toLong() }.reduce(Long::times)
                else -> {
                    val constrainedRanges = ranges.toMutableMap()
                    rules
                        .map { it to allWorkflows.getValue(it.nextWorkflow) }
                        .sumOf { (rule, workflow) ->
                            when (rule) {
                                is Rule.Other -> workflow
                                    .countRanges(allWorkflows, constrainedRanges)

                                is Rule.RangeCheck ->
                                    constrainedRanges.getValue(rule.category).let { before ->
                                        constrainedRanges[rule.category] = before intersectRange rule.range
                                        workflow.countRanges(allWorkflows, constrainedRanges).also {
                                            constrainedRanges[rule.category] = before intersectRange rule.antiRange
                                        }
                                    }
                            }
                        }
                }
            }

        companion object {
            fun of(input: String): Workflow =
                Workflow(
                    input.substringBefore("{"),
                    input
                        .substringAfter("{")
                        .substringBefore("}")
                        .split(",")
                        .map { rule -> Rule.of(rule) }
                )
        }
    }


    private sealed class Rule(val nextWorkflow: String) {
        companion object {
            fun of(input: String): Rule =
                if ('>' in input || '<' in input) {
                    val variable = input[0]
                    val test = input[1]
                    val amount = input.substring(2).substringBefore(":").toInt()
                    val target = input.substringAfter(":")
                    RangeCheck(
                        variable,
                        if (test == '<') (1..<amount) else (amount + 1..4000),
                        if (test == '<') (amount..4000) else (1..amount),
                        target
                    )
                } else Other(input)
        }

        abstract fun eval(partRating: PartRating): String?

        class RangeCheck(
            val category: Char,
            val range: IntRange,
            val antiRange: IntRange,
            nextWorkflow: String
        ) :
            Rule(nextWorkflow) {

            override fun eval(partRating: PartRating): String? =
                if (partRating[category] in range) nextWorkflow else null
        }

        class Other(nextWorkflow: String) : Rule(nextWorkflow) {

            override fun eval(partRating: PartRating): String = nextWorkflow
        }
    }
}