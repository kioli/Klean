package kioli.clean.domain.executor

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Implementation based on a [Scheduler] which will execute actions on the Android UI thread
 */
class IoThread : ThreadExecution {

    override val schedulerNonUiThread: Scheduler
        get() = Schedulers.io()
}