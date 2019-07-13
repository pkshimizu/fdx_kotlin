package net.noncore.fdx.io.file

interface Storage {
    fun find(path: Path): FileResource
    fun roots(): List<Folder>
}