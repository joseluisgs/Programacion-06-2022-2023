package validators

import exceptions.CarritoNoValidoException
import models.Venta
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}
fun Venta.validar() {
    logger.debug { "validar: $this" }
    require(userId > 0) { throw CarritoNoValidoException("userId debe ser mayor a 0") }
    // require(lineas.isNotEmpty()) { throw CarritoNoValidoException("Carrito debe tener al menos un producto") }
}