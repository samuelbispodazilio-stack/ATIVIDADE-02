package com.example.agendapessoal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
data class Compromisso(
    val titulo: String,
    val horario: String,
    val cat: String,
    var concluido: Boolean = false

)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Agenda()
            }
        }
    }
}

@Composable
fun Agenda() {

    var titulo by remember { mutableStateOf("") }
    var horario by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }

    val compromissos = remember {
        mutableStateListOf<Compromisso>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(60.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Agenda",
                modifier = Modifier.size(35.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = "Minha Agenda",
                fontSize = 30.sp,
                color = Color(0xFF18063A)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Cadastre seus compromissos",
            fontSize = 15.sp,
            color = Color(0xFF18063A)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = titulo,
            onValueChange = {
                titulo = it
            },
            label = {
                Text("Compromisso")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = horario,
            onValueChange = {
                horario = it
            },
            label = {
                Text("Data e horário")
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = horario,
            onValueChange = {
                horario = it
            },
            label = {
                Text("Data e horário")
            },
            modifier = Modifier.fillMaxWidth()
        )


        OutlinedTextField(
            value = categoria,
            onValueChange = {
                categoria = it
            },
            label = {
                Text("Categoria")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {

                if (titulo.isNotBlank() && horario.isNotBlank() && categoria.isNotBlank()) {

                    compromissos.add(
                        Compromisso(
                            titulo = titulo,
                            horario = horario,
                            cat = categoria
                        )
                    )

                    titulo = ""
                    horario = ""
                    categoria = ""
                }

            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Adicionar")
        }


    }
}