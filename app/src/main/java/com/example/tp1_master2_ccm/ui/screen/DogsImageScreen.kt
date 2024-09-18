package com.example.tp1_master2_ccm.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.tp1_master2_ccm.ui.model.DogsObject
import com.example.tp1_master2_ccm.ui.viewmodel.DogsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DogsImageScreen(navController: NavController,) {
    val viewModel: DogsViewModel = viewModel()
    val dogList = viewModel.image.collectAsState(emptyList()).value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dogs Images") },
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
                        viewModel.insertNewImage()
                    }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = {
                        Text("Delete")
                    },
                    onClick = {
                        viewModel.deleteAllImages()
                    }
                )
            }
        })

    { padding ->
        DogsScreen(
            modifier = Modifier.padding(padding),
            list = dogList
        )
    }

}


@Composable
private fun DogsScreen(modifier: Modifier, list : List<DogsObject>) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(list) { item ->
                val painter = rememberAsyncImagePainter(
                    ImageRequest
                        .Builder(LocalContext.current)
                        .data(data = item.imageUrl)
                        .build()
                )
                Image(
                    modifier = Modifier.size(128.dp),
                    painter = painter,
                    contentDescription = null,
                )

            }
        }
    }
}