package kioli.clean.data.store

import io.reactivex.Observable
import kioli.clean.data.entity.Quote

internal interface QuoteDataStoreI {

    /**
     * Get an [Observable] which will emit a Quote
     */
    fun getQuote(): Observable<Quote>
}