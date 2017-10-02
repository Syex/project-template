package de.memorian.template.presentation.base

/**
 * Interface for any *View* that supports some kind of content loading.
 */
interface LoadingView {

    /**
     * Instructs the view to disable any UI input and show a loading animation.
     */
    fun showLoading()

    /**
     * Instructs the view to enable any UI input again and hide the loading animation.
     */
    fun hideLoading()
}