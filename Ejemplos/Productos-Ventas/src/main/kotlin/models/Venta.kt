package models

import locale.toLocalDate
import locale.toLocalMoney
import java.time.LocalDate

data class Venta(
    val id: Int = 0,
    val userId: Int,
    val lineas: MutableList<LineaVenta> = mutableListOf(),
    val createdAt: LocalDate = LocalDate.now(),
    val updatedAt: LocalDate = LocalDate.now(),
) {
    val total: Double
        get() = lineas.sumOf { it.total }

    val totalItems: Int
        get() = lineas.sumOf { it.cantidad }

    val nextLineaId: Int
        get() {
            val id = lineas.maxByOrNull { it.idLineaVenta }?.idLineaVenta ?: 0
            return id + 1
        }

    fun addLinea(linea: LineaVenta) {
        lineas.add(linea)
    }

    fun removeLinea(idLineaCarrito: Int) {
        lineas.removeIf { it.idLineaVenta == idLineaCarrito }
    }

    fun toLocalString(): String {
        return "Venta(id=$id, userId=$userId, totalItems=$totalItems, total=${total.toLocalMoney()}, lineas=${
            lineas.joinToString(
                prefix = "[",
                postfix = "]"
            ) { it.toLocalString() }
        } , createdAt=${createdAt.toLocalDate()}, updatedAt=${updatedAt.toLocalDate()})"
    }
}