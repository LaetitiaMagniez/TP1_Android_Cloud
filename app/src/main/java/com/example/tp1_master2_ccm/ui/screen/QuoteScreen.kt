package com.example.tp1_master2_ccm.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tp1_master2_ccm.ui.viewmodel.ChuckNorrisViewModel

@Composable
fun QuoteScreen() {
    val viewModel: ChuckNorrisViewModel = viewModel()
    val list = viewModel.quote.collectAsState(emptyList()).value


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
        item {
            Button(
                content = { Text("Add") },
                onClick = { viewModel.insertNewQuote() }
            )
            Button(
                content = { Text("Delete") },
                onClick = { viewModel.deleteAllQuote() }
            )
        }
    }
}
