package listas

fun main() {
    val arrayDeque = ArrayDeque<Int>()

    // Como pila, todo al final
    arrayDeque.addLast(1)
    arrayDeque.addLast(2)
    arrayDeque.addLast(3)

    println(arrayDeque)

    println(arrayDeque.lastOrNull())

    arrayDeque.removeLast()
    arrayDeque.removeLast()

    println(arrayDeque)

    arrayDeque.clear()

    // Como pila todo al principio
    arrayDeque.addFirst(1)
    arrayDeque.addFirst(2)
    arrayDeque.addFirst(3)

    println(arrayDeque)

    println(arrayDeque.firstOrNull())

    arrayDeque.removeFirst()
    arrayDeque.removeFirst()

    println(arrayDeque)

    arrayDeque.clear()

    // Como cola out primero, in ultimo
    arrayDeque.addLast(1)
    arrayDeque.addLast(2)
    arrayDeque.addLast(3)

    println(arrayDeque)

    println(arrayDeque.firstOrNull())

    arrayDeque.removeFirst()
    arrayDeque.removeFirst()

    println(arrayDeque)

    arrayDeque.clear()

    // Como cola out primero, in ultimo
    arrayDeque.addFirst(1)
    arrayDeque.addFirst(2)
    arrayDeque.addFirst(3)

    println(arrayDeque)

    println(arrayDeque.lastOrNull())

    arrayDeque.removeLast()
    arrayDeque.removeLast()

    println(arrayDeque)

    arrayDeque.clear()
}