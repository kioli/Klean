package kioli.clean.domain.repository

import io.reactivex.Observable
import kioli.clean.data.entity.Quote
import kioli.clean.data.store.QuoteDataStoreFactory

internal class QuoteRepository(private val dataStoreFactory: QuoteDataStoreFactory)
    : BaseRepository(), QuoteRepositoryI {

    private val observableCacheKey = "quote observable"

    override fun getQuote(forceNew: Boolean): Observable<Quote> {
        val observableRemote = dataStoreFactory.getCloudDataStore().getQuote()
        val observableLocal = dataStoreFactory.getLocalDataStore().getQuote()
        if (forceNew) {
            return observableRemote
        }
        return cacheObservable(observableCacheKey,
                observableLocal.concatWith(observableRemote).take(1)) as Observable<Quote>
    }
}