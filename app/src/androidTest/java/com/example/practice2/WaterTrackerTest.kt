package com.example.practice2

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.practice2.ui.theme.Practice2Theme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class WaterTrackerTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testAddWaterButton() {
        composeTestRule.setContent {
            Practice2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WaterTracker()
                }
            }
        }
        val addButton = composeTestRule.onNodeWithText("+250 мл")
        addButton.assertIsDisplayed()
        addButton.performClick()
        composeTestRule.onNodeWithText("350 мл").assertIsDisplayed()
    }

    @Test
    fun testEndDayButton() {
        composeTestRule.setContent {
            Practice2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WaterTracker()
                }
            }
        }
        val endDayButton = composeTestRule.onNodeWithText("Завершить день")
        endDayButton.assertIsDisplayed()
        endDayButton.performClick()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 дней").assertIsDisplayed()
    }

    @Test
    fun testSuccessAndFailDays() {
        composeTestRule.setContent {
            Practice2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WaterTracker()
                }
            }
        }
        val addButton = composeTestRule.onNodeWithText("+250 мл")
        val endDayButton = composeTestRule.onNodeWithText("Завершить день")
        repeat (6){
            addButton.performClick()
        }
        composeTestRule.onNodeWithText("1600 мл").assertIsDisplayed()
        endDayButton.performClick()

        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("1 дней").assertIsDisplayed()

        repeat (6){
            addButton.performClick()
        }
        endDayButton.performClick()
        composeTestRule.onNodeWithText("2 дней").assertIsDisplayed()

        addButton.performClick()
        endDayButton.performClick()
        composeTestRule.onNodeWithText("0 дней").assertIsDisplayed()
    }

}