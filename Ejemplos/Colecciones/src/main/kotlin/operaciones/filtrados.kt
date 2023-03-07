package operaciones

fun <T> Iterable<T>.myFilter(predicado: (T) -> Boolean): List<T> {
    val resultado = mutableListOf<T>()
    for (elemento in this) {
        if (predicado(elemento)) {
            resultado.add(elemento)
        }
    }
    return resultado
}

fun <T> Iterable<T>.myPartition(predicado: (T) -> Boolean): Pair<List<T>, List<T>> {
    val trues = mutableListOf<T>()
    val falses = mutableListOf<T>()
    for (elemento in this) {
        if (predicado(elemento)) {
            trues.add(elemento)
        } else {
            falses.add(elemento)
        }
    }
    return Pair(trues, falses)
}

fun main() {
    val lista = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    // Devuleve una lista filtrada por condicion
    val listaFiltrada = lista.filter { it % 2 == 0 }
    println(listaFiltrada)

    // Devuelve dos listas, una con los elementos que cumplen la condicion y otra con los que no
    val (pares, impares) = lista.partition { it % 2 == 0 }
    println(pares)
    println(impares)

    // Devuelve true si almenos un elemento cumple la condicion
    val almenosUnPar = lista.any { it % 2 == 0 }
    println(almenosUnPar)
    // Devuelve true si todos los elementos cumplen la condicion
    val todosPares = lista.all { it % 2 == 0 }
    println(todosPares)
    // Devuelve true si no hay ningun elemento que cumpla la condicion
    val ningunoPar = lista.none { it % 2 == 0 }
    println(ningunoPar)

    val map = mapOf(1 to "uno", 2 to "dos", 3 to "tres")

    // filtrado de claves
    val clavesFiltradas = map.filterKeys { it % 2 == 0 }

    // filtrado de valores
    val valoresFiltrados = map.filterValues { it.length > 3 }
}