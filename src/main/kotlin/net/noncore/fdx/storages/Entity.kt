package net.noncore.fdx.storages

import java.time.ZonedDateTime

interface Entity {
    val location: Location
    val name: String
        get() = location.name
    val parent: Collection
    val readable: Boolean
    val writable: Boolean
    val executable: Boolean
    val hidden: Boolean
    val exists: Boolean
    val dateTime: ZonedDateTime
    fun copyTo(destination: Collection)
    fun moveTo(destination: Collection)
    fun delete()
}