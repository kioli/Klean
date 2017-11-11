package kioli.clean.di

import dagger.Component
import kioli.clean.QuotePresenterTest
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(TestAppModule::class))
internal interface TestAppComponent: AppComponent {

    fun inject(test: QuotePresenterTest)
}