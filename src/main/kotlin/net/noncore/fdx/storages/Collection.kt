package net.noncore.fdx.storages

interface Collection : Entity {
    fun entities(): List<Entity>
    fun createCollection(name: String): Collection
    fun createResource(name: String): Resource
    fun calcSize(): Size
}