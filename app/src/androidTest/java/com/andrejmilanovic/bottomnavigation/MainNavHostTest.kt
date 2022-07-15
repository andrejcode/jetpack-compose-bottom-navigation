package com.andrejmilanovic.bottomnavigation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainNavHostTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: NavHostController

    @Before
    fun setupMainNavHost() {
        composeTestRule.setContent {
            navController = rememberNavController()
            MainNavHost(navController = navController)
        }
    }

    @Test
    fun mainNavHost() {
        composeTestRule.onNodeWithContentDescription("Home Screen").assertIsDisplayed()
    }
}