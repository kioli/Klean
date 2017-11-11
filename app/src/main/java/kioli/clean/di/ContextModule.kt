package kioli.clean.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class ContextModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideContext() = context
}