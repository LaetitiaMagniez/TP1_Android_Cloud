package com.example.tp1_master2_ccm.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.tp1_master2_ccm.ui.model.ItemUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
) {
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
        }

    ) { padding ->
        MyScreen(
            modifier = Modifier.padding(padding)
        )
    }

}

private fun populateMyList(): List<ItemUi.MyPokemonObject> {
    return listOf<ItemUi.MyPokemonObject>(
        ItemUi.MyPokemonObject(pokemonName = "Salameche", typeName = "Feu", generation = "1"),
        ItemUi.MyPokemonObject(pokemonName = "Kyogre", typeName = "Eau", generation = "3"),
        ItemUi.MyPokemonObject(pokemonName = "Tortipouss", typeName = "Plante", generation = "4"),
        ItemUi.MyPokemonObject(pokemonName = "Poussifeu", typeName = "Feu", generation = "3"),
        ItemUi.MyPokemonObject(pokemonName = "Gobou", typeName = "Eau", generation = "3"),
        ItemUi.MyPokemonObject(pokemonName = "Arcko", typeName = "Plante", generation = "3"),
        ItemUi.MyPokemonObject(pokemonName = "Dracolosse", typeName = "Dragon", generation = "1"),
        ItemUi.MyPokemonObject(pokemonName = "Rayquaza", typeName = "Dragon", generation = "3"),
        ItemUi.MyPokemonObject(pokemonName = "Leviator", typeName = "Eau", generation = "1"),

        )
}

@Composable
private fun MyScreen(modifier: Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        val listOfResult: MutableList<ItemUi> = mutableListOf()


        populateMyList()
            .groupBy { MyPokemonObject ->
                MyPokemonObject.typeName
            }
            .forEach {
                listOfResult.add(
                    ItemUi.Header(
                        title = it.key,
                    )
                )
                listOfResult.addAll(
                    it.value
                )
                listOfResult.add(
                    ItemUi.Footer(
                        total = it.value.size
                    )
                )
            }

        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(listOfResult) { item ->
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


                    is ItemUi.MyPokemonObject -> Text(
                        text = " ${item.pokemonName}",
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
