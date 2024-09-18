package com.example.tp1_master2_ccm.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tp1_master2_ccm.ui.model.ChuckNorrisObject
import com.example.tp1_master2_ccm.ui.viewmodel.ChuckNorrisViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuoteScreen(navController: NavController,) {
    val viewModel: ChuckNorrisViewModel = viewModel()
    val list = viewModel.quote.collectAsState(emptyList()).value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chuck Norris Quote") },
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
                    content = { Text("Add") },
                    onClick = { viewModel.insertNewQuote() }
                )
                Button(
                    modifier = Modifier.weight(1f),
                    content = { Text("Delete") },
                    onClick = {
                        viewModel.deleteAllQuote()
                    })
            }
        })
    { padding ->
        ChuckQuoteScreen(
            modifier = Modifier.padding(padding),
            list = list
        )
    }
}


@Composable
private fun ChuckQuoteScreen(modifier: Modifier, list : List<ChuckNorrisObject>){
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ){
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(list) { item ->
                OutlinedCard(
                    modifier = Modifier.fillParentMaxWidth(),
                    colors = CardDefaults.cardColors()
                        .copy(containerColor = Color(0xff33ffc1))
                ) {
                    Column(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text =  "Quote = ${item.quote}",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

