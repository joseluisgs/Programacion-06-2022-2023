package repositories

import Exceptions.ParkingFullException
import Exceptions.VehicleAlreadyExistsException
import Exceptions.VehicleNotFoundException
import models.Camion
import models.Coche
import models.Moto
import models.Vehiculo

class ParkingListRepository(
    private val maxSize: Int,
): ParkingRepository<Vehiculo, String> {
    private val vehicles = mutableListOf<Vehiculo>()

    override fun isParkingFull(): Boolean {
        return vehicles.size == maxSize
    }

    override fun searchVehicleByMatricula(matricula: String): Vehiculo? {
        // Recorremos la lista de vehículos, por ahora no es la mejor opción
        for (vehicle in vehicles) {
            // Si la matrícula del vehículo actual es igual a la que buscamos
            if (vehicle.matricula == matricula) {
                // Devolvemos el vehículo
                return vehicle
            }
        }
        // Si no hemos encontrado el vehículo, devolvemos null
        return null
        // throw VehicleNotFoundException("El vehículo no existe con matrícula $matricula")
    }

    override fun getAllVehicles(): List<Vehiculo> {
        return vehicles.toList()
    }

    override fun getNumVehicles(): Int {
        return vehicles.size
    }

    override fun getNumVehiclesByType(type: String): Int {
        // necesitamos contar cuanto elementos hay de cada clase!!
        // Coche, Moto, Camion
        // por ahora no es la mejor opción
        var countVehicles = 0
        for (vehicle in vehicles) {
            // Si la matrícula del vehículo actual es igual a la que buscamos
            when (type.lowercase()) {
                "coche" -> {
                    // contamos los objetos de tipo coche
                    if (vehicle is Coche) {
                        countVehicles++
                    }
                }
                "moto" -> {
                    // contamos los objetos de tipo moto
                    if (vehicle is Moto) {
                        countVehicles++
                    }
                }
                "camion" -> {
                    // contamos los objetos de tipo camion
                    if (vehicle is Camion) {
                        countVehicles++
                    }
                }
            }
        }
        return countVehicles
    }

    override fun getVehicleOrderByMatricula(): List<Vehiculo> {
        // Por ahora burbuja (no es la mejor opción)
        // Ascendente
        for (i in vehicles.indices) {
            for (j in vehicles.indices) {
                if (vehicles[j].matricula > vehicles[j + 1].matricula) {
                    val aux = vehicles[j]
                    vehicles[j] = vehicles[j + 1]
                    vehicles[j + 1] = aux
                }
            }
        }
        return vehicles.toList()
    }

    override fun getVehicleOrderByYearDesc(): List<Vehiculo> {
        // Por ahora burbuja (no es la mejor opción)
        // Ordenamos por año de matriculación de forma descendente (mayor a menor)
        // ya tiene su compareTo implementado
        for (i in vehicles.indices) {
            for (j in vehicles.indices) {
                if (vehicles[j].añoMatriculacion < vehicles[j + 1].añoMatriculacion) {
                    val aux = vehicles[j]
                    vehicles[j] = vehicles[j + 1]
                    vehicles[j + 1] = aux
                }
            }
        }
        return vehicles.toList()
    }

    override fun removeVehicleById(id: String): Vehiculo? {
        // Cuidado que no se puede eliminar un vehículo si no existe
        val vehicle = searchVehicleByMatricula(id)
            ?: throw VehicleNotFoundException("El vehículo no existe con matrícula $id")
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