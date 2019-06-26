package net.noncore.fdx.storages.local

import net.noncore.fdx.storages.Entity
import net.noncore.fdx.storages.Location
import net.noncore.fdx.storages.Storage
import java.io.File

class LocalStorage : Storage {
    override fun find(location: Location): Entity {
        if (location is LocalLocation) {
            val file = File(location.path)
            return when {
                file.isFile -> FileEntity(location)
                file.isDirectory -> FolderEntity(location)
                else -> throw UnsupportedOperationException()
            }
        } else {
            throw UnsupportedOperationException()
        }
    }

    override fun entities(): List<Entity> {
        return FolderEntity(LocalLocation("/")).entities()
    }
}
