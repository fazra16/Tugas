
package eu.example.myapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import eu.example.myapp.R

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf("list", "grid", "about")
    val currentRoute = navController.currentBackStackEntryAsState()?.value?.destination?.route

    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentRoute == screen,
                onClick = { navController.navigate(screen) },
                icon = {
                    when (screen) {
                        "list" -> Icon(Icons.Filled.List, contentDescription = "List")
                        "grid" -> Icon(Icons.Filled.Menu, contentDescription = "Grid")
                        "about" -> Icon(Icons.Filled.Info, contentDescription = "About")
                    }
                },
                label = {
                    Text(
                        text = when (screen) {
                            "list" -> "List"
                            "grid" -> "Grid"
                            "about" -> "About"
                            else -> ""
                        }
                    )
                }
            )
        }
    }
}
