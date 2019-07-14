package net.noncore.fdx.stores.io.file

import java.io.File as JavaFile
import java.nio.file.Paths

interface Folder : FileResource {
    fun resources(): List<FileResource>
    fun createFolder(name: String): Folder
    fun createFile(name: String): File
    fun calcSize(): Size
    fun copyTo(destination: Folder)
    fun moveTo(destination: Folder)
    fun delete()
}

internal class FolderImpl(path: Path) : FileBase(path), Folder {
    override fun resources(): List<FileResource> {
        return file.listFiles().map {
            when {
                it.isFile -> FileImpl(it.path.toPath())
                it.isDirectory -> FolderImpl(it.path.toPath())
                else -> throw UnsupportedOperationException()
            }
        }.toList()
    }

    override fun createFolder(name: String): Folder {
        val path = Paths.get(file.path, name)
        path.toFile().mkdirs()
        return FolderImpl(path.toString().toPath())
    }

    override fun createFile(name: String): File {
        val path = Paths.get(file.path, name)
        path.toFile().createNewFile()
        return FileImpl(path.toString().toPath())
    }

    override fun calcSize(): Size {
        return Size(file.listFiles().filter { it.isFile }.map { it.length() }.sum())
    }

    override fun copyTo(destination: Folder) {
        file.copyTo(JavaFile(destination.path.toString()))
    }

    override fun moveTo(destination: Folder) {
        file.renameTo(JavaFile(destination.path.toString()))
    }

    override fun delete() {
        file.delete()
    }

}
