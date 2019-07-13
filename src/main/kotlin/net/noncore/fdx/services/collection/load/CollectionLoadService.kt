package net.noncore.fdx.services.collection.load

class CollectionLoadParams {
}

class CollectionLoadResult {
}

interface CollectionLoadService {
    fun load(params: CollectionLoadParams): CollectionLoadResult
}

class CollectionLoadLogic : CollectionLoadService {
    override fun load(params: CollectionLoadParams): CollectionLoadResult {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
