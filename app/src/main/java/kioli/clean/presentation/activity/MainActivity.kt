package kioli.clean.presentation.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kioli.clean.App
import kioli.clean.R
import kioli.clean.data.network.QuoteApi
import kioli.clean.data.store.QuoteDataStoreFactory
import kioli.clean.data.store.QuoteDataStoreFactoryI
import kioli.clean.domain.executor.IoThread
import kioli.clean.domain.executor.MainThread
import kioli.clean.domain.interactor.QuoteUseCase
import kioli.clean.domain.repository.QuoteRepository
import kioli.clean.domain.repository.QuoteRepositoryI
import kioli.clean.presentation.mapper.QuoteModelDataMapper
import kioli.clean.presentation.presenter.QuotePresenter
import kioli.clean.presentation.presenter.QuotePresenterI
import kioli.clean.presentation.view.IView
import kioli.clean.presentation.view.QuoteView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

internal class MainActivity : AppCompatActivity() {

    private lateinit var dataStoreFactory: QuoteDataStoreFactoryI
    private lateinit var presenter: QuotePresenterI
    private lateinit var repo: QuoteRepositoryI
    private lateinit var useCase: QuoteUseCase
    private lateinit var view: IView

    @Inject
    lateinit var api: QuoteApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.component.inject(this)

        dataStoreFactory = QuoteDataStoreFactory(baseContext, api)
        repo = QuoteRepository()
        useCase = QuoteUseCase(repo, IoThread(), MainThread())
        presenter = QuotePresenter(useCase, QuoteModelDataMapper())
        view = QuoteView(baseContext, presenter)
        view.create()
        container.addView(view as View)
    }

    override fun onDestroy() {
        super.onDestroy()
        view.destroy()
    }
}
