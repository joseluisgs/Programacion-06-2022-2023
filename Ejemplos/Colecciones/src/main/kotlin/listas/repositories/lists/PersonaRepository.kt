package listas.repositories.lists

import base.CrudRepository
import models.Persona
import java.util.*

class PersonaRepository: CrudRepository<Persona, UUID> {
    private val personas: MutableList<Persona> = mutableListOf()
    override fun findAll(): List<Persona> {
        return personas.toList()
    }

    override fun findById(id: UUID): Persona? {
        for (persona in personas) {
            if (persona.uuid == id) {
                return persona
            }
        }
        return null
    }

    private fun findReturnIndex(id: UUID): Int {
        for (i in personas.indices) {
            if (personas[i].uuid == id) {
                return i
            }
        }
        return -1
    }

    override fun save(entity: Persona): Persona {
        // val persona = findById(entity.uuid)
       /* // Si existe la persona, la actualizamos
        return if (persona!= null) {
            val index = findReturnIndex(entity.uuid)
            personas[index] = entity
            entity
        } else {
            // Si no existe, la añadimos
            personas.add(entity)
            entity
        }*/

        // Si existe la persona, la actualizamos
        findById(entity.uuid)?.let {
            val index = findReturnIndex(entity.uuid)
            personas[index] = entity
            return entity
        } ?: run {
            // Si no existe, la añadimos
            personas.add(entity)
            return entity
        }
    }

    override fun deleteById(id: UUID): Persona? {
        findById(id)?.let {
            val index = findReturnIndex(id)
            return personas.removeAt(index)
        } ?: run {
            return null
        }
    }


}