package net.noncore.fdx.storages.local

import net.noncore.fdx.storages.Resource
import net.noncore.fdx.storages.Size
import java.io.*

class FileEntity(override val location: LocalLocation) : Resource, LocalEntity(location) {
    override val inputStream: InputStream
        get() = FileInputStream(file)
    override val outputStream: OutputStream
        get() = FileOutputStream(file)
    override val size: Size
        get() = Size(file.length())
}
