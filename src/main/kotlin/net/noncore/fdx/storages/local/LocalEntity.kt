package net.noncore.fdx.storages.local

import net.noncore.fdx.storages.Collection
import net.noncore.fdx.storages.Entity
import java.io.File
import java.lang.UnsupportedOperationException
import java.nio.file.attribute.FileTime
import java.time.ZoneId
import java.time.ZonedDateTime

open class LocalEntity(override val location: LocalLocation) : Entity {
    protected val file = File(location.path)

    override val parent: Collection
        get() = FolderEntity(location.parent as LocalLocation)
    override val readable: Boolean
        get() = file.canRead()
    override val writable: Boolean
        get() = file.canWrite()
    override val executable: Boolean
        get() = file.canExecute()
    override val hidden: Boolean
        get() = file.isHidden
    override val exists: Boolean
        get() = file.exists()
    override val dateTime: ZonedDateTime
        get() = ZonedDateTime.ofInstant(FileTime.fromMillis(file.lastModified()).toInstant(), ZoneId.systemDefault())

    override fun copyTo(destination: Collection) {
        if (destination is FolderEntity) {
            file.copyTo(File(destination.location.path))
        } else {
            throw UnsupportedOperationException()
        }
    }

    override fun moveTo(destination: Collection) {
        if (destination is FolderEntity) {
            file.renameTo(File(destination.location.path))
        } else {
            throw UnsupportedOperationException()
        }
    }

    override fun delete() {
        file.delete()
    }
}
