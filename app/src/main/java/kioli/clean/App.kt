package kioli.clean

import android.app.Application
import kioli.clean.di.AppComponent
import kioli.clean.di.AppModule
import kioli.clean.di.ContextModule
import kioli.clean.di.DaggerAppComponent

internal class App : Application() {

    companion object {
        @JvmStatic lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent
                .builder()
                .appModule(AppModule())
                .contextModule(ContextModule(baseContext))
                .build()
    }

}