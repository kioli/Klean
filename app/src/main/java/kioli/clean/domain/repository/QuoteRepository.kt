package kioli.clean.domain.repository

import io.reactivex.Observable
import kioli.clean.data.entity.Quote
import kioli.clean.data.store.QuoteDataStoreFactory

internal class QuoteRepository(private val dataStoreFactory: QuoteDataStoreFactory)
    : BaseRepository(), QuoteRepositoryI {

    override fun getQuote(forceNew: Boolean): Observable<Quote> {
        val observableRemote = dataStoreFactory.getCloudDataStore().getQuote()
        val observableLocal = dataStoreFactory.getLocalDataStore().getQuote()
        if (forceNew) {
            return observableRemote
        }
        return observableLocal
    }
}