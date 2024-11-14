package eu.example.myapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import eu.example.myapp.data.Brand
import eu.example.myapp.data.DummyData

@Composable
fun Grid(navController: NavHostController) {
    val skincareList = DummyData.skincareList

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        items(skincareList) { skincareItem ->
            SkincareGridItem(skincareItem)
        }
    }
}

@Composable
fun SkincareGridItem(brand: Brand) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = brand.photoProduct),
            contentDescription = brand.name,
            modifier = Modifier
                .size(120.dp) // Set size untuk image
        )
        Text(
            text = brand.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = "Rp ${brand.price}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}
