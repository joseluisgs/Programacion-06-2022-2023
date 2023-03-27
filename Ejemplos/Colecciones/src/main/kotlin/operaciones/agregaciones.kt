package operaciones

fun main() {
    val listNumbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val listPalabras = listOf("Hola", "que", "tal", "estas", "hoy")

    // max devuelve el elemento máximo de la lista
    val maxNumber = listNumbers.max()
    println(maxNumber)

    val maxPalabra = listPalabras.max()
    println(maxPalabra)

    // min devuelve el elemento mínimo de la lista
    val minNumber = listNumbers.min()
    println(minNumber)

    val minPalabra = listPalabras.min()
    println(minPalabra)

    // maxBy devuelve el elemento máximo de la lista segúnla función de comparación
    val maxNumberBy = listNumbers.maxBy { it % 2 == 0 }
    println(maxNumberBy)

    val maxPalabraBy = listPalabras.maxBy { it.length }
    println(maxPalabraBy)

    // minBy devuelve el elemento mínimo de la lista según la función de comparación
    val minNumberBy = listNumbers.minBy { it % 2 == 0 }
    println(minNumberBy)

    val minPalabraBy = listPalabras.minBy { it.length }
    println(minPalabraBy)

    // maxWith devuelve el elemento máximo de la lista según el criterio de comparación
    val maxNumberWith = listNumbers.maxWith(compareBy { it % 2 == 0 })
    println(maxNumberWith)

    val maxPalabraWith = listPalabras.maxWith(compareBy { it.length })
    println(maxPalabraWith)

    // minWith devuelve el elemento mínimo de la lista según el criterio de comparación
    val minNumberWith = listNumbers.minWith(compareBy { it % 2 == 0 })
    println(minNumberWith)

    val minPalabraWith = listPalabras.minWith(compareBy { it.length })
    println(minPalabraWith)

    // maxOf devuelve el elemento máximo de la lista según la función de selector
    val maxNumberOf = listNumbers.maxOf { it % 2 == 0 }
    println(maxNumberOf)

    val maxPalabraOf = listPalabras.maxOf { it.length }
    println(maxPalabraOf)

    // minOf devuelve el elemento mínimo de la lista según la función de selector
    val minNumberOf = listNumbers.minOf { it % 2 == 0 }
    println(minNumberOf)

    val minPalabraOf = listPalabras.minOf { it.length }
    println(minPalabraOf)

    // maxOfWith devuelve el elemento máximo de la lista según el criterio de comparación
    val maxNumberWithOf = listNumbers.maxOfWith(compareBy { it % 2 == 0 }) { it }
    println(maxNumberWithOf)

    val maxPalabraWithOf = listPalabras.maxOfWith(compareBy { it.length }) { it }
    println(maxPalabraWithOf)

    // sum devuelve la suma de los elementos de la lista
    val sumNumbers = listNumbers.sum()
    println(sumNumbers)

    // sumOf devuelve la suma de los elementos de la lista según la función de selector
    val sumPalabras = listPalabras.sumOf { it.length }
    println(sumPalabras)
    // solo los numeros pares
    val sumNumbersPares = listNumbers.sumOf { if (it % 2 == 0) it else 0 }
    println(sumNumbersPares)

    // count devuelve el número de elementos de la lista
    val countNumbers = listNumbers.count()
    println(countNumbers)

    // count devuelve el número de elementos de la lista que cumplen la condición o predicado
    val countNumbersPares = listNumbers.count { it % 2 == 0 }
    println(countNumbersPares)

    // solo para los números tenemos average
    val averageNumbers = listNumbers.average()
    println(averageNumbers)
    println(listNumbers.filter { it >=5 }.sum()/listNumbers.filter { it >=5 }.count())
    println(listNumbers.sumOf { if (it >=5) it else 0  } / listNumbers.count { it >= 5 })
    println(listNumbers.filter { it >=5 }.average())

    // reduce devuelve el resultado de aplicar la función de acumulación a los elementos de la lista
    val reduceNumbers = listNumbers.reduce { acc, i -> acc + i }
    println(reduceNumbers)
    println(listNumbers.sum())
    println(listPalabras.sumOf { it.length })
    println(listPalabras.reduce { acc, i -> acc + i.length })

    // reduceRight devuelve el resultado de aplicar la función de acumulación a los elementos de la lista
    // pero empezando por el final
    val reduceRightNumbers = listNumbers.reduceRight { i, acc -> acc + i }
    println(reduceRightNumbers)

    // reduceIndexed devuelve el resultado de aplicar la función de acumulación a los elementos de la lista
    // pero con el índice
    val reduceIndexedNumbers = listNumbers.reduceIndexed { index, acc, i -> acc + i + index }
    println(reduceIndexedNumbers)
    println(listPalabras.reduceIndexed { index, acc, i ->
        if (index % 2 == 0) acc + i.length
        else acc + i.length + index
    })

    // fold devuelve el resultado de aplicar la función de acumulación a los elementos de la lista
    // pero con un valor inicial
    val foldNumbers = listNumbers.fold(0) { acc, i -> acc + i }

    // foldRight devuelve el resultado de aplicar la función de acumulación a los elementos de la lista
    // pero empezando por el final y con un valor inicial
    val foldRightNumbers = listNumbers.foldRight(0) { i, acc -> acc + i }
    println(foldRightNumbers)

    // foldIndexed devuelve el resultado de aplicar la función de acumulación a los elementos de la lista
    // pero con el índice y con un valor inicial

    val foldIndexedNumbers = listNumbers.foldIndexed(0) { index, acc, i -> acc + i + index }
    println(foldIndexedNumbers)

    // foldRightIndexed devuelve el resultado de aplicar la función de acumulación a los elementos de la lista
    // pero empezando por el final, con el índice y con un valor inicial
    val foldRightIndexedNumbers = listNumbers.foldRightIndexed(0) { index, i, acc -> acc + i + index }
    println(foldRightIndexedNumbers)





}