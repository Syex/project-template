package de.memorian.template

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val kodein = Kodein {
    import(coreModule())
}

private fun coreModule() = Kodein.Module {
}