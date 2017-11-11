package kioli.clean.presentation.presenter

import android.preference.PreferenceManager
import android.util.Log
import kioli.clean.data.entity.Quote
import kioli.clean.data.store.QuoteDataStoreDisk
import kioli.clean.domain.interactor.QuoteUseCase
import kioli.clean.presentation.mapper.QuoteModelDataMapper
import kioli.clean.presentation.view.QuoteViewI

internal class QuotePresenter(private val useCase: QuoteUseCase,
                              private val mapper: QuoteModelDataMapper)
    : QuotePresenterI {

    override var view: QuoteViewI? = null

    override fun destroy() {
        view = null
    }

    override fun getQuote(forceNew: Boolean) {
        view?.setLoadingVisibility(true)
        useCase.execute(QuoteObserver(), forceNew)
    }

    private fun sendResultToView(quote: Quote?) {
        view?.setLoadingVisibility(false)
        quote?.let {
            val quoteModel = mapper.transform(it)
            view?.setQuote(quoteModel)
        }
    }

    private inner class QuoteObserver : BaseObserver<Quote>() {

        override fun onComplete() {}

        override fun onError(exception: Throwable) {
            Log.e("Mandragola", "error getting quote: ${exception.localizedMessage}")
        }

        override fun onNext(result: Quote) {
            val editor = PreferenceManager.getDefaultSharedPreferences(view?.context()).edit()
            editor.putString(QuoteDataStoreDisk.sharedPrefQuoteAuthorKey, result.author)
            editor.putString(QuoteDataStoreDisk.sharedPrefQuoteTextKey, result.text)
            editor.apply()
            this@QuotePresenter.sendResultToView(result)
            useCase.isExecuting = false
        }
    }
}