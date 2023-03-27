package repositories

import Exceptions.ParkingFullException
import Exceptions.VehicleNotFoundException
import models.Camion
import models.Coche
import models.Moto
import models.Vehiculo

class ParkingMapRepository(
    private val maxSize: Int,
) : ParkingRepository<Vehiculo, String> {
    private val vehicles = mutableMapOf<String, Vehiculo>()
    override fun isParkingFull(): Boolean {
        return vehicles.size == maxSize
    }

    override fun searchVehicleByMatricula(matricula: String): Vehiculo? {
        return vehicles[matricula]
    }

    override fun addVehicle(vehicle: Vehiculo): Vehiculo {
        // si está lleno excepción
        if (isParkingFull()) {
            throw ParkingFullException("Parking lleno")
        }
        // No necessitamos comprobar si existe porque no se pueden repetir
        vehicles[vehicle.matricula] = vehicle
        return vehicle
    }

    override fun removeVehicleById(id: String): Vehiculo {
        // Buscamos el vehículo por su matrícula
        val vehicle = vehicles.remove(id)
            ?: throw VehicleNotFoundException("El vehículo no existe con esa matrícula: $id")
        return vehicle
    }

    override fun getAllVehicles(): List<Vehiculo> {
        return vehicles.values.toList()
    }

    override fun getNumVehicles(): Int {
        return vehicles.size
    }

    override fun getNumVehiclesByType(type: String): Int {
        // filter devuelve una lista con los elementos que cumplen la condición
        return when (type) {
            "Coche" -> vehicles.values.filterIsInstance<Coche>().size
            "Moto" -> vehicles.values.count { it is Moto }
            "Camion" -> vehicles.values.filter { it is Camion }.size
            else -> 0
        }
    }

    fun getEstadisticasByType(): Map<String, Int> {
        return vehicles.values
            // cogemos el nombre de la clase porque no tenemos enums!!
            .groupBy { it::class.simpleName }
            .mapKeys { it.key.toString().uppercase() }
            .mapValues { it.value.size }
    }

    override fun getVehicleOrderByMatricula(): List<Vehiculo> {
        // matricula es la clave del mapa, por lo que puedo ordenar por la clave
        // al ser String ya tiene implementado el compareTo
        // return vehicles.toSortedMap({ o1, o2 -> o1.compareTo(o2) }).values.toList()
        // return vehicles.toSortedMap().values.toList()
        // return vehicles.keys.sorted().map { vehicles[it]!! }
        return vehicles.values.sortedBy { it.matricula }
    }

    override fun getVehicleOrderByYearDesc(): List<Vehiculo> {
        /*return vehicles.values.toSortedSet { o1, o2 ->
            o2.añoMatriculacion.compareTo(o1.añoMatriculacion)
        }.toList()*/

        return vehicles.values.sortedByDescending { it.añoMatriculacion }
    }
}
