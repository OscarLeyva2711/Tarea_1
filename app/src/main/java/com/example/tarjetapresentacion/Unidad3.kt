package com.example.tarjetapresentacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme
import androidx.compose.ui.graphics.Color
@Composable
fun ListaDeslizablePendientes(){
    val items = remember { mutableStateListOf(
        "Felix Arredondo",
        "Artemio Villalobos",
        "Yael Limon",
        "Oscar Leyva",
        "Gael Lopez",
        "Diego Bejarano",
        "Kitzia Garcia",
        "Jesus Perez",
        "Cesar Benitez",
        "Adad Arias",
        "Paula Meza"
    )  }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement =
            Arrangement.spacedBy(16.dp,
                Alignment.CenterVertically)
    ) {
        items(items){ nombre ->
            TarjetaPendiente(nombre, {items.remove(nombre)})
        }
    }

}

@Composable
fun TarjetaPendiente(
    texto: String,
    onEliminar: () -> Unit,
    modifier: Modifier = Modifier
){
    Card(modifier = modifier.fillMaxWidth()) {
        Row(modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(
                text = texto,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = onEliminar){
                Text("Eliminar")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ListaDeslizablePendientesPreview() {
    TarjetaPresentacionTheme {
        ListaDeslizablePendientes()
    }
}