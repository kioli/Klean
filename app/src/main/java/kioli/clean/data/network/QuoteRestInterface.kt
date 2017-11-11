package kioli.clean.data.network

import io.reactivex.Observable
import kioli.clean.data.entity.Quote
import retrofit2.http.GET

interface QuoteRestInterface {

    // Object set to be able to assign constants in an interface
    object ApiSettings {
        // Constants expressed with 'const' that forces to give a value at compile time instead of runtime
        // if there was only 'val' they could have been assigned a function
        const val randomQuote = "?method=getQuote&format=json&lang=en"
    }

    @GET(ApiSettings.randomQuote)
    fun loadQuote(): Observable<Quote>
}