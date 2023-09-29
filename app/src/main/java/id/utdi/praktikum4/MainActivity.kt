package id.utdi.praktikum4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.utdi.praktikum4.ui.theme.Praktikum4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Praktikum4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Memanggil komponen ImageConversation
                    ImageConversation()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) //Tanda anotasi menggunakan ekperimental dari Material3 dalam komponen
@Composable
fun ImageConversation() {
    Column(
        modifier = Modifier // Mengisi ruang maksimum yang tersedia dalam parent
            .fillMaxSize() // Memberikan padding sebesar 16dp pada semua sisi
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // Spasi antara komponen
    ) {
        // TopAppBar dengan teks "Bukan WhatsApp"
        TopAppBar(
            title = {
                Text(
                    text = "Bukan WhatsApp",
                    color = Color.White, // Teks "Bukan WhatsApp" berwarna putih
                    fontWeight = FontWeight.Bold, // Teks memiliki ketebalan huruf tebal (bold)
                    textAlign = TextAlign.Center, // Teks diatur agar terpusat (centered) secara horizontal
                    modifier = Modifier
                        .fillMaxWidth() // Mengisi lebar maksimum yang tersedia
                        .background(MaterialTheme.colorScheme.primary) // Warna latar belakang ungu
                        .padding(top = 16.dp, bottom = 16.dp) // Memberikan padding pada bagian atas dan bawah teks sebesar 16dp
                )
            },
            modifier = Modifier
                .fillMaxWidth() // Mengisi lebar maksimum
        )

        // Memanggil komponen ConversationItem dengan data yang berbeda
        ConversationItem(
            text = "Assalamualaikum sep, gimana kabar?.",
            imageResId = R.drawable.pp1,
            isMe = false
        )
        ConversationItem(
            text = "Baik Bang",
            imageResId = R.drawable.pp2,
            isMe = true
        )
        ConversationItem(
            text = "Main sini lah Tangerang, Kaga bosen apa di Jogja mulu hahhah",
            imageResId = R.drawable.pp1,
            isMe = false
        )
        ConversationItem(
            text = "Bosen si hahha",
            imageResId = R.drawable.pp2,
            isMe = true
        )
        ConversationItem(
            text = "Besok lah akhir tahun mampir situ kalo sempet",
            imageResId = R.drawable.pp2,
            isMe = true
        )
        ConversationItem(
            text = "Siall, masih lama akhir taon mahh",
            imageResId = R.drawable.pp1,
            isMe = false
        )
    }
}

@Composable
fun ConversationItem(text: String, imageResId: Int, isMe: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth() // Mengisi lebar maksimum
            .padding(horizontal = 16.dp, vertical = 8.dp), // Padding horizontal dan vertikal
        verticalAlignment = Alignment.CenterVertically // Penyusunan vertikal ke tengah
    ) {
        if (!isMe) {
            Card(
                modifier = Modifier
                    .size(50.dp) // Ukuran Card
                    .clip(CircleShape), // Bentuk Card menjadi lingkaran
            ) {
                Image(
                    painter = painterResource(id = imageResId), // Menampilkan gambar dengan ID yang diberikan
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize() // Mengisi ukuran maksimum
                        .clip(MaterialTheme.shapes.small) // Bentuk gambar dengan sudut yang melengkung
                        .background(MaterialTheme.colorScheme.primary) // Latar belakang ungu
                        .padding(4.dp), // Padding
                    contentScale = ContentScale.Crop // Mengubah ukuran gambar untuk memenuhi kotak gambar
                )
            }

            Spacer(modifier = Modifier.width(16.dp)) // Spasi horizontal
        }

        Text(
            text = text, // Menampilkan teks yang diberikan
            style = MaterialTheme.typography.bodyLarge, // Menggunakan gaya teks dari tema Material
            modifier = Modifier
                .weight(1f) // Mengisi ruang yang tersedia secara merata
                .padding(end = if (isMe) 16.dp else 0.dp), // Padding hanya jika isMe adalah true
            textAlign = if (isMe) TextAlign.End else TextAlign.Start, // Penyusunan teks ke kanan jika isMe adalah true
        )

        if (isMe) {
            Card(
                modifier = Modifier
                    .size(50.dp) // Ukuran Card
                    .clip(CircleShape), // Bentuk Card menjadi lingkaran
            ) {
                Image(
                    painter = painterResource(id = imageResId), // Menampilkan gambar dengan ID yang diberikan
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize() // Mengisi ukuran maksimum
                        .clip(MaterialTheme.shapes.small) // Bentuk gambar dengan sudut yang melengkung
                        .background(MaterialTheme.colorScheme.primary) // Latar belakang ungu
                        .padding(4.dp), // Padding
                    contentScale = ContentScale.Crop // Mengubah ukuran gambar untuk memenuhi kotak gambar
                )
            }
        }
    }
}

@Preview(showBackground = true) // Menambahkan anotasi @Preview untuk tampilan pratinjau komponen
@Composable
fun ImageConversationPreview() {
    Praktikum4Theme { // Menerapkan tema Praktikum4Theme untuk tampilan pratinjau
        ImageConversation() // Memanggil fungsi ImageConversation() untuk ditampilkan dalam pratinjau
    }
}
