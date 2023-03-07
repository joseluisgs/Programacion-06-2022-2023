package repositories

interface ParkingRepository<T, ID> {
    fun isParkingFull(): Boolean
    fun searchVehicleByMatricula(matricula: String): T?
    fun addVehicle(vehicle: T): T
    fun removeVehicleById(id: ID): T?
    fun getAllVehicles(): List<T>
    fun getNumVehicles(): Int
    fun getNumVehiclesByType(type: String): Int
    fun getVehicleOrderByMatricula(): List<T>
    fun getVehicleOrderByYearDesc(): List<T>
}