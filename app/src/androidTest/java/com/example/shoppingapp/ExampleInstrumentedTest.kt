package com.example.shoppingapp

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.util.concurrent.CompletableFuture.anyOf
import java.util.regex.Pattern.matches

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
    fun listGoesOverTheFold() {
        onView(withId(R.id.fragment_container_view)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.toolbar)).check(matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun testFragmentView() {
        Thread.sleep(1000)
        onView(withText("NESCAFE")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
       // onView(withText("Add to Cart")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        //onView(withId(R.id.review_text)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

//    @Test
//    fun testFragmentViewClick() {
//        Thread.sleep(1000)
//        onView(withText(activityRule.)).perform(ViewActions.click())
//    }



}