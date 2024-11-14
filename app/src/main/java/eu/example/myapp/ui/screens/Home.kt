package eu.example.myapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eu.example.myapp.data.Brand
import eu.example.myapp.data.DummyData

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        // LazyRow yang bisa di-scroll
        Text(text = "Top Picks (Scrollable LazyRow)", style = MaterialTheme.typography.headlineMedium)
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp) // Mengatur tinggi untuk LazyRow
                .padding(vertical = 8.dp)
        ) {
            items(DummyData.skincareList) { brand ->
                ProductItemHorizontal(brand) { navController.navigate("detail/${brand.id}") }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn untuk daftar produk
        Text(text = "Products (Lazy Column)", style = MaterialTheme.typography.headlineMedium)
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp)
        ) {
            items(DummyData.skincareList) { brand ->
                ProductItem(brand) { navController.navigate("detail/${brand.id}") }
            }
        }
    }
}

@Composable
fun ProductItem(brand: Brand, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = brand.photoProduct),
            contentDescription = brand.name,
            modifier = Modifier
                .size(80.dp)
                .padding(end = 8.dp)
        )
        Column {
            Text(text = brand.name, style = MaterialTheme.typography.labelMedium)
            Text(text = "Price: ${brand.price}", style = MaterialTheme.typography.labelMedium)
        }
    }
}

@Composable
fun ProductItemHorizontal(brand: Brand, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
            .width(120.dp)
    ) {
        Image(
            painter = painterResource(id = brand.photoProduct),
            contentDescription = brand.name,
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 8.dp)
        )
        Text(text = brand.name, style = MaterialTheme.typography.labelMedium)
        Text(text = "Price: ${brand.price}", style = MaterialTheme.typography.labelMedium)
    }
}
