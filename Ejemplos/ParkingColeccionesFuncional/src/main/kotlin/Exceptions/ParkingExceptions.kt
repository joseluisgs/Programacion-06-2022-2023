package Exceptions

sealed class ParkingException(message: String) : RuntimeException(message)
class ParkingFullException(message: String) : ParkingException(message)
class VehicleNotFoundException(message: String) : ParkingException(message)
class VehicleAlreadyExistsException(message: String) : ParkingException(message)
