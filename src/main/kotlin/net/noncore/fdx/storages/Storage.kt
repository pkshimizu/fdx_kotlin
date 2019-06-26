package net.noncore.fdx.storages

interface Storage {
    fun find(location: Location): Entity
    fun entities(): List<Entity>
}