package kioli.clean.presentation.presenter

internal interface IPresenter {

    /**
     * It should be called in the view's [IView] onDestroy() method.
     */
    fun destroy()
}