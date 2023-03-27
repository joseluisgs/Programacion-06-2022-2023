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
        // No es la mejor opción porque recorremos todos los vehículos
        var countVehicles = 0
        for (vehicle in vehicles.values) {
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
                    // contamos los objetos de tipo camión
                    if (vehicle is Camion) {
                        countVehicles++
                    }
                }
            }
        }
        return countVehicles
    }

    override fun getVehicleOrderByMatricula(): List<Vehiculo> {
        // matricula es la clave del mapa, por lo que puedo ordenar por la clave
        // al ser String ya tiene implementado el compareTo
        // return vehicles.toSortedMap({ o1, o2 -> o1.compareTo(o2) }).values.toList()
        return vehicles.toSortedMap().values.toList()
    }

    override fun getVehicleOrderByYearDesc(): List<Vehiculo> {
        return vehicles.values.toSortedSet { o1, o2 ->
            o2.añoMatriculacion.compareTo(o1.añoMatriculacion)
        }.toList()
    }
}
