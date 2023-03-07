package listas.tda

interface Pila<T> {
    fun push(item: T)
    fun pop(): T?
    fun peek(): T?
    fun size(): Int
    fun isEmpty(): Boolean
}