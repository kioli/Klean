package kioli.clean.data.store

import android.content.Context
import android.preference.PreferenceManager
import io.reactivex.Observable
import kioli.clean.data.entity.Quote

class QuoteDataStoreDisk(private val context: Context) : QuoteDataStoreI {

    companion object {
        const val sharedPrefQuoteTextKey = "key for quote text in SP"
        const val sharedPrefQuoteAuthorKey = "key for quote author in SP"
    }

    override fun getQuote(): Observable<Quote> = Observable.create<Quote> { emitter ->
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val text = pref.getString(sharedPrefQuoteTextKey, "")
        val author = pref.getString(sharedPrefQuoteAuthorKey, "")
        if (text.isNotBlank() && author.isNotBlank()) {
            emitter.onNext(Quote(author, text))
        }
        emitter.onComplete()
    }
}