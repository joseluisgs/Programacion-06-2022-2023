package controllers

import exceptions.CarritoNoValidoException
import exceptions.ProductoNoValidoException
import models.LineaVenta
import models.Venta
import mu.KotlinLogging
import repositories.productos.ProductosRepository
import repositories.ventas.VentasRepository
import validators.validar

private val logger = KotlinLogging.logger {}

class VentasController(
    val ventasRepository: VentasRepository,
    val productosRepository: ProductosRepository
) {
    fun save(userId: Int, items: Map<Int, Int>): Venta {
        logger.info { "save: $userId, $items" }
        require(items.isNotEmpty()) { throw CarritoNoValidoException("Carrito debe tener al menos un producto") }

        val venta = Venta(id = ventasRepository.getNewId(), userId = userId)
        // Validar
        venta.validar()
        comprobarExistenciaProductos(items)
        // actualizar stock
        actualizarStock(items)
        // Creamos las lineas de carrito
        crearLineasCarrito(venta, items)
        // añadir lineas al carrito
        // carrito.lineas.addAll(lineas)
        return ventasRepository.save(venta)
    }

    private fun crearLineasCarrito(venta: Venta, items: Map<Int, Int>) {
        logger.debug { "crearLineasCarrito: $venta, $items" }
        items.forEach { item ->
            val producto = productosRepository.findById(item.key)
                ?: throw ProductoNoValidoException("Producto con id ${item.key} no es válido")
            logger.debug { "Producto encontrado: $producto" }
            val linea = LineaVenta(
                idVenta = venta.id,
                idLineaVenta = venta.nextLineaId,
                idProducto = producto.id,
                cantidad = item.value,
                precioProducto = producto.precio
            )
            venta.addLinea(linea)
        }
    }

    private fun actualizarStock(items: Map<Int, Int>) {
        items.forEach { item ->
            val producto = productosRepository.findById(item.key)
                ?: throw ProductoNoValidoException("Producto con id ${item.key} no es válido")
            logger.debug { "Producto encontrado: $producto" }
            val updated = producto.copy(cantidad = producto.cantidad - item.value)
            productosRepository.update(updated)
        }
    }

    private fun comprobarExistenciaProductos(items: Map<Int, Int>) {
        logger.debug { "comprobarExistenciaProductos: $items" }
        items.forEach { item ->
            val producto = productosRepository.findById(item.key)
                ?: throw ProductoNoValidoException("Producto con id ${item.key} no es válido")
            logger.debug { "Producto encontrado: $producto" }
            if (producto.cantidad < item.value) {
                throw CarritoNoValidoException("No hay suficiente stock para el producto ${producto.id}")
            }

        }
    }

    fun findById(id: Int): Venta {
        logger.info { "findById: $id" }
        return ventasRepository.findById(id)
            ?: throw Exception("Carrito con $id no existe en almacenamiento")
    }
}
