package com.andrejmilanovic.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andrejmilanovic.bottomnavigation.navigation.NavItem
import com.andrejmilanovic.bottomnavigation.navigation.Screen
import com.andrejmilanovic.bottomnavigation.ui.favorite.FavoriteScreen
import com.andrejmilanovic.bottomnavigation.ui.home.HomeScreen
import com.andrejmilanovic.bottomnavigation.ui.random.RandomScreen
import com.andrejmilanovic.bottomnavigation.ui.search.SearchScreen
import com.andrejmilanovic.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    BottomNavigationTheme {
        val navItems = listOf(NavItem.Home, NavItem.Favorite, NavItem.Search, NavItem.Random)
        val navController = rememberNavController()
        val backstackEntry by navController.currentBackStackEntryAsState()
        val currentScreen = backstackEntry?.destination?.route
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = currentScreen.toString()) }) },
            bottomBar = {
                BottomNavigation {
                    navItems.forEach { item ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = stringResource(id = item.title)
                                )
                            },
                            label = { Text(text = stringResource(id = item.title)) },
                            selectedContentColor = Color.White,
                            unselectedContentColor = Color.White.copy(0.4f),
                            selected = currentScreen == item.navRoute,
                            onClick = { navController.navigate(item.navRoute) }
                        )
                    }
                }
            }) {
            MainNavHost(navController = navController)
        }
    }
}

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.name) {
        composable(Screen.Home.name) {
            HomeScreen()
        }
        composable(Screen.Favorite.name) {
            FavoriteScreen()
        }
        composable(Screen.Search.name) {
            SearchScreen()
        }
        composable(Screen.Random.name) {
            RandomScreen()
        }
    }
}
