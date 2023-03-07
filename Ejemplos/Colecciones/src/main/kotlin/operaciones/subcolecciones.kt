package operaciones

fun main() {
    val listPalabras = listOf("Hola", "que", "tal", "estas", "hoy")

    // slice devuelve una sublista de la lista original
    println(listPalabras.slice(1..3))
    println(listPalabras.slice(listOf(1, 3, 4)))

    // take, devuelve los primeros n elementos de la lista
    println(listPalabras.take(3))
    // takeLast, devuelve los ultimos n elementos de la lista
    println(listPalabras.takeLast(3))

    // takeWhile, devuelve los elementos de la lista mientras se cumpla la condición
    println(listPalabras.takeWhile { it.length >= 4 })
    // takeLastWhile, devuelve los elementos de la lista mientras se cumpla la condición
    println(listPalabras.takeLastWhile { it.length <= 4 })

    // drop, devuelve los elementos de la lista excluyendo los primeros n elementos
    println(listPalabras.drop(3))
    // dropLast, devuelve los elementos de la lista excluyendo los ultimos n elementos
    println(listPalabras.dropLast(3))

    // dropWhile, devuelve los elementos de la lista mientras se cumpla la condición
    println(listPalabras.dropWhile { it.length >= 4 })
    // dropLastWhile, devuelve los elementos de la lista mientras se cumpla la condición
    println(listPalabras.dropLastWhile { it.length <= 4 })

    // chunked, devuelve una lista de listas de tamaño n
    println(listPalabras.chunked(2))

    // windowed, devuelve una lista de listas de tamaño n, con un desplazamiento de m
    println(listPalabras.windowed(2, 2, true))

    //zipWithNext, devuelve una lista de pares de elementos consecutivos
    println(listPalabras.zipWithNext())
}