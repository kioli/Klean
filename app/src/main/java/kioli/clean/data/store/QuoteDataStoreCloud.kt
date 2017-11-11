package kioli.clean.data.store

import io.reactivex.Observable
import kioli.clean.data.entity.Quote
import kioli.clean.data.network.QuoteApi
import java.util.concurrent.TimeUnit

class QuoteDataStoreCloud(private val api: QuoteApi) : QuoteDataStoreI {

    override fun getQuote(): Observable<Quote> = api.getQuote().delay(3, TimeUnit.SECONDS)
}