package kioli.clean.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kioli.clean.data.network.QuoteApi
import kioli.clean.data.store.QuoteDataStoreFactory
import kioli.clean.domain.executor.IoThread
import kioli.clean.domain.executor.MainThread
import kioli.clean.domain.interactor.QuoteUseCase
import kioli.clean.domain.repository.QuoteRepository
import kioli.clean.presentation.mapper.QuoteModelDataMapper
import kioli.clean.presentation.presenter.QuotePresenter
import kioli.clean.presentation.view.QuoteView
import javax.inject.Inject
import javax.inject.Singleton

@Module
internal open class QuoteModule {
    @Provides
    @Singleton
    open fun provideApi() = QuoteApi()

    @Provides
    open fun provideView(context: Context,
                         presenter: QuotePresenter) = QuoteView(context, presenter)

    @Provides
    @Singleton
    open fun providePresenter(useCase: QuoteUseCase,
                              mapper: QuoteModelDataMapper) = QuotePresenter(useCase, mapper)

    @Provides
    @Inject
    open fun provideUseCase(repository: QuoteRepository,
                            threadPre: IoThread,
                            threadPost: MainThread) = QuoteUseCase(repository, threadPre, threadPost)

    @Provides
    @Inject
    open fun provideRepository(factory: QuoteDataStoreFactory) = QuoteRepository(factory)

    @Provides
    @Inject
    open fun provideDataStoreFactory(context: Context,
                                     api: QuoteApi) = QuoteDataStoreFactory(context, api)

    @Provides
    open fun provideDataMapper() = QuoteModelDataMapper()

}