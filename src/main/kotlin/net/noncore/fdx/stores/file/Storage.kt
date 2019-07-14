package net.noncore.fdx.stores.file

import net.noncore.fdx.stores.Store

interface Storage : Store {
    fun find(path: Path): FileResource
    fun roots(): List<Folder>
}