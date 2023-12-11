package com.ginsberg.advent2023

import kotlin.math.absoluteValue

data class Point2D(val x: Int, val y: Int) {
    fun neighbors(): Set<Point2D> =
        setOf(
            this + NORTH_WEST,
            this + NORTH,
            this + NORTH_EAST,
            this + WEST,
            this + EAST,
            this + SOUTH_WEST,
            this + SOUTH,
            this + SOUTH_EAST
        )

    fun cardinalNeighbors(): Set<Point2D> =
        setOf(
            this + NORTH,
            this + EAST,
            this + SOUTH,
            this + WEST
        )

    fun distanceTo(other: Point2D): Int =
        (x - other.x).absoluteValue + (y - other.y).absoluteValue

    operator fun minus(other: Point2D): Point2D =
        Point2D(x - other.x, y - other.y)

    operator fun plus(other: Point2D): Point2D =
        Point2D(x + other.x, y + other.y)

    companion object {
        val NORTH = Point2D(0, -1)
        val EAST = Point2D(1, 0)
        val SOUTH = Point2D(0, 1)
        val WEST = Point2D(-1, 0)
        val NORTH_WEST = NORTH + WEST
        val NORTH_EAST = NORTH + EAST
        val SOUTH_WEST = SOUTH + WEST
        val SOUTH_EAST = SOUTH + EAST
    }
}