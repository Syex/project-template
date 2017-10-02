package de.memorian.template.domain.usecase


import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Scheduler
import io.reactivex.Single

/**
 * Abstract base class for a [Single] *Use Case* (Interactor in terms of Clean Architecture).
 *
 * By convention each *Use Case* will do its job in a background thread and
 * will post the result in the UI thread.
 */
abstract class SingleUseCase<T, Params>(
        private val executionScheduler: Scheduler,
        private val postExecutionScheduler: Scheduler
) : BaseUseCase<Single<T>, Params>() {

    override fun execute(params: Params): Single<T> {
        return buildUseCase(params)
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
    }
}

/**
 * Abstract base class for a [Completable] *Use Case* (Interactor in terms of Clean Architecture).
 *
 * By convention each *Use Case* will do its job in a background thread and
 * will post the result in the UI thread.
 */
abstract class CompletableUseCase<Params>(
        private val executionScheduler: Scheduler,
        private val postExecutionScheduler: Scheduler
) : BaseUseCase<Completable, Params>() {

    override fun execute(params: Params): Completable {
        return buildUseCase(params)
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
    }
}

/**
 * Abstract base class for a [Maybe] *Use Case* (Interactor in terms of Clean Architecture).
 *
 * By convention each *Use Case* will do its job in a background thread and
 * will post the result in the UI thread.
 */
abstract class MaybeUseCase<T, Params>(
        private val executionScheduler: Scheduler,
        private val postExecutionScheduler: Scheduler
) : BaseUseCase<Maybe<T>, Params>() {

    override fun execute(params: Params): Maybe<T> {
        return buildUseCase(params)
                .subscribeOn(executionScheduler)
                .observeOn(postExecutionScheduler)
    }
}

abstract class BaseUseCase<ObservableType, Params> {

    /**
     * Executes this use case with the given *params*.
     */
    abstract fun execute(params: Params): ObservableType

    /**
     * Build the basic use case with the given *params*.
     */
    protected abstract fun buildUseCase(params: Params): ObservableType
}
