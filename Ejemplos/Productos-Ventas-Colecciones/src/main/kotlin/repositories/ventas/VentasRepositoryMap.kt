package repositories.ventas

import models.Venta
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

object VentasRepositoryMap : VentasRepository {
    private val ventas = mutableListOf<Venta>()
    override fun getNewId(): Int {
        logger.debug { "getNewId" }
        val lastId = ventas.maxOfOrNull { it.id } ?: 0
        return lastId + 1
    }

    override fun findAll(): List<Venta> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): Venta? {
        logger.debug { "findById(${id})" }
        return ventas.find { it.id == id }
    }

    override fun save(entity: Venta): Venta {
        logger.debug { "save: $entity" }
        ventas.add(entity)
        return entity
    }

    override fun update(entity: Venta): Venta? {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int): Venta? {
        TODO("Not yet implemented")
    }
}