package net.noncore.fdx.storages

interface Location {
    val name: String
    val parent: Location
}