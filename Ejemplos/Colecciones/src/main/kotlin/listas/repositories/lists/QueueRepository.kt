package listas.repositories.lists

import listas.tda.Cola

class QueueRepository<T>: Cola<T> {
    private val items: MutableList<T> = mutableListOf()
    override fun enqueue(item: T) {
        items.add(item)
    }

    override fun dequeue(): T? {
        return items.removeFirstOrNull()
    }

    override fun first(): T? {
        return items.firstOrNull()
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