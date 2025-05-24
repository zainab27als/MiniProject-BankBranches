package com.nbk.miniproject1.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    LazyColumn {
        items(branches) { branch ->
            val isFavorite = branch.id == favoriteBranchId

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onBranchClick(branch) },
                colors = CardDefaults.cardColors(
                    containerColor = if (isFavorite) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
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