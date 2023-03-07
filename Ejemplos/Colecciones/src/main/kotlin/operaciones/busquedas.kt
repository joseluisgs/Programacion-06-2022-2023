package operaciones

fun <T> Iterable<T>.myFind(predicate: (T) -> Boolean): T? {
    for (element in this) {
        if (predicate(element)) return element
    }
    return null
}
fun main() {
    val listPalabras = listOf("Hola", "que", "tal", "estas", "hoy")

    // devuelve el primer elemento de la lista que cumpla la condicion
    listPalabras.find { it.length > 3 }?.let { println(it) }

    // devuleve el indice del primer elemento de la lista que cumpla la condicion
    println(listPalabras.indexOf("que"))

    // devuelve el indice del primer elemento de la lista que cumpla la condicion
    println(listPalabras.indexOfFirst { it.length > 3 })
    // devuelve el indice del ultimo elemento de la lista que cumpla la condicion
    println(listPalabras.indexOfLast { it.length > 3 })

    // Busquedas con binarySearch
    // Pero debe estar ordenada
    val listPalabrasOrdenadas = listPalabras.sorted().binarySearch("que")
    println(listPalabrasOrdenadas)

    // contains
    println(listPalabras.contains("que"))

    // in
    println("que" in listPalabras)

}