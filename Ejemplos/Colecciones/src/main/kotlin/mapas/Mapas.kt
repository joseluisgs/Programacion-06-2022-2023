package mapas

import java.util.*


// si no usamos un comparable sobre la marcha, tenemos que implementar la interfaz comparable
class Perrito(val nombre: String, val edad: Int): Comparable<Perrito> {
    override fun toString(): String {
        return "Perrito(nombre='$nombre', edad=$edad)"
    }

    override fun compareTo(other: Perrito): Int {
        return this.edad.compareTo(other.edad)
    }
}
fun main() {
    val map = mapOf("a" to 1, "b" to 2, "c" to 3, "pepito" to 4, "pepito" to 5)
    println(map["a"])
    println(map["b"])
    println(map["c"])
    println(map["pepito"])

    // Tamaño del
    println(map.size)

    // Valores almacenados en el mapa
    println(map.values)

    // Obtener un conjunto de Pares clave-valor
    println(map.entries)

    // Saber si existe una clave
    println(map.containsKey("a"))
    println(map.containsKey("d"))

    // Saber si existe un valor en el mapa
    println(map.containsValue(1))
    println(map.containsValue(4))


    // Recorrer el mapa
    for (clave in map.keys) {
        println("Clave: $clave, Valor: ${map[clave]}")
    }

    // Recorrer el mapa
    for ((clave, valor) in map) {
        println("Clave: $clave, Valor: $valor")
    }

    // Recorrer solo las claves
    for (clave in map.keys) {
        println("Clave: $clave")
    }

    // Recorrer los valores
    for (valor in map.values) {
        println("Valor: $valor")
    }

    for (valor in map.values.indices) {
        println("Valor: ${map.values.elementAt(valor)}")
    }

    val treeMapPerritos = TreeMap<String, Perrito>()
    treeMapPerritos["a"] = Perrito("a", 1)
    treeMapPerritos["b"] = Perrito("b", 2)
    treeMapPerritos["c"] = Perrito("c", 3)

    for ((clave, valor) in treeMapPerritos) {
        println("Clave: $clave, Valor: $valor")
    }

    // Con un lamnda defino el comparable sobre la marcha
    /*val treeMapPerritos2 = TreeMap<Perrito, String> { o1, o2 ->
        o1.edad.compareTo(o2.edad)
    }*/
    val treeMapPerritos2 = TreeMap<Perrito, String>()
    treeMapPerritos2[Perrito("a", 99)] = "caniche"
    treeMapPerritos2[Perrito("b", 2)] = "otro"
    treeMapPerritos2[Perrito("c", 3)] = "mil leches"

    for ((clave, valor) in treeMapPerritos2) {
        println("Clave: $clave, Valor: $valor")
    }

}