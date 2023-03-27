package repositories.productos

import models.Producto
import repositories.base.CrudRepository

interface ProductosRepository : CrudRepository<Producto, Int> {
    fun findAllByDisponible(disponible: Boolean): List<Producto>
    fun findByNombre(nombre: String): List<Producto>
}