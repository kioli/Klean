package kioli.clean.di

import dagger.Module
import dagger.Provides
import kioli.clean.data.network.QuoteApi
import kioli.clean.data.store.QuoteDataStoreFactory
import kioli.clean.domain.interactor.QuoteUseCase
import kioli.clean.mock
import kioli.clean.presentation.mapper.QuoteModelDataMapper
import kioli.clean.presentation.view.QuoteView
import javax.inject.Singleton

@Module
internal class TestAppModule {
    @Provides
    @Singleton
    fun provideQuoteApi() = mock<QuoteApi>()

    @Provides
    @Singleton
    fun provideDataStoreFactory() = mock<QuoteDataStoreFactory>()

    @Provides
    @Singleton
    fun provideUseCase() = mock<QuoteUseCase>()

    @Provides
    @Singleton
    fun provideMapper() = mock<QuoteModelDataMapper>()

    @Provides
    @Singleton
    fun provideView() = mock<QuoteView>()

}