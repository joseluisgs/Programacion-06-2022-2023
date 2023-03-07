package models

sealed class Vehiculo(
    val matricula: String,
    val marca: String,
    val modelo: String,
    val añoMatriculacion: Int,
)

class Coche(
    matricula: String,
    marca: String,
    modelo: String,
    añoMatriculacion: Int,
    val numPuertas: Int,
) : Vehiculo(matricula, marca, modelo, añoMatriculacion)

class Moto(
    matricula: String,
    marca: String,
    modelo: String,
    añoMatriculacion: Int,
    val cilindrada: Int,
) : Vehiculo(matricula, marca, modelo, añoMatriculacion)

class Camion(
    matricula: String,
    marca: String,
    modelo: String,
    añoMatriculacion: Int,
    val pesoMaximo: Int,
) : Vehiculo(matricula, marca, modelo, añoMatriculacion)