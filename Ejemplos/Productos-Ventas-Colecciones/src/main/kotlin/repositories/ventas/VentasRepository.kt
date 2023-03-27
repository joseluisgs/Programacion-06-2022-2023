package repositories.ventas

import models.Venta
import repositories.base.CrudRepository

interface VentasRepository : CrudRepository<Venta, Int> {
    fun getNewId(): Int
}