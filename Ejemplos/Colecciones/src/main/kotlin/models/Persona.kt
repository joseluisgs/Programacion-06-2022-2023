package models

import java.util.UUID

// La interfaz Comparable es una interfaz genérica
// T es el tipo de dato que va a comparar
// fija la ordenación por defecto
// -1 -> menor
// 0 -> igual
// 1 -> mayor

// Si quiero ordenar por otro campo al que no sea edad, tengo que implementar la interfaz Comparator
// y sobreescribir el método compare
class PersonaComparatorNombre: Comparator<Persona> {
    override fun compare(o1: Persona, o2: Persona): Int {
        return o1.nombre.compareTo(o2.nombre)
    }
}

abstract class Persona(
    val uuid: UUID = UUID.randomUUID(),
    val nombre: String,
    val edad: Int
): Comparable<Persona> {
    override fun toString(): String {
        return "Persona(uuid=$uuid, nombre='$nombre', edad=$edad)"
    }

    override fun compareTo(other: Persona): Int {
        return this.edad.compareTo(other.edad)
        /*return when {
            this.edad > other.edad -> 1
            this.edad < other.edad -> -1
            else -> 0
        }*/
        //return this.edad - other.edad
    }
}

interface Enseñar {
    fun enseñar()
}

interface Aprender {
    fun aprender()
}

class Alumno(
    uuid: UUID = UUID.randomUUID(),
    nombre: String,
    edad: Int,
    val curso: String
) : Persona(uuid = uuid, nombre = nombre, edad = edad), Aprender {
    override fun aprender() {
        println("Aprendiendo...")
    }

    override fun toString(): String {
        return "Alumno(uuid=$uuid, nombre='$nombre', edad=$edad, curso='$curso')"
    }
}

class Profesor(
    uuid: UUID = UUID.randomUUID(),
    nombre: String,
    edad: Int,
    val asignatura: String
) : Persona(uuid = uuid, nombre = nombre, edad = edad), Enseñar {
    override fun enseñar() {
        println("Enseñando...")
    }

    override fun toString(): String {
        return "Profesor(uuid=$uuid, nombre='$nombre', edad=$edad, asignatura='$asignatura')"
    }
}