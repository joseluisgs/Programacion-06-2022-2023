import controllers.ProductosController
import controllers.VentasController
import factories.productoRandom
import models.User
import repositories.productos.ProductosRepositoryMap
import repositories.ventas.VentasRepositoryMap

fun main(args: Array<String>) {
    println("Hola Carro de Compra")
    //val productosRepository = ProductosRepositoryMap()
    val productosController = ProductosController(ProductosRepositoryMap)
    val carritoController = VentasController(VentasRepositoryMap, ProductosRepositoryMap)

    repeat(10) {
        productosController.save(productoRandom())
    }

    println("Productos disponibles")
    productosController.findAll().forEach { println(it.toLocalString()) }
    println()

    println("Producto con id 1")
    productosController.findById(1).also { println(it.toLocalString()) }
    println()

    println("Producto con id 100")
    try {
        productosController.findById(100).also { println(it.toLocalString()) }
    } catch (e: Exception) {
        println("ERROR: ${e.message}")
    }
    println()

    println("Productos con nombre 'a'")
    productosController.findByNombre("a").forEach { println(it.toLocalString()) }
    println()

    println("Borrar producto con id 1")
    productosController.deleteById(1).also { println(it.toLocalString()) }
    println()


    println("Productos disponibles")
    println(productosController.findAll().count())
    println()
    productosController.findAll().forEach { println(it.toLocalString()) }

    println()
    println("Prueba Venta")
    val user = User(1, "Juan", "juan@juan.com", "123456")
    val items = mapOf(4 to 2, 2 to 3, 3 to 4)
    var venta = carritoController.save(user.id, items)
    println(venta.toLocalString())
    venta = carritoController.save(user.id, items)
    println()
    println(venta.toLocalString())

}