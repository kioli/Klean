package kioli.clean.domain.executor

import io.reactivex.Scheduler

/**
 * Every implementation will execute the [UseCase] out of the UI thread.
 */
internal interface ThreadExecution {
    val schedulerNonUiThread: Scheduler
}
