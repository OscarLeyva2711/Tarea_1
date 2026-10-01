package com.example.tarjetapresentacion

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacion.R
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme
import android.content.Intent

import androidx.compose.ui.platform.LocalContext


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TarjetaPresentacionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CartaPresentacionScreen()
                }
            }
        }
    }
}


@Composable
fun CartaPresentacionScreen() {
val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Image(
            painter = painterResource(R.drawable._26_year_old_latin_man_260nw_2597722771),
            contentDescription = "Foto de perfil",
            modifier = Modifier.size(180.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))



        Text(
            text = "Oscar Leyva",
            fontSize = 42.sp,
            textAlign = TextAlign.Center
        )


        Text(
            text = "Estudiante",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(120.dp))



        Contacto(
            imagen = R.drawable.telefono,
            texto = "+52 686 2647 918"
        )

        Spacer(modifier = Modifier.height(18.dp))



        Contacto(
            imagen = R.drawable.red_social,
            texto = "@Oscar.leyva"
        )

        Spacer(modifier = Modifier.height(18.dp))



        Contacto(
            imagen = R.drawable.correo,
            texto = "oscar.leyva@uabc.edu.mx"
        )

        Button(onClick = {
            val intent = Intent(context, ListaActivity::class.java)
            context.startActivity(intent)
        }
        ){
            Text("Ver Lista")
        }
    }
}


@Composable
fun Contacto(
    imagen: Int,
    texto: String
) {

    Row(
        modifier = Modifier.width(250.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(imagen),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = texto,
            fontSize = 18.sp
        )


    }
}

@Preview(showBackground = true)
@Composable
fun CartaPresentacionPreview() {
    TarjetaPresentacionTheme {
        CartaPresentacionScreen()
    }
}