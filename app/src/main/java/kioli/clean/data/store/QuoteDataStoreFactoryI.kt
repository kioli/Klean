package kioli.clean.data.store

internal interface QuoteDataStoreFactoryI {

    fun getLocalDataStore(): QuoteDataStoreDisk

    fun getCloudDataStore(): QuoteDataStoreCloud
}