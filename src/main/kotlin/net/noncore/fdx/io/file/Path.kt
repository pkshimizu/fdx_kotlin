package net.noncore.fdx.io.file

import java.io.File as JavaFile

class Path(val parent: Path?, val name: String) {
    companion object Paths {
        val UserHome = System.getProperty("user.home").toPath()
    }
}

fun String.toPath(): Path {
    val file = JavaFile(this)
    return Path(file.parent.toPath(), file.name)
}
