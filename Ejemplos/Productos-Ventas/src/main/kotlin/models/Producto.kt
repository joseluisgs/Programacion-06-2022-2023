package models

import locale.toLocalDate
import locale.toLocalMoney
import java.time.LocalDate

data class Producto(
    val id: Int = 0,
    val nombre: String = "",
    val precio: Double = 0.0,
    val cantidad: Int = 0,
    val createdAt: LocalDate = LocalDate.now(),
    val updatedAt: LocalDate = LocalDate.now(),
    val disponible: Boolean = true,
) {
    fun toLocalString(): String {
        return "Producto(id=$id, nombre='$nombre', precio=${precio.toLocalMoney()}, cantidad=$cantidad, , disponible=$disponible, createdAt=${createdAt.toLocalDate()}, updatedAt=${updatedAt.toLocalDate()})"
    }
}
