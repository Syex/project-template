package de.memorian.template.presentation.base

import io.reactivex.disposables.Disposable
import net.grandcentrix.thirtyinch.TiPresenter
import net.grandcentrix.thirtyinch.TiView
import net.grandcentrix.thirtyinch.rx2.RxTiPresenterDisposableHandler

/**
 * Base class for all *presenters*, adding some utility for managing [Disposables][Disposable].
 */
abstract class BaseTiPresenter<V : TiView> : TiPresenter<V>() {

    private val rxHelper = RxTiPresenterDisposableHandler(this)

    protected fun Disposable.disposeIn_onDestroy(): Disposable {
        return rxHelper.manageDisposable(this)
    }

    protected fun Disposable.disposeIn_onDetach(): Disposable {
        return rxHelper.manageViewDisposable(this)
    }
}