package eu.example.MyAapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.example.myapp.R

@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Foto Profil
        Image(
            painter = painterResource(id = R.drawable.ala),
            contentDescription = "Your Photo",
            modifier = Modifier
                .width(300.dp) // Lebar
                .height(300.dp) // Tinggi
        )



        // Card untuk informasi
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Miftahul Fazra",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Divider(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(0.5f)
                )

                Text(
                    text = "Universitas: Politeknik Negeri Batam",
                    fontSize = 17.sp
                )
                Text(
                    text = "Jurusan: Teknik Informatika",
                    fontSize = 17.sp
                )
            }
        }
    }
}
