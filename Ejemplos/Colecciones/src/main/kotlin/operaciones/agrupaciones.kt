package operaciones

fun main() {
    val listNumbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val listPalabras = listOf("Hola", "que", "tal", "estas", "hoy")

    // groupBy devuelve un Map con la clave y la lista de elementos que coinciden con la clave
    val mapNumbers = listNumbers.groupBy { it % 2 == 0 }
    println(mapNumbers)

    val mapPalabras = listPalabras.groupBy { it.length }
    println(mapPalabras)

    val cuantosParesImpares = listNumbers.groupingBy { it % 2 == 0 }.eachCount()
    println(cuantosParesImpares)

    val cuantasPalabrasPorLongitud = listPalabras.groupingBy { it.length }.eachCount()
    println(cuantasPalabrasPorLongitud)
}