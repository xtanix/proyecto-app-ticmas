package com.app_comparador_textos

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)

class ExampleInstrumentedTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCompararButton() {
        // Ingresa texto en el primer EditText
        Espresso.onView(ViewMatchers.withId(R.id.TextoA))
            .perform(ViewActions.typeText("Texto 1"), ViewActions.closeSoftKeyboard())

        // Ingresa texto en el segundo EditText
        Espresso.onView(ViewMatchers.withId(R.id.editText))
            .perform(ViewActions.typeText("Texto 2"), ViewActions.closeSoftKeyboard())

        // Haz clic en el botón
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())

        // Verifica el resultado en el TextView
        Espresso.onView(ViewMatchers.withId(R.id.resultadoTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("Los textos son diferentes")))
    }
}