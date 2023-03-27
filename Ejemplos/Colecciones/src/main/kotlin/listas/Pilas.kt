package listas

import listas.repositories.lists.StackRepository

fun main(args: Array<String>) {
    val pilaInt = StackRepository<Int>()
    pilaInt.push(1)
    pilaInt.push(2)
    pilaInt.push(3)

    println(pilaInt)

    println(pilaInt.peek())

    println(pilaInt.pop())
    println(pilaInt.pop())

    println(pilaInt)

}
