package operaciones

fun <T> Iterable<T>.myForEach(accion: (T) -> Unit) {
    for (elemento in this) {
        accion(elemento)
    }
}


fun main() {
    val listInteger = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

    // Recorre la lista y ejecuta la funcion por cada elemento
    listInteger.forEach { println(it) }

    val listInteger2 = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // Sumar listas
    val listInteger3 = listInteger + listInteger2
    println(listInteger3)

    // Restar listas
    val listInteger4 = listInteger - listInteger2
    println(listInteger4)

    val setInteger = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val setInteger2 = setOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(setInteger intersect setInteger2)
    println(setInteger union setInteger2)
    println(setInteger subtract setInteger2)

    val subListInteger = listInteger.subList(0, 5)
    println(subListInteger)

    val listInteger5 = listOf(1, 2, 3, 4, 5, 2, 5, 6, 6, 7, 8, 9, 10)
    // quitar duplicados
    val listInteger6 = listInteger5.distinct()

}