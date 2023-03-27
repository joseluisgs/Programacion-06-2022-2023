package repositories

import Exceptions.ParkingFullException
import Exceptions.VehicleAlreadyExistsException
import models.Camion
import models.Coche
import models.Moto
import models.Vehiculo

class ParkingListRepository(
    private val maxSize: Int,
) : ParkingRepository<Vehiculo, String> {
    private val vehicles = mutableListOf<Vehiculo>()

    override fun isParkingFull(): Boolean {
        return vehicles.size == maxSize
        //return vehicles.count() == maxSize
    }

    override fun searchVehicleByMatricula(matricula: String): Vehiculo? {
        return this.vehicles.find { it.matricula == matricula }
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
        vehicles.sortBy { it.matricula }
        return vehicles.toList()
    }

    override fun getVehicleOrderByYearDesc(): List<Vehiculo> {
        vehicles.sortByDescending { it.añoMatriculacion }
        return vehicles.toList()
    }

    override fun removeVehicleById(id: String): Vehiculo? {
        // Cuidado que no se puede eliminar un vehículo si no existe
        val vehicle = searchVehicleByMatricula(id)
        vehicles.remove(vehicle)
        return vehicle
    }

    override fun addVehicle(vehicle: Vehiculo): Vehiculo {
        // Cuidado que no se puede añadir un vehículo si el parking está lleno o si ya existe
        if (isParkingFull()) {
            throw ParkingFullException("Parking lleno")
        }
        if (searchVehicleByMatricula(vehicle.matricula) != null) {
            throw VehicleAlreadyExistsException("El vehículo ya existe con matrícula ${vehicle.matricula}")
        }
        vehicles.add(vehicle)
        return vehicle
    }
}