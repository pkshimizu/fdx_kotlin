package net.noncore.fdx.io.file

import java.nio.file.attribute.FileTime
import java.time.ZoneId
import java.io.File as JavaFile
import java.time.ZonedDateTime

interface FileResource {
    val path: Path
    val parent: Folder?
    val readable: Boolean
    val writable: Boolean
    val executable: Boolean
    val hidden: Boolean
    val exists: Boolean
    val dateTime: ZonedDateTime
}

internal abstract class FileBase(final override val path: Path) : FileResource {
    protected val file = JavaFile(path.toString())

    override val parent: Folder?
        get() = if (path.parent != null) FolderImpl(path.parent) else null
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

}
