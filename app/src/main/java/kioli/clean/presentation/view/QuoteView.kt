package kioli.clean.presentation.view

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import kioli.clean.R
import kioli.clean.presentation.model.QuoteModel
import kioli.clean.presentation.presenter.QuotePresenterI
import kioli.clean.show
import kotlinx.android.synthetic.main.view_quote.view.*

@SuppressLint("ViewConstructor")
internal class QuoteView(context: Context, private val presenter: QuotePresenterI)
    : SwipeRefreshLayout(context), QuoteViewI {

    init {
        inflate(getContext(), R.layout.view_quote, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        background = ContextCompat.getDrawable(context, R.color.colorPrimary)

        setOnRefreshListener {
            isRefreshing = false
            presenter.getQuote(true)
        }
    }

    override fun create() {
        presenter.view = this
        presenter.getQuote(false)
    }

    override fun destroy() {
        presenter.destroy()
    }

    override fun setQuote(quote: QuoteModel) {
        quoteField.text = quote.text
    }

    override fun setLoadingVisibility(isVisible: Boolean) {
        loadingScreen.show(isVisible)
    }

    override fun context(): Context = context
}