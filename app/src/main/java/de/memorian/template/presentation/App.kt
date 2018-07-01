package de.memorian.template.presentation

import android.app.Application
import com.crashlytics.android.Crashlytics
import de.memorian.template.BuildConfig
import de.memorian.template.domain.logging.ProductionTree
import io.fabric.sdk.android.Fabric

class App : Application() {

    companion object {

        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        App.instance = this

        setupTimber()
        Fabric.with(this, Crashlytics())
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