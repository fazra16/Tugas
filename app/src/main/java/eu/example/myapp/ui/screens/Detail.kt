package eu.example.myapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import eu.example.myapp.data.DummyData

@Composable
fun DetailScreen(navController: NavController, itemId: Int) {
    val brand = DummyData.skincareList.find { it.id == itemId }
    brand?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = it.photoProduct),
                contentDescription = it.name,
                modifier = Modifier.size(200.dp).align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = it.name, style = MaterialTheme.typography.labelMedium)
            Text(text = "Price: ${it.price}", style = MaterialTheme.typography.labelMedium)
        }
    }
}
