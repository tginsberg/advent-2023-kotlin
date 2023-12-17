package com.ginsberg.advent2023

tailrec fun Long.gcd(other: Long): Long =
    if (other == 0L) this
    else other.gcd(this % other)

fun Long.lcm(other: Long): Long =
    (this * other) / this.gcd(other)


fun <E> List<E>.cartesianPairs(): List<Pair<E, E>> =
    this.flatMapIndexed { index, left ->
        this.indices.drop(index).map { right -> left to this[right] }
    }

fun Array<CharArray>.isSafe(at: Point2D) =
    at.y in this.indices && at.x in this[at.y].indices

operator fun Array<CharArray>.set(at: Point2D, c: Char) {
    this[at.y][at.x] = c
}

operator fun Array<CharArray>.get(at: Point2D): Char =
    this[at.y][at.x]

fun Array<CharArray>.swap(a: Point2D, b: Point2D) {
    val tmp = this[a]
    this[a] = this[b]
    this[b] = tmp
}

fun List<List<*>>.isSafe(at: Point2D) =
    at.y in this.indices && at.x in this[at.y].indices

operator fun <T> List<List<T>>.get(at: Point2D): T =
    this[at.y][at.x]
