package de.memorian.template.domain.logging

import android.content.Context
import android.util.Log
import timber.log.Timber

/**
 * A timber tree for production. Only logs errors.
 */
class ProductionTree(context: Context) : Timber.Tree() {

    override fun log(priority: Int, tag: String, message: String, t: Throwable?) {
        if (priority == Log.ERROR) {
            if (t != null) {
                // send error
            } else {
                // send error
            }
        }
    }
}