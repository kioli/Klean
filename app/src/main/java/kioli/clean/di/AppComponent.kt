package kioli.clean.di

import dagger.Component
import kioli.clean.presentation.activity.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(QuoteModule::class, ContextModule::class, ThreadModule::class))
internal interface AppComponent {
    fun inject(mainActivity: MainActivity)
}