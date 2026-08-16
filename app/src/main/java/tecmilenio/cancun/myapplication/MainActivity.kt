package tecmilenio.cancun.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.text.KeyboardOptions

import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.clickable
import androidx.compose.foundation.selection.selectable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

import tecmilenio.cancun.myapplication.ui.theme.MyApplicationTheme


// ---------------------------------------------------------
// MAIN ACTIVITY
// ---------------------------------------------------------

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Permite utilizar toda la pantalla
        enableEdgeToEdge()

        // Aquí comienza nuestra interfaz con Jetpack Compose
        setContent {

            // Aplicamos el tema del proyecto
            MyApplicationTheme {
                //Variable que indica que pantalla mostrar
                var pantalla by remember{
                    mutableStateOf("login")
                }

                if(pantalla == "login") {
                    PantallaLogin(
                        irARegistro = {
                            pantalla = "registro"
                        }
                    )
                } else {
                    PantallaRegistro(
                        irALogin = {
                            pantalla = "login"
                        }
                    )
                }


                // Si queremos probar directamente el Home,
                // podemos comentar PantallaLogin()
                // y utilizar:
                //
                // PantallaHome()
            }
        }
    }
}


// ---------------------------------------------------------
// PANTALLA LOGIN
// ---------------------------------------------------------

@Composable
fun PantallaLogin(
    irARegistro: () -> Unit
) {

    // Variable que guarda lo escrito en Usuario
    var username by remember {
        mutableStateOf("")
    }

    // Variable que guarda lo escrito en Contraseña
    var password by remember {
        mutableStateOf("")
    }


    // Box ocupa toda la pantalla
    // y centra el contenido
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // Column organiza los elementos
        // verticalmente
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),

            // Centramos los elementos horizontalmente
            horizontalAlignment = Alignment.CenterHorizontally,

            // Dejamos 16dp de separación
            // entre cada elemento
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {


            // -------------------------------------------------
            // LOGO
            // -------------------------------------------------

            Image(

                // Busca logo.png dentro de drawable
                painter = painterResource(
                    id = R.drawable.logo
                ),

                // Descripción para accesibilidad
                contentDescription = "Logo de la aplicación",

                // Tamaño de la imagen
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),

                // Ajusta la imagen sin recortarla
                contentScale = ContentScale.Fit
            )


            // -------------------------------------------------
            // INPUT USUARIO
            // -------------------------------------------------

            OutlinedTextField(

                // value contiene el texto actual
                value = username,

                // onValueChange se ejecuta
                // cada vez que escribimos algo
                onValueChange = { nuevoTexto ->

                    // Guardamos el nuevo texto
                    // en la variable username
                    username = nuevoTexto
                },

                // Etiqueta del campo
                label = {
                    Text("Usuario")
                },

                // Ocupa todo el ancho
                modifier = Modifier.fillMaxWidth(),

                // Solo permite una línea
                singleLine = true
            )


            // -------------------------------------------------
            // INPUT CONTRASEÑA
            // -------------------------------------------------

            OutlinedTextField(

                // value contiene la contraseña
                value = password,

                // Se ejecuta cada vez que
                // cambia el texto
                onValueChange = { nuevoTexto ->

                    // Guardamos lo escrito
                    password = nuevoTexto
                },

                // Etiqueta del campo
                label = {
                    Text("Contraseña")
                },

                // Ocupa todo el ancho disponible
                modifier = Modifier.fillMaxWidth(),

                // Solo permite una línea
                singleLine = true,

                // Oculta la contraseña con puntos
                visualTransformation =
                    PasswordVisualTransformation(),

                // Muestra un teclado apropiado
                // para contraseñas
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )


            // -------------------------------------------------
            // BOTÓN
            // -------------------------------------------------

            Button(

                // Por ahora no tiene lógica.
                // Después agregaremos aquí
                // la validación y navegación.
                onClick = {

                },

                // Ocupa todo el ancho
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Iniciar sesión")
            }

            Text(
                text = "¿No tienes una cuenta? Regístrate ahora",

                modifier = Modifier.clickable {
                    irARegistro()
                }
            )
        }
    }
}

