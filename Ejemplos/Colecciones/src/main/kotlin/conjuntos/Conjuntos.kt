package conjuntos

import models.Alumno
import models.PersonaComparatorNombre
import java.util.*


fun main() {
    // Si no pongo nada, por defecto siempre es LinkedHashSet
    val setInt = mutableSetOf<Int>()
    val listInt= mutableListOf<Int>()
    val treeSet: TreeSet<Int> = TreeSet()
    val hashSet: HashSet<Int> = HashSet()

    setInt.add(1)
    setInt.add(2)

    listInt.add(1)
    listInt.add(2)

    println(setInt)
    println(listInt)

    setInt.add(1)
    setInt.add(2)

    listInt.add(1)
    listInt.add(2)

    println(setInt)
    println(listInt)

    setInt.remove(1)
    listInt.remove(1)

    println(setInt)
    println(listInt)

    val a1 = Alumno(UUID.randomUUID(), "Pepe", 20, "1º DAM")
    val a2 = Alumno(UUID.randomUUID(), "Ana", 22, "2º DAM")
    val a3 = Alumno(UUID.randomUUID(), "Antonio", 180, "1º DAW")

    // Set y MutableSet implementan en LinkedHashSet pero con el hashcode interno de Kotlin
    // La ordenación depende de su orden de inserción

    val setAlumnos = mutableSetOf<Alumno>()

    setAlumnos.add(a1)
    setAlumnos.add(a2)
    setAlumnos.add(a1)
    setAlumnos.add(a2)
    setAlumnos.add(a1)
    setAlumnos.add(a3)

    println(setAlumnos)

    println()

    for (alumno in setAlumnos) {
        println(alumno)
    }

    println()

    val setString = mutableSetOf<String>()
    setString.add("Hola")
    setString.add("Hola")
    setString.add("Adios")
    setString.add("¿Qué tal?")

    println(setString)


    // HashSet es un conjunto de elementos que no se repiten, se ordenan por el hashcode
    val hashSetAlumnos: HashSet<Alumno> = HashSet()

    hashSetAlumnos.add(a1)
    hashSetAlumnos.add(a2)
    hashSetAlumnos.add(a1)
    hashSetAlumnos.add(a2)
    hashSetAlumnos.add(a1)
    hashSetAlumnos.add(a3)

    println(hashSetAlumnos)

    println()

    for (alumno in hashSetAlumnos) {
        println(alumno)
    }

    println()

    val hastSetString = hashSetOf<String>()
    hastSetString.add("Hola")
    hastSetString.add("Hola")
    hastSetString.add("Adios")
    hastSetString.add("¿Qué tal?")

    println(hastSetString)

    // Operaciones con conjuntos
    val numbers = setOf("one", "two", "three")

    println(numbers union setOf("four", "five"))
    println(setOf("four", "five") union numbers)

    println(numbers intersect setOf("two", "one"))
    println(numbers subtract setOf("three", "four"))
    println(numbers subtract setOf("four", "three"))

    // Truco eliminar duplicados
    val list = listOf("one", "two", "three", "four", "five", "one", "two", "three", "four", "five")
    println(list.toSet() )




    val treeSetString: TreeSet<String> = TreeSet()

    treeSetString.add("Hola")
    treeSetString.add("Hola")
    treeSetString.add("Adios")
    treeSetString.add("¿Qué tal?")

    println(treeSetString)

    println()

    // TreeSet es un conjunto de elementos que no se repiten, se ordenan por el compareTo
    val treeSetAlumnos: TreeSet<Alumno> = TreeSet()
    treeSetAlumnos.add(a1)
    treeSetAlumnos.add(a2)
    treeSetAlumnos.add(a1)
    treeSetAlumnos.add(a2)
    treeSetAlumnos.add(a1)
    treeSetAlumnos.add(a3)

    println(treeSetAlumnos)

    println()

    for (alumno in treeSetAlumnos) {
        println(alumno)
    }

    println()


    // lista de alumnos
    val listAlumnos = mutableListOf<Alumno>()
    listAlumnos.add(a2)
    listAlumnos.add(a3)
    listAlumnos.add(a1)
    listAlumnos.add(a2)
    listAlumnos.add(a1)
    listAlumnos.add(a1)


    // lista de alumnos sin duplicados
    for (alumno in listAlumnos) {
        println(alumno)
    }

    // Ordenar burbuja gracias a compareTo
    // -1(menor) 0(igual) 1 (mayor)
    for (i in 0 until listAlumnos.size) {
        for (j in 0 until listAlumnos.size - 1) {
            if (listAlumnos[j] > listAlumnos[j + 1]) {
                val aux = listAlumnos[j]
                listAlumnos[j] = listAlumnos[j + 1]
                listAlumnos[j + 1] = aux
            }
        }
    }

    println()
    println(listAlumnos.joinToString(separator = "\n"))
    println()
    println(listAlumnos.sorted().joinToString(separator = "\n"))


    // Ordenar con un comparator
    Collections.sort(setAlumnos.toList(), PersonaComparatorNombre())
    println(setAlumnos.joinToString(separator = "\n"))

    println()
    println(setAlumnos.sortedWith(PersonaComparatorNombre()).joinToString(separator = "\n"))

    // Yo puedo crear mi propio comparator sobre la marcha usando una función lambda
    println()
    println(setAlumnos.sortedWith(compareBy { it.nombre }).joinToString(separator = "\n")) // Más aadelante

    val alumnosTreePorNombre = TreeSet<Alumno>(PersonaComparatorNombre())
    alumnosTreePorNombre.addAll(setAlumnos)
    println()
    println(alumnosTreePorNombre.joinToString(separator = "\n"))
    
}