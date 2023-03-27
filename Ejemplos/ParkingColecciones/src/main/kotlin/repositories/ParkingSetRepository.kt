package repositories

import Exceptions.ParkingFullException
import Exceptions.VehicleAlreadyExistsException
import Exceptions.VehicleNotFoundException
import models.Camion
import models.Coche
import models.Moto
import models.Vehiculo

// Al ser set no podemos tener elementos repetidos
class ParkingSetRepository(
    private val maxSize: Int,
): ParkingRepository<Vehiculo,String> {
    private val vehicles = mutableSetOf<Vehiculo>() // LinkedHashSet
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
    }

    override fun addVehicle(vehicle: Vehiculo): Vehiculo {
        // Si el parking está lleno
        if (isParkingFull()) {
            // Lanzamos una excepción
            throw ParkingFullException("Parking lleno")
        }
        // Si el vehículo ya existe, no es necesario añadirlo porque no se pueden repetir
        /*if (searchVehicleByMatricula(vehicle.matricula) != null) {
            // Lanzamos una excepción
            throw VehicleAlreadyExistsException("El vehículo ya existe")
        }*/
        // Añadimos el vehículo
        vehicles.add(vehicle)
        // Devolvemos el vehículo
        return vehicle
    }

    override fun removeVehicleById(id: String): Vehiculo? {
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
        // Voy a tirar de un treeSet sobre la marcha y un comparator
        // Necesito un comparator para ordenar por matrícula
        // val comparator = Comparator<Vehiculo> { v1, v2 -> v1.matricula.compareTo(v2.matricula) }
        // Creo un TreeSet con el comparator
        // val treeSet = vehicles.toSortedSet(comparator)
        // val treeSet = TreeSet(){ v1, v2 -> v1.matricula.compareTo(v2.matricula) }
        // en una sola linea con un lambda
        val treeSet = vehicles.toSortedSet { v1, v2 -> v1.matricula.compareTo(v2.matricula) }
        // Devuelvo la lista ordenada
        return treeSet.toList()
    }

    override fun getVehicleOrderByYearDesc(): List<Vehiculo> {
        // repito el proceso pero con otro comparator
        val treeSet = vehicles.toSortedSet { v1, v2 -> v2.añoMatriculacion.compareTo(v1.añoMatriculacion) }
        // Devuelvo la lista ordenada
        return treeSet.toList()
    }
}