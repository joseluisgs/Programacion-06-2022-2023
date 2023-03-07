package repositories.productos

import models.Producto
import mu.KotlinLogging
import java.time.LocalDate

private val logger = KotlinLogging.logger {}

object ProductosRepositoryMap : ProductosRepository {
    private val almacen = mutableMapOf<Int, Producto>()
    override fun findAllByDisponible(disponible: Boolean): List<Producto> {
        logger.debug { "findAllByDisponible: $disponible" }
        return almacen.values.filter { it.disponible == disponible }
    }

    override fun findByNombre(nombre: String): List<Producto> {
        logger.debug { "findByNombre: $nombre" }
        return almacen.values.filter { it.nombre.lowercase().contains(nombre.lowercase()) }
    }

    override fun findAll(): List<Producto> {
        logger.debug { "findAll" }
        return almacen.values.toList()
    }

    override fun findById(id: Int): Producto? {
        logger.debug { "findById: $id" }
        return almacen[id]
    }

    override fun save(entity: Producto): Producto {
        logger.debug { "save: $entity" }
        // Obtener primero el ultimo id
        val lastId = (almacen.keys.maxOrNull() ?: 0) + 1
        // Crear un nuevo producto con el id
        val newProducto = entity.copy(id = lastId, createdAt = LocalDate.now(), updatedAt = LocalDate.now())
        // Guardar el producto en el almacen
        almacen[newProducto.id] = newProducto
        // Retornar el producto
        logger.debug { "newProducto: $newProducto" }
        return newProducto
    }

    override fun update(entity: Producto): Producto? {
        logger.debug { "update: $entity" }
        // Si no es nulo, actualizar el producto
        almacen[entity.id]?.let {
            logger.debug { "producto existe y actualizando valores: $entity" }
            val updatedProducto = entity.copy(updatedAt = LocalDate.now())
            almacen[updatedProducto.id] = updatedProducto
            return updatedProducto
        } ?: return null
    }

    override fun deleteById(id: Int): Producto? {
        logger.debug { "deleteById: $id" }
        return almacen.remove(id)
    }
}