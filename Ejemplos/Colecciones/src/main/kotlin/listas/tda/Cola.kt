package listas.tda

interface Cola<T> {
    fun enqueue(item: T)
    fun dequeue(): T?
    fun first(): T?
    fun size(): Int
    fun isEmpty(): Boolean
}