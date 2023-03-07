package operaciones

fun <T,D> Iterable<T>.myMap(transformacion: (T) -> D): List<D> {
    val resultado = mutableListOf<D>()
    for (elemento in this) {
        resultado.add(transformacion(elemento) as D)
    }
    return resultado
}

fun main() {
    val listPalabras = listOf("Hola", "que", "tal", "estas", "hoy")

    // Devuelve una lista con los elementos transformados por la funcion
    val listPalabrasMayusculas = listPalabras.map { it.uppercase() }
    println(listPalabrasMayusculas)

    val listaLongitud = listPalabras.map { it.length }
    println(listaLongitud)

    // Devuelve una lista con los elementos transformados por la funcion y el indice
    val listaMayusuclaSoloIndexPar = listPalabras.mapIndexed { index, palabra ->
        if (index % 2 == 0) palabra.uppercase() else palabra
    }

    println(listaMayusuclaSoloIndexPar)

    // Crea una lista en base a los pares de la lista original y otra lista
    val listasMayusculasConLongitud= listPalabrasMayusculas.zip(listaLongitud)
    println(listasMayusculasConLongitud)

    // Crea dos listas en base a los pares de la lista
    val (palabras, longitud) = listasMayusculasConLongitud.unzip()
    println(palabras)
    println(longitud)

    // Crea un mapa en con los elementos de la lista como clave y el resultado de la funcion como valor
    val listaLongitdMayusculas = listPalabras.associateWith { it.length }
    println(listaLongitdMayusculas)

    // Crea un mapa en con el resultado de la funcion como clave y los elementos de la lista como valor
    val lista2= listPalabras.associateBy { it.length }
    println(lista2)

    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    // Devuelve una lista con los elementos de todas las listas
    val union = numberSets.flatten()
    println(union)

    val listaPalabras = listOf("Hola", "que", "tal", "estas", "hoy")
    // Devuelve una cadena con los elementos de la lista indicando el formato de la misma.
    val myString = listaPalabras.joinToString(separator = ";", prefix = "(", postfix = ")", limit = 3, truncated = "...")
    println(myString)
    println(listPalabras.joinToString())
    println(listPalabras.joinToString(separator = "\n"))

}