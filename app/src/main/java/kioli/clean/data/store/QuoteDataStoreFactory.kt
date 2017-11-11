package kioli.clean.data.store

import android.content.Context
import kioli.clean.data.network.QuoteApi

/**
 * Factory that creates different implementations of [QuoteDataStoreI].
 */
internal class QuoteDataStoreFactory internal constructor(private val context: Context,
                                                          private val api: QuoteApi)
    : QuoteDataStoreFactoryI {

    override fun getLocalDataStore() = QuoteDataStoreDisk(context)

    override fun getCloudDataStore() = QuoteDataStoreCloud(api)

}