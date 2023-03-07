package controllers

import exceptions.ProductoNoEncontradoException
import models.Producto
import mu.KotlinLogging
import repositories.productos.ProductosRepository
import validators.validar

private val logger = KotlinLogging.logger {}

class ProductosController(
    private val productosRepository: ProductosRepository
) {
    fun findAll(disponible: Boolean = true): List<Producto> {
        logger.info { "findAll: $disponible" }
        return productosRepository.findAllByDisponible(disponible)
    }

    fun findById(id: Int): Producto {
        logger.info { "findById: $id" }
        return productosRepository.findById(id)
            ?: throw ProductoNoEncontradoException("Producto con $id no existe en almacenamiento")
    }

    fun findByNombre(nombre: String): List<Producto> {
        logger.info { "findByNombre: $nombre" }
        return productosRepository.findByNombre(nombre)
    }

    fun save(producto: Producto): Producto {
        logger.info { "save: $producto" }
        producto.validar() // Validar el producto
        return productosRepository.save(producto)
    }

    fun update(producto: Producto): Producto {
        logger.info { "update: $producto" }
        producto.validar() // Validar el producto
        return productosRepository.update(producto)
            ?: throw ProductoNoEncontradoException("Producto con ${producto.id} no existe en almacenamiento")
    }

    fun deleteById(id: Int): Producto {
        logger.info { "deleteById: $id" }
        return productosRepository.deleteById(id)
            ?: throw ProductoNoEncontradoException("Producto con $id no existe en almacenamiento")
    }
}