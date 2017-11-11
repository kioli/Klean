package kioli.clean

import kioli.clean.di.DaggerTestAppComponent
import kioli.clean.di.TestAppModule
import kioli.clean.domain.interactor.QuoteUseCase
import kioli.clean.presentation.mapper.QuoteModelDataMapper
import kioli.clean.presentation.presenter.QuotePresenter
import kioli.clean.presentation.view.QuoteView
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import javax.inject.Inject

internal class QuotePresenterTest {

    @Inject
    lateinit var useCase: QuoteUseCase
    @Inject
    lateinit var mapper: QuoteModelDataMapper
    @Inject
    lateinit var quoteView: QuoteView

    private lateinit var quotePresenter: QuotePresenter

    @Before
    fun setup() {
        val component = DaggerTestAppComponent
                .builder()
                .testAppModule(TestAppModule())
                .build()
        component.inject(this)
        quotePresenter = QuotePresenter(useCase, mapper)
        quotePresenter.view = quoteView
    }

    @Test
    @Throws(Exception::class)
    fun `On destroy dispose use case and nullify view`() {
        quotePresenter.destroy()
        assertNull(quotePresenter.view)
    }
}