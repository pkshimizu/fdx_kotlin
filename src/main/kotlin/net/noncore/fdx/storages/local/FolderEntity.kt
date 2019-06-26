package net.noncore.fdx.storages.local

import net.noncore.fdx.storages.Collection
import net.noncore.fdx.storages.Entity
import net.noncore.fdx.storages.Resource
import net.noncore.fdx.storages.Size
import java.lang.UnsupportedOperationException
import java.nio.file.Paths

class FolderEntity(override val location: LocalLocation) : Collection, LocalEntity(location) {
    override fun entities(): List<Entity> {
        return file.listFiles().map {
            when {
                it.isFile -> FileEntity(LocalLocation(it.path))
                it.isDirectory -> FolderEntity(LocalLocation(it.path))
                else -> throw UnsupportedOperationException()
            }
        }.toList()
    }

    override fun createCollection(name: String): Collection {
        val path = Paths.get(file.path, name)
        path.toFile().mkdirs()
        return FolderEntity(LocalLocation(path.toString()))
    }

    override fun createResource(name: String): Resource {
        val path = Paths.get(file.path, name)
        path.toFile().createNewFile()
        return FileEntity(LocalLocation(path.toString()))
    }

    override fun calcSize(): Size {
        return Size(file.listFiles().filter { it.isFile }.map { it.length() }.sum())
    }
}
