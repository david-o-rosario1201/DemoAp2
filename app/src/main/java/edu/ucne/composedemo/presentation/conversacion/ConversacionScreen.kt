package edu.ucne.composedemo.presentation.conversacion


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.ucne.composedemo.presentation.components.TopBarComponent

@Composable
fun ConversationScreen(
    goToTicket: (Int) -> Unit, // Navegación a detalles del Ticket
    createTicket: () -> Unit, // Crear un nuevo Ticket
    onDrawer: () -> Unit // Acción del ícono del drawer
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            // Aquí integramos el TopBarComponent
            TopBarComponent(
                title = "Tickets", // Título del TopBar
                 onDrawer,

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = createTicket // Acción para crear un nuevo ticket
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Crear un nuevo ticket"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Bloque de mensajes
            MessagesBlock(
                messages = listOf(
                    Message(
                        date = "12/12/2023 8:55:52 PM",
                        sender = "Enel R. Almonte P.",
                        content = "Favor indicar el número del contrato para poder identificar la razón."
                    ),
                    Message(
                        date = "12/13/2023 4:05:51 PM",
                        sender = "COMERCIAL DEL CAMPO",
                        content = "Esto era relacionado con lo contrato..."
                    )
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Bloque para enviar mensajes
            MessageInputBlock(userName = "Enel R. Almonte P.")
        }
    }
}

@Composable
fun MessagesBlock(messages: List<Message>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        messages.forEach { message ->
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text(
                    text = "Fecha: ${message.date}",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Enviado por: ${message.sender}",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Mensaje:",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = message.content,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Divider()
        }
    }
}

@Composable
fun MessageInputBlock(userName: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // Nombre (No editable)
        Text(
            text = "Nombre: $userName",
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Campo para escribir mensaje
        var message by remember { mutableStateOf(TextFieldValue("")) }
        BasicTextField(
            value = message,
            onValueChange = { message = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(8.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para adjuntar archivo y enviar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { /* Lógica para adjuntar archivo */ }) {
                Text("Adjuntar archivo")
            }
            Button(onClick = { /* Lógica para enviar mensaje */ }) {
                Text("Enviar Mensaje")
            }
        }
    }
}

data class Message(val date: String, val sender: String, val content: String)

@Preview(showBackground = true)
@Composable
fun PreviewConversationScreen() {
    ConversationScreen(
        goToTicket = { /* Lógica para navegar a detalles del Ticket */ },
        createTicket = { /* Lógica para crear un nuevo Ticket */ },
        onDrawer = { /* Lógica para el ícono del drawer */ }
    )
}