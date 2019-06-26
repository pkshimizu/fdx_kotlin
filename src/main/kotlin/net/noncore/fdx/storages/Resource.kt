package net.noncore.fdx.storages

import java.io.InputStream
import java.io.OutputStream

interface Resource : Entity {
    val inputStream: InputStream
    val outputStream: OutputStream
    val size: Size
}