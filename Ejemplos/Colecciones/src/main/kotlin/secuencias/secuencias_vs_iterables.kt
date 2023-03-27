package secuencias

import kotlin.concurrent.timerTask
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {
    val t1 = measureTimeMillis {
        println("Como Iterable")
        val withIterator = (1..10)
            .filter { print("Filter: $it, "); it % 2 == 0 } // filter out the odd numbers
            .map { print("Mapping: $it, "); it * 2 } // multiply the remaining numbers by 2
            .take(3) // take the first 3 numbers
        println()

// Filter: 1, Filter: 2, Filter: 3, Filter: 4, Filter: 5, Filter: 6, Filter: 7, Filter: 8, Filter: 9, Filter: 10,
// Mapping: 2, Mapping: 4, Mapping: 6, Mapping: 8, Mapping: 10,
// Take: 4, Take: 8, Take: 12,

        println(withIterator) // [4, 8, 12]
    }.also { println("Tiempo: $it") }

    println()
    println("Como secuencia")

    val t2 = measureTimeMillis {
        val withSequence = (1..10).asSequence()
            .filter { print("Filter: $it, "); it % 2 == 0 } // filter out the odd numbers
            .map { print("Mapping: $it, "); it * 2 } // multiply the remaining numbers by 2
            .take(3) // take the first 3 numbers
            .toList() // convert the sequence to a list
        println()
        println(withSequence) // [4, 8, 12]
    }.also { println("Tiempo: $it") }

    println()
    println("Iterables - Secuencias: ${t1 - t2}")
}