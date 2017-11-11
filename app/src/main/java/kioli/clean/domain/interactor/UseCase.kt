package kioli.clean.domain.interactor

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import kioli.clean.domain.executor.ThreadExecution
import kioli.clean.domain.executor.ThreadPostExecution

/**
 * This class represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a [DisposableObserver]
 * that will execute its job in a background thread and will post the result in the UI thread.
 */
internal abstract class UseCase<T, in Params> internal constructor(private val threadExecutor: ThreadExecution,
                                                                   private val postExecutionThread: ThreadPostExecution) {

    private val disposables: CompositeDisposable = CompositeDisposable()
    var isExecuting = false

    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     */
    abstract fun buildUseCaseObservable(params: Params?): Observable<T>

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableObserver] which will be listening to the observable build
     * by [.buildUseCaseObservable] ()} method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableObserver<T>?, params: Params?) {
        if (!isExecuting) {
            observer?.let {
                val observable = buildUseCaseObservable(params)
                        .subscribeOn(threadExecutor.schedulerNonUiThread)
                        .observeOn(postExecutionThread.schedulerUiThread)
                isExecuting = true
                disposables.add(observable.subscribeWith(it))
            }
        }
    }

    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }
}