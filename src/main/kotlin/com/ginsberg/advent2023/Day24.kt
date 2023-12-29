/*
 * Copyright (c) 2023 by Todd Ginsberg
 */

/**
 * Advent of Code 2023, Day 24 - Never Tell Me The Odds
 * Problem Description: http://adventofcode.com/2023/day/24
 * Blog Post/Commentary: https://todd.ginsberg.com/post/advent-of-code/2023/day24/
 */
package com.ginsberg.advent2023

class Day24(input: List<String>) {

    private val hailstones = input.map { Hailstone.of(it) }

    fun solvePart1(range: ClosedFloatingPointRange<Double>): Int =
        hailstones
            .cartesianPairs()
            .filter { it.first != it.second }
            .mapNotNull { it.first.intersectionWith(it.second) }
            .count { (x, y, _) -> x in range && y in range }

    fun solvePart2(): Long {
        val range = -500L..500L
        while (true) {
            val hail = hailstones.shuffled().take(4)
            range.forEach { deltaX ->
                range.forEach { deltaY ->
                    val hail0 = hail[0].withVelocityDelta(deltaX, deltaY)
                    val intercepts = hail.drop(1).mapNotNull {
                        it.withVelocityDelta(deltaX, deltaY).intersectionWith(hail0)
                    }
                    if (intercepts.size == 3 &&
                        intercepts.all { it.x == intercepts.first().x } &&
                        intercepts.all { it.y == intercepts.first().y }
                    ) {
                        range.forEach { deltaZ ->
                            val z1 = hail[1].predictZ(intercepts[0].time, deltaZ)
                            val z2 = hail[2].predictZ(intercepts[1].time, deltaZ)
                            val z3 = hail[3].predictZ(intercepts[2].time, deltaZ)
                            if (z1 == z2 && z2 == z3) {
                                return (intercepts.first().x + intercepts.first().y + z1).toLong()
                            }

                        }
                    }
                }
            }
        }
    }

    private data class Hailstone(val position: Point3D, val velocity: Point3D) {
        private val slope = if (velocity.x == 0L) Double.NaN else velocity.y / velocity.x.toDouble()

        fun withVelocityDelta(vx: Long, vy: Long): Hailstone =
            copy(
                velocity = Point3D(velocity.x + vx, velocity.y + vy, velocity.z)
            )

        fun predictZ(time: Double, deltaVZ: Long): Double =
            (position.z + time * (velocity.z + deltaVZ))

        fun intersectionWith(other: Hailstone): Intersection? {
            if (slope.isNaN() || other.slope.isNaN() || slope == other.slope) return null

            val c = position.y - slope * position.x
            val otherC = other.position.y - other.slope * other.position.x

            val x = (otherC - c) / (slope - other.slope)
            val t1 = (x - position.x) / velocity.x
            val t2 = (x - other.position.x) / other.velocity.x

            if (t1 < 0 || t2 < 0) return null

            val y = slope * (x - position.x) + position.y
            return Intersection(x, y, t1)
        }

        companion object {
            fun of(input: String): Hailstone = input.split("@").let { (left, right) ->
                Hailstone(
                    Point3D.of(left),
                    Point3D.of(right)
                )
            }
        }
    }

    private data class Intersection(val x: Double, val y: Double, val time: Double)

    private data class Point3D(val x: Long, val y: Long, val z: Long) {
        companion object {
            fun of(input: String): Point3D =
                input.split(",").map { it.trim().toLong() }.let {
                    Point3D(it[0], it[1], it[2])
                }
        }
    }
}