package com.example.tp1_master2_ccm.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.tp1_master2_ccm.ui.model.ItemUi
import com.example.tp1_master2_ccm.ui.viewmodel.MyPokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
) {

    val viewModel: MyPokemonViewModel = viewModel()
    val pokemonList = viewModel.myPokemonList.collectAsState(emptyList()).value
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Liste de mes Pokemons") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
                bottomBar = {
                    Row {
                        Button(
                            modifier = Modifier.weight(1f),
                            content = {
                                Text("Add")
                            },
                            onClick = {
                                viewModel.insertMyPokemon()
                            }
                        )
                        Button(
                            modifier = Modifier.weight(1f),
                            content = {
                                Text("Delete")
                            },
                            onClick = {
                                viewModel.deleteAllMyPokemon()
                            }
                        )
                    }
                })

             { padding ->
        MyScreen(
            modifier = Modifier.padding(padding),
            items = pokemonList
        )
    }

}



@Composable
private fun MyScreen(modifier: Modifier, items : List<ItemUi>) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(items) { item ->
                when (item) {
                    is ItemUi.Header ->
                        OutlinedCard(
                            modifier = Modifier.fillParentMaxWidth(),
                            colors = CardDefaults.cardColors()
                                .copy(containerColor = Color(0xff33ffc1))
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    text = item.title,
                                    style = MaterialTheme.typography.displaySmall,
                                    color = Color.Gray
                                )
                            }
                        }


                    is ItemUi.Item -> Text(
                        text = " ${item.pokemonName} Génération : ${item.generation}",
                        style = MaterialTheme.typography.bodyMedium,
                    )

                    is ItemUi.Footer ->
                        OutlinedCard(
                            modifier = Modifier.fillParentMaxWidth(),
                            colors = CardDefaults.cardColors()
                                .copy(containerColor = Color(0xFF334EFF))
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    text = "nombre de Pokemon : ${item.total}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.White
                                )
                            }
                        }
                }
            }
            item {
                MyImage()
            }
        }

    }
}

@Composable
fun MyImage() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val painter = rememberAsyncImagePainter(
            ImageRequest
                .Builder(LocalContext.current)
                .data(data = "https://e7.pngegg.com/pngimages/190/701/png-clipart-poke-ball-pokemon-pikachu-video-games-pokedex-pokeball-game-sports-equipment.png")
                .build()
        )
        Image(
            modifier = Modifier.size(128.dp),
            painter = painter,
            contentDescription = null,
        )
    }
}
