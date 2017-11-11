package kioli.clean.presentation.view

import kioli.clean.presentation.model.QuoteModel

internal interface QuoteViewI : IView {

    /**
     * Set a given quote in the view
     */
    fun setQuote(quote: QuoteModel)

    /**
     * Set the loading screen visibility
     */
    fun setLoadingVisibility(isVisible: Boolean)
}