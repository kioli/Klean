package kioli.clean.presentation.view

import android.content.Context

internal interface IView {

    /**
     * It returns the view's context
     *
     * @return context
     */
    fun context(): Context

    /**
     * It should be called in the view's (Activity or Fragment) onCreate() method
     */
    fun create()

    /**
     * It should be called in the view's (Activity or Fragment) onDestroy() method.
     */
    fun destroy()
}