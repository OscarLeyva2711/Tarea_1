package com.example.tarjetapresentacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

private const val CLAVE_ALUMNOS = "alumnos"

@Composable
fun ListaDeslizablePendientes() {

    val context = LocalContext.current

    val alumnos = remember {
        mutableStateListOf<String>().apply {
            addAll(cargarAlumnos(context))
        }
    }

    var nombre by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp)
    ) {

        Text(
            text = "Lista de alumnos",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = {
                    Text(
                        "Nombre",
                        color = Color.Gray
                    )
                },
                singleLine = true,
                modifier = Modifier.weight(1f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedLabelColor = Color(0xFF1565C0),
                    unfocusedLabelColor = Color.Gray,
                    cursorColor = Color(0xFF1565C0),
                    focusedBorderColor = Color(0xFF1565C0),
                    unfocusedBorderColor = Color.Gray
                )
            )

            Button(
                onClick = {

                    val limpio = nombre.trim()

                    if (limpio.isNotEmpty()) {

                        alumnos.add(limpio)

                        guardarAlumnos(
                            context,
                            alumnos.toList()
                        )

                        nombre = ""
                    }
                },
                enabled = nombre.trim().isNotEmpty()
            ) {
                Text("Agregar alumno")
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        Text(
            text = "Total de alumnos: ${alumnos.size}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        if (alumnos.isEmpty()) {

            Text(
                text = "No hay alumnos registrados",
                style = MaterialTheme.typography.bodyLarge
            )

        } else {

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                itemsIndexed(alumnos) { indice, alumno ->

                    TarjetaPendiente(
                        texto = alumno,
                        onEliminar = {

                            alumnos.removeAt(indice)

                            guardarAlumnos(
                                context,
                                alumnos.toList()
                            )
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun TarjetaPendiente(
    texto: String,
    onEliminar: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = texto,
                modifier = Modifier.weight(1f)
            )

            TextButton(
                onClick = onEliminar
            ) {
                Text("Eliminar")
            }
        }
    }
}



// Implementación de TinyDB


private fun cargarAlumnos(
    context: android.content.Context
): List<String> {

    val tinyDB = TinyDB(context)

    return tinyDB.getListString(
        CLAVE_ALUMNOS
    )
}


private fun guardarAlumnos(
    context: android.content.Context,
    lista: List<String>
) {

    val tinyDB = TinyDB(context)

    tinyDB.putListString(
        CLAVE_ALUMNOS,
        ArrayList(lista)
    )
}