// ---------------------------------------------------------
// PANTALLA REGISTRO
// ---------------------------------------------------------

@Composable
fun PantallaRegistro(
    irALogin: () -> Unit
) {

    var nombreCompleto by remember {
        mutableStateOf("")
    }

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            //LOGO

            Image(
                painter = painterResource(
                    id = R.drawable.logo
                ),

                contentDescription = "Logo de la aplicacion",

                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),

                contentScale = ContentScale.Fit
            )

            //NOMBRE COMPLETO

            OutlinedTextField(

                value = nombreCompleto,

                onValueChange = { nuevoTexto ->
                    nombreCompleto = nuevoTexto
                },

                label = {
                    Text("Nombre Completo")
                },

                modifier = Modifier.fillMaxWidth(),

                singleLine = true
            )

            //NOMBRE DE USUARIO

            OutlinedTextField(
                value = username,

                onValueChange = { nuevoTexto ->
                    username = nuevoTexto
                },

                label = {
                    Text("Nombre de usuario")
                },

                modifier = Modifier.fillMaxWidth(),

                singleLine = true
            )

            //CONTRASEÑA

            OutlinedTextField(

                value = password,

                onValueChange = { nuevoTexto ->
                    password = nuevoTexto
                },

                label = {
                    Text("Contraseña")
                },

                modifier = Modifier.fillMaxWidth(),

                singleLine = true,

                visualTransformation =
                    PasswordVisualTransformation(),

                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )
            )

            //BOTON REGISTRARSE

            Button(
                onClick = {
                },
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Registrarse")
            }

            //REGRESAR AL LOGIN

            Text(
                text = "¿Ya tienes cuenta? Inicia Sesión",
                modifier = Modifier.clickable {
                    irALogin()
                }

            )
        }
    }
}

// ---------------------------------------------------------
// PANTALLA HOME
// ---------------------------------------------------------

// Necesitamos esta anotación porque
// TopAppBar utiliza una API experimental de Material 3
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun PantallaHome() {

    // Scaffold permite organizar una pantalla
    // con barra superior y contenido
    Scaffold(

        // -------------------------------------------------
        // APP BAR
        // -------------------------------------------------

        topBar = {

            CenterAlignedTopAppBar(

                // Título que aparece en la barra
                title = {
                    Text("Inicio")
                },


                // Botones que aparecen
                // del lado derecho del AppBar
                actions = {

                    IconButton(

                        // Por ahora este botón no hace nada
                        onClick = {

                        }
                    ) {

                        // Icono de cerrar sesión
                        Icon(

                            painter = painterResource(
                                id = android.R.drawable.ic_lock_power_off
                            ),

                            contentDescription = "Cerrar sesión"
                        )
                    }
                },


                // Colores de la barra superior
                colors = TopAppBarDefaults.topAppBarColors(

                    // Fondo del AppBar
                    containerColor =
                        MaterialTheme.colorScheme.primary,

                    // Color del título
                    titleContentColor =
                        MaterialTheme.colorScheme.onPrimary,

                    // Color del icono
                    actionIconContentColor =
                        MaterialTheme.colorScheme.onPrimary
                )
            )
        }

    ) { espacioInterior ->


        // -------------------------------------------------
        // CONTENIDO DEL HOME
        // -------------------------------------------------

        Box(

            modifier = Modifier
                .fillMaxSize()

                // Evita que el contenido quede
                // debajo del AppBar
                .padding(espacioInterior),

            // Centramos el contenido
            contentAlignment = Alignment.Center
        ) {

            // Mensaje principal
            Text(

                text = "¡Bienvenido a la pantalla Home!",

                // Utilizamos un estilo
                // definido por MaterialTheme
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}