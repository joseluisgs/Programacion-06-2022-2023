package operaciones

fun main() {
    val listaPalabras = listOf("Hola", "que", "tal", "estas", "hoy")

    // sorted, devuelve una lista ordenada a partir del orden natural de los elementos
    // si no hay comparable los elementos, no se puede ordenar
    println(listaPalabras.sorted())
    // sortedDescending, devuelve una lista ordenada a partir del orden natural de los elementos
    println(listaPalabras.sortedDescending())

    // sortedBy, devuelve una lista ordenada a partir de una función de ordenación
    println(listaPalabras.sortedBy { it.length })
    // sortedByDescending, devuelve una lista ordenada a partir de una función de ordenación
    println(listaPalabras.sortedByDescending { it.length })

    // sortedWith, devuelve una lista ordenada a partir de un comparador
    println(listaPalabras.sortedWith { o1, o2 -> o1.length - o2.length })
    println(listaPalabras.sortedWith(compareBy { it.length }))
    println(listaPalabras.sortedWith(compareByDescending { it.length }))
    println(listaPalabras.sortedWith { o1, o2 -> o1.lowercase().compareTo(o2.lowercase()) })
    println(listaPalabras.sortedWith(compareBy { it.lowercase() }))

    // reversed, devuelve una lista con los elementos en orden inverso
    println(listaPalabras.reversed())

    // shuffle, devuelve una lista con los elementos en orden aleatorio
    println(listaPalabras.shuffled())

}