package kioli.clean.domain.repository

import io.reactivex.Observable
import kioli.clean.data.entity.Quote
import javax.inject.Singleton

internal interface QuoteRepositoryI {

    /**
     * Get an [Observable] which will emit a String
     *
     * @param forceNew decides whether to force the retrieval of a new quote or not
     */
    fun getQuote(forceNew: Boolean): Observable<Quote>
}