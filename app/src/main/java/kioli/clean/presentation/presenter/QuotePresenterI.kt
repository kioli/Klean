package kioli.clean.presentation.presenter

import kioli.clean.presentation.view.QuoteViewI

internal interface QuotePresenterI : IPresenter {

    var view: QuoteViewI?

    /**
     * Retrieve a quote from a specific UseCase
     */
    fun getQuote(forceNew: Boolean)
}