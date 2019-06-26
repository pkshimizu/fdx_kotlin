package net.noncore.fdx.storages.local

import net.noncore.fdx.storages.Location
import java.nio.file.Paths

class LocalLocation(val path: String) : Location {
    override val name: String
        get() = Paths.get(path).fileName.toString()
    override val parent: Location
        get() = LocalLocation(Paths.get(path).parent.toString())
}
