package de.memorian.template.presentation

import android.app.Activity
import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.inputmethod.InputMethodManager

/**
 * Sets up the [Toolbar] for this *Activity*.
 *
 * @param toolbarId The resource id of the toolbar.
 * @param title An optional string resource to set as the title.
 * @param showHomeAsUp If the home button should be displayed.
 * @param homeIcon An optional drawable resource to use as the home icon.
 *
 * @return The configures [Toolbar].
 */
fun AppCompatActivity.configureToolbar(@IdRes toolbarId: Int,
                                       @StringRes title: Int? = null,
                                       showHomeAsUp: Boolean,
                                       @DrawableRes homeIcon: Int? = null): Toolbar {
    val toolbar = findViewById<Toolbar>(toolbarId)
    setSupportActionBar(toolbar)
    title?.let { supportActionBar?.setTitle(it) }
    supportActionBar?.setDisplayHomeAsUpEnabled(showHomeAsUp)
    homeIcon?.let { supportActionBar?.setHomeAsUpIndicator(it) }
    return toolbar
}

/**
 * Hides the keyboard.
 */
fun Activity.hideKeyboard() {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

/**
 * Hides the keyboard.
 */
fun Fragment.hideKeyboard() {
    val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
}

/**
 * Shows a [Snackbar].
 *
 * @param parentLayout The root layout of your view.
 * @param textRes The resource id of the text that should be shown.
 * @param length One of *Snackbar.LENGTH...*.
 */
fun Activity.snackbar(@IdRes parentLayout: Int = android.R.id.content,
                      @StringRes textRes: Int,
                      length: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(findViewById(parentLayout), textRes, length).show()
}