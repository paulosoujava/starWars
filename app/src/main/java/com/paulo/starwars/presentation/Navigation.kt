@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package com.paulo.starwars.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paulo.starwars.presentation.ui.favorite.Favorite
import com.paulo.starwars.presentation.ui.list.ListStarWars
import com.paulo.starwars.presentation.ui.listItem.ListItemStarWars
import com.paulo.starwars.presentation.ui.profile.Profile
import com.paulo.starwars.presentation.ui.theme.StarWarsTheme
import com.paulo.starwars.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Navigation : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            StarWarsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Constants.TIMELINE_PAGE
                    ) {
                        composable(Constants.TIMELINE_PAGE) {
                            ListStarWars(
                                navController = navController,
                            )
                        }
                        composable(
                            route = Constants.ITEM_PAGE
                        ) {
                            ListItemStarWars(navController = navController)
                        }
                        composable(
                            route = Constants.FAVORITE
                        ) {
                            Favorite(navController = navController)
                        }
                        composable(
                            "${Constants.PROFILE_PAGE}/{imageUrl}/{code}"
                        ) { backStackEntry ->
                            val code = backStackEntry.arguments?.getString("code")
                            Profile(
                                navController = navController,
                                backStackEntry.arguments?.getString("imageUrl"),
                                code ?: "invalid",
                            )
                        }
                    }
                }
            }
        }
    }
}




