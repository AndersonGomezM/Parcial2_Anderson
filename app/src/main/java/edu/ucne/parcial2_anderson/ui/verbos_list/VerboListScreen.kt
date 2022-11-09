package edu.ucne.parcial2_anderson.ui.verbos_list

import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import edu.ucne.parcial2_anderson.data.remote.dto.VerboDto

@Composable
fun VerbosListScreen(
    viewModel: VerboListViewModel = hiltViewModel()
) {
    Scaffold (
        topBar = {
            Text(text = "Lista de verbos", style = MaterialTheme.typography.h3)
        },
        backgroundColor = MaterialTheme.colors.background
    ){
        val uiState by viewModel.uiState.collectAsState()

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            VerboList(
                verbos = uiState.verbo,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Composable
fun VerboList(
    verbos: List<VerboDto>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(verbos) { verbo ->
            VerboRow(verbo)
        }
    }
}

@Composable
fun VerboRow(verbos: VerboDto) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        elevation = 16.dp,
        backgroundColor = Color(0x85223238)
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.padding(4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Nivel: ${verbos.Nivel}"
                )
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = "Categoria: ${verbos.Categoria}"
                )
            }
            Row() {
                Spacer(modifier = Modifier.width(15.dp))
                Text(
                    text = verbos.Verbo,
                    style = MaterialTheme.typography.h6
                )
            }
            Row() {
                AsyncImage(
                    model = verbos.Imagen,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().padding(15.dp)
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}