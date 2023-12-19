package com.example.worldcinema_poryadin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileScreenTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(ProfileScreen::class.java)

    @Test
    fun testNavigationToMainScreen() {

        onView(withId(R.id.mainbut)).perform(click())


        onView(withId(R.id.mainscr)).check(matches(withText("Main Screen")))
    }

    @Test
    fun testNavigationToCollectionsScreen() {

        onView(withId(R.id.collbut)).perform(click())


        onView(withId(R.id.collscreen)).check(matches(withText("Collections Screen")))
    }

    @Test
    fun testNavigationToChatListScreen() {

        onView(withId(R.id.listbut)).perform(click())

        onView(withId(R.id.chatlist)).check(matches(withText("Chat List Screen")))
    }

}
