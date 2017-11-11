package kioli.clean.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kioli.clean.data.network.QuoteApi
import kioli.clean.data.store.QuoteDataStoreFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
internal open class AppModule {
    @Provides
    @Singleton
    open fun provideQuoteApi() = QuoteApi()

    @Provides
    @Singleton
    @Inject
    open fun provideDataStoreFactory(context: Context, api: QuoteApi) = QuoteDataStoreFactory(context, api)
}