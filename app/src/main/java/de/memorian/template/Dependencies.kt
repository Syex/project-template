package de.memorian.template

import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext
import org.koin.standalone.StandAloneContext.startKoin

object Dependencies {

    fun init() {
        startKoin(listOf(coreModule))
    }

    private val coreModule: Module = applicationContext {

    }
}