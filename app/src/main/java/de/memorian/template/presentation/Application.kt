package de.memorian.template.presentation

import android.app.Application
import de.memorian.template.BuildConfig
import de.memorian.template.domain.logging.ProductionTree
import net.grandcentrix.thirtyinch.TiLog
import timber.log.Timber
import timber.log.Timber.DebugTree

/**
 * This *Application* sets up some app-wide configurations on initial start.
 */
class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            // show log in logcat for debug builds
            Timber.plant(DebugTree())

            // log ThirtyInch messages to timber
            TiLog.setLogger { level, tag, msg -> Timber.tag(tag).log(level, msg) }
        } else {
            Timber.plant(ProductionTree(this))
        }
    }
}