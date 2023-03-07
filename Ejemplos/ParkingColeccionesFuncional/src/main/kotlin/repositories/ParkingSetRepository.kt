package repositories

import Exceptions.ParkingFullException
import Exceptions.VehicleNotFoundException
import models.Camion
import models.Coche
import models.Moto
import models.Vehiculo

// Al ser set no podemos tener elementos repetidos
class ParkingSetRepository(
    private val maxSize: Int,
) : ParkingRepository<Vehiculo, String> {
    private val vehicles = mutableSetOf<Vehiculo>() // LinkedHashSet
    override fun isParkingFull(): Boolean {
        return vehicles.size == maxSize
    }

    override fun searchVehicleByMatricula(matricula: String): Vehiculo? {
        return this.vehicles.find { it.matricula == matricula }
    }

    override fun addVehicle(vehicle: Vehiculo): Vehiculo {
        // Si el parking está lleno
        if (isParkingFull()) {
            // Lanzamos una excepción
            throw ParkingFullException("Parking lleno")
        }
        // Añadimos el vehículo
        vehicles.add(vehicle)
        // Devolvemos el vehículo
        return vehicle
    }

    override fun removeVehicleById(id: String): Vehiculo {
        // Buscamos el vehículo por su matrícula
        val vehicle = searchVehicleByMatricula(id)
            ?: // Lanzamos una excepción
            throw VehicleNotFoundException("El vehículo no existe con esa matrícula: $id")
        // Si el vehículo no existe
        // Eliminamos el vehículo
        vehicles.remove(vehicle)
        // Devolvemos el vehículo
        return vehicle
    }

    override fun getAllVehicles(): List<Vehiculo> {
        return vehicles.toList()
    }

    override fun getNumVehicles(): Int {
        return vehicles.size
    }

    override fun getNumVehiclesByType(type: String): Int {
        // filter devuelve una lista con los elementos que cumplen la condición
        return when (type) {
            "Coche" -> vehicles.filterIsInstance<Coche>().size
            "Moto" -> vehicles.count { it is Moto }
            "Camion" -> vehicles.filter { it is Camion }.size
            else -> 0
        }
    }

    fun getEstadisticasByType(): Map<String, Int> {
        return vehicles
            // cogemos el nombre de la clase porque no tenemos enums!!
            .groupBy { it::class.simpleName }
            .mapKeys { it.key.toString().uppercase() }
            .mapValues { it.value.size }
    }

    override fun getVehicleOrderByMatricula(): List<Vehiculo> {
        /*// Voy a tirar de un treeSet sobre la marcha y un comparator
        // Necesito un comparator para ordenar por matrícula
        // val comparator = Comparator<Vehiculo> { v1, v2 -> v1.matricula.compareTo(v2.matricula) }
        // Creo un TreeSet con el comparator
        // val treeSet = vehicles.toSortedSet(comparator)
        // val treeSet = TreeSet(){ v1, v2 -> v1.matricula.compareTo(v2.matricula) }
        // en una sola linea con un lambda
        val treeSet = vehicles.toSortedSet { v1, v2 -> v1.matricula.compareTo(v2.matricula) }
        // Devuelvo la lista ordenada
        return treeSet.toList()*/

        return vehicles.sortedBy { it.matricula }.toList()
    }

    override fun getVehicleOrderByYearDesc(): List<Vehiculo> {
        // repito el proceso pero con otro comparator
        // val treeSet = vehicles.toSortedSet { v1, v2 -> v2.añoMatriculacion.compareTo(v1.añoMatriculacion) }
        // Devuelvo la lista ordenada
        // return treeSet.toList()
        return vehicles.sortedByDescending { it.añoMatriculacion }.toList()
    }
}