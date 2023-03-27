package carrito

/*
private val logger = KotlinLogging.logger {}

private val productosController = ProductosController(ProductosRepositoryMap())
private val ventasRepository = VentasRepositoryImpl()
fun main() {


    repeat(10) {
        productosController.save(productoRandom())
    }

    val cliente = User(1, "Pepe", "pepe@pepe.com", "1234")

    val carrito = iniciarVenta(cliente)

    // Id del producto y cantidad
    val listaProductos = listOf(1 to 2, 2 to 3, 5 to 1)

    listaProductos.forEach {
        datosLinea(it, carrito)
    }

    // Finalizar venta
    finalizarVenta(carrito)

}

fun finalizarVenta(carrito: Carrito) {
    logger.info { "Finalizando venta" }
    ventasRepository.save(carrito)
    logger.info { "Venta finalizada" }
    println("TOTAL: ${carrito.total}")
}


fun iniciarVenta(cliente: User): Carrito {
    logger.info { "Iniciando venta para el cliente: $cliente" }
    val newId = ventasRepository.getNewId()
    return Carrito(newId, cliente)
}

fun datosLinea(datos: Pair<Int, Int>, carrito: Carrito) {
    logger.info { "Iniciando linea" }
    val producto = productosController.findById(datos.first)
    val stock = producto.cantidad
    if (stock >= datos.second) {
        logger.info { "Hay stock suficiente" }
        // Actualizar el stock
        val newStock = stock - datos.second
        val productoActualizado = producto.copy(cantidad = newStock)
        productosController.update(productoActualizado)
        // Creamos la linea de venta
        val linea = LineaCarrito(carrito.id, carrito.nextLineaId, producto.id, datos.second, producto.precio)
        carrito.addLinea(linea)
    } else {
        logger.info { "No hay stock suficiente" }
        throw Exception("No hay stock suficiente")
    }
}
*/
