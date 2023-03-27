package listas.repositories.lists

import listas.tda.Pila

class StackRepository<T>: Pila<T> {
    private val items: MutableList<T> = mutableListOf()

    override fun push(item: T) {
        items.add(item)
    }

    override fun pop(): T? {
       /* return if (personas.isEmpty()) {
            null
        } else {
            personas.removeAt(personas.lastIndex)
        }*/

        /*personas.isEmpty().let {
            return personas.removeAt(personas.lastIndex)
        }*/

        return items.removeLastOrNull()
    }

    override fun peek(): T? {
        /*return if (personas.isEmpty()) {
            null
        } else {
            personas[personas.lastIndex]
        }*/
        return items.lastOrNull()
    }

    override fun size(): Int {
        return items.size
    }

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    override fun toString(): String {
        return items.toString()
    }
}
