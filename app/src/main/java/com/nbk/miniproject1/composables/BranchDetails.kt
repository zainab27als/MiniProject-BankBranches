package com.nbk.miniproject1.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.nbk.miniproject1.R
import com.nbk.miniproject1.data.BranchData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BranchDetailsScreen(
    branch: BranchData,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit,
    navController: NavController
) {
    val uriHandler = LocalUriHandler.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Branch Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(branch.imageURi)
                    .crossfade(true)
                    .fallback(R.drawable.building)
                    .error(R.drawable.building)
                    .build(),
                contentDescription = "Branch Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = branch.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Type: ${branch.type}")
            Text(text = "Address: ${branch.address}")
            Text(text = "Phone: ${branch.phone}")
            Text(text = "Hours: ${branch.hours}")

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { uriHandler.openUri(branch.location) }) {
                Text(text = "Open in Google Maps")
            }

            Spacer(modifier = Modifier.height(16.dp))

            FavoriteButton(
                isFavorite = isFavorite,
                onClick = onFavoriteClick
            )
        }
    }
}
