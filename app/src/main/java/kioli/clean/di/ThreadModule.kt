package kioli.clean.di

import dagger.Module
import dagger.Provides
import kioli.clean.domain.executor.IoThread
import kioli.clean.domain.executor.MainThread
import javax.inject.Singleton

@Module
internal class ThreadModule {
    @Provides
    @Singleton
    fun provideIoThread() = IoThread()

    @Provides
    @Singleton
    fun provideMainThread() = MainThread()
}