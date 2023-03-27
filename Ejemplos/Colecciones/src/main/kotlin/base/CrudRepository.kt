package base

interface CrudRepository <T, ID> {
    fun findAll(): List<T>
    fun findById(id: ID): T?
    fun save(entity: T): T
    fun deleteById(id: ID): T?
}