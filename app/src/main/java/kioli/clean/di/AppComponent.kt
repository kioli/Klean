package kioli.clean.di

import dagger.Component
import kioli.clean.data.store.QuoteDataStoreFactory
import kioli.clean.domain.repository.QuoteRepository
import kioli.clean.presentation.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ContextModule::class))
internal interface AppComponent {
    fun inject(dataStoreFactory: QuoteDataStoreFactory)

    fun inject(repository: QuoteRepository)

    fun inject(mainActivity: MainActivity)
}