package listas

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val listaInt: List<Int> = listOf(1,2,3) // Solo lectura
    var num = listaInt[0]
    //listaInt[0] = 4 // Error de compilación
    val listaMutable: MutableList<Int> = mutableListOf(1,2,3) // Lectura y escritura
    listaMutable[0] = 4
    num = listaMutable[0]
    // añadir
    listaMutable.add(4)
    listaMutable.add(0, 5)
    listaMutable.addAll(listOf(6,7,8))
    listaMutable.asReversed()
    listaMutable.removeAt(0)
    listaMutable.remove(5)

    val arrayInt: ArrayList<Int> = arrayListOf(1,2,3) // Lectura y escritura
    arrayInt[0] = 4
    num = arrayInt[0]
    val linkedInt: LinkedList<Int> = LinkedList<Int>() // Lectura y escritura
    linkedInt.add(1) // añade
    num = linkedInt[0]

    for (lista in listaInt) {
        println(lista)
    }

    for(i in listaInt.indices) {
        println(listaInt[i])
    }

    for((index, value) in listaInt.withIndex()) {
        println("Indice: $index, Valor: $value")
    }

    var primero: Int = listaInt.first()
    var ultimo: Int = listaInt.last() // listaInt[listaInt.size - 1]

    // Lista vacía
    val listaVacia: List<Int> = emptyList() // solo lectura
    val listaVaciaMutable: MutableList<Int> = mutableListOf() // lectura y escritura

    // Cuidado con las excepciones en las listas vacías
    primero = listaVacia.firstOrNull() ?: -1
    ultimo = listaVacia.lastOrNull() ?: -1
    var otro = listaVacia.getOrNull(0) ?: -1
    var otro2 = listaVacia.getOrElse(3) {
        (it..it*5).random() % 2
    }

    // Matriz con listas de listas
    val matriz: List<MutableList<Int>> = listOf(
        mutableListOf(1,2,3),
        mutableListOf(4,5,6),
        mutableListOf(7,8,9)
    )
    println(matriz[1][2])
    matriz[2][3] = 5
    matriz[2].add(6) // cuidado que ya le subo la dimensión
}