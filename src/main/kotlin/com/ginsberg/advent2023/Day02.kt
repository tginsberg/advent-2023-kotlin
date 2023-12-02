/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 2 - Cube Conundrum
 * Problem Description: http://adventofcode.com/2023/day/2
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day2/
 */
package com.ginsberg.advent2023

class Day02(input: List<String>) {

    private val games: List<Game> = input.map { Game.of(it) }

    fun solvePart1(): Int =
        games.filter {
            it.isPossible(12, 13, 14)
        }.sumOf { it.id }

    fun solvePart2(): Int =
        games.sumOf { it.power() }

    private data class Game(val id: Int, val red: Int, val green: Int, val blue: Int) {

        fun isPossible(red: Int, green: Int, blue: Int) =
            this.red <= red && this.green <= green && this.blue <= blue

        fun power() =
            red * blue * green

        companion object {
            fun of(input: String): Game {
                val id = input.substringAfter(" ").substringBefore(":").toInt()
                val colors = mutableMapOf<String, Int>()

                input.substringAfter(":").split(";").forEach { turn ->
                    turn.split(",").map { it.trim() }.forEach { draw ->
                        val drawNum = draw.substringBefore(" ").toInt()
                        val color = draw.substringAfter(" ")
                        colors[color] = maxOf(drawNum, colors[color] ?: drawNum)
                    }
                }
                return Game(id, colors["red"] ?: 0, colors["green"] ?: 0, colors["blue"] ?: 0)
            }
        }
    }
}