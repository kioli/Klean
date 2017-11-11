package kioli.clean.domain.repository

import io.reactivex.Observable
import kioli.clean.App
import kioli.clean.data.entity.Quote
import kioli.clean.data.store.QuoteDataStoreFactory
import javax.inject.Inject

internal class QuoteRepository : BaseRepository(), QuoteRepositoryI {

    private val observableCacheKey = "observable"

    @Inject
    lateinit var dataStoreFactory: QuoteDataStoreFactory

    init {
        App.component.inject(this)
    }

    override fun getQuote(forceNew: Boolean): Observable<Quote> {
        val observableRemote = dataStoreFactory.getCloudDataStore().getQuote()
        val observableLocal = dataStoreFactory.getLocalDataStore().getQuote()
        if (forceNew) {
            return observableRemote
        }
        return cacheObservable(observableCacheKey, observableLocal.concatWith(observableRemote).take(1)) as Observable<Quote>
    }
}