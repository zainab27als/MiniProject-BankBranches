package com.nbk.miniproject1.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nbk.miniproject1.R
import com.nbk.miniproject1.data.BranchData

@Composable
fun BranchListScreen(
    branches: List<BranchData>,
    favoriteBranchId: Int?,
    onBranchClick: (BranchData) -> Unit
) {
    var sortByName by remember { mutableStateOf(false) }
    var filter247 by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }

    val displayedBranches = remember(branches, sortByName, filter247, searchQuery) {
        var list = branches

        if (filter247) {
            list = list.filter { it.hours.equals("Open 24/7", ignoreCase = true) }
        }

        if (searchQuery.isNotBlank()) {
            list = list.filter {
                it.name.contains(searchQuery, ignoreCase = true) ||
                        it.address.contains(searchQuery, ignoreCase = true)
            }
        }

        if (sortByName) {
            list = list.sortedBy { it.name }
        }

        list
    }

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        BranchSearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { sortByName = !sortByName },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = if (sortByName) "Unsort" else "Sort by Name")
            }
            Button(
                onClick = { filter247 = !filter247 },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = if (filter247) "Show All" else "Filter 24/7")
            }
        }

        LazyColumn(contentPadding = PaddingValues(bottom = 16.dp)) {
            items(displayedBranches) { branch ->
                val isFavorite = branch.id == favoriteBranchId

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable { onBranchClick(branch) },
                    colors = CardDefaults.cardColors(
                        containerColor = if (isFavorite)
                            MaterialTheme.colorScheme.primaryContainer
                        else
                            MaterialTheme.colorScheme.surface
                    )
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(branch.imageURi)
                                .crossfade(true)
                                .fallback(R.drawable.building)
                                .error(R.drawable.building)
                                .build(),
                            contentDescription = null,
                            modifier = Modifier
                                .size(64.dp)
                                .padding(end = 16.dp)
                        )

                        Column {
                            Text(
                                text = branch.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            if (isFavorite) {
                                Text(
                                    text = "🌟 Favorite",
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}