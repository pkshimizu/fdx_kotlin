package net.noncore.fdx.io.file

import java.io.File as JavaFile
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

interface File : FileResource {
    val inputStream: InputStream
    val outputStream: OutputStream
    val size: Size
    fun copyTo(destination: Folder)
    fun moveTo(destination: Folder)
    fun delete()
}

internal class FileImpl(path: Path) : FileBase(path), File {
    override val inputStream: InputStream
        get() = FileInputStream(file)
    override val outputStream: OutputStream
        get() = FileOutputStream(file)
    override val size: Size
        get() = Size(file.length())

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
