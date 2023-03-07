package mapas

import base.CrudRepository
import models.Persona

class PersonasMapAutoIntRepository: CrudRepository<Persona, Int> {
    val personas = mutableMapOf<Int, Persona>()
    override fun findAll(): List<Persona> {
        return personas.values.toList()
    }

    override fun deleteById(id: Int): Persona? {
        return personas.remove(id)
    }

    override fun save(entity: Persona): Persona {
        // Cogemos la clave más alta y le sumamos 1
        val id = personas.keys.last() + 1
        // Si hay que asignarsela a la entidad
        // val insertada = entity.copy(id = id)
        // personas[id] = insertada
        personas[id] = entity
        return entity
    }

    override fun findById(id: Int): Persona? {
        return personas[id]
    }
}