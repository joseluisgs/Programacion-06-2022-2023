package listas

import listas.repositories.lists.QueueRepository

fun main() {
    val colaInt = QueueRepository<Int>()

    colaInt.enqueue(1)
    colaInt.enqueue(2)
    colaInt.enqueue(3)

    println(colaInt)

    println(colaInt.first())

    colaInt.dequeue()
    colaInt.dequeue()

    println(colaInt)
}