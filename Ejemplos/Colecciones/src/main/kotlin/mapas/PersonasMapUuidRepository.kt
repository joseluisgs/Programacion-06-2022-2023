package mapas

import base.CrudRepository
import models.Persona
import java.util.*

class PersonasMapUuidRepository: CrudRepository<Persona, UUID> {
    val personas = mutableMapOf<UUID, Persona>()
    override fun findAll(): List<Persona> {
        return personas.values.toList()
    }

    override fun findById(id: UUID): Persona? {
        return personas[id]
    }

    override fun save(entity: Persona): Persona {
        personas[entity.uuid] = entity
        return entity
    }

    override fun deleteById(id: UUID): Persona? {
        return personas.remove(id)
    }
}