package com.example.tarjetapresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

class ListaActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TarjetaPresentacionTheme {
                ListaDeslizablePendientes()
            }
        }
    }
}