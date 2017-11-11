package kioli.clean

import android.app.Application
import kioli.clean.di.*

internal class App : Application() {

    companion object {
        @JvmStatic lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
                .builder()
                .quoteModule(QuoteModule())
                .contextModule(ContextModule(baseContext))
                .threadModule(ThreadModule())
                .build()
    }

}