package com.nbk.miniproject1.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import com.nbk.miniproject1.data.BranchType


@Composable
fun BranchCard(branch: BranchData) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

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
                    .height(180.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = branch.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Type: ${branch.type}")
            Text(text = "Address: ${branch.address}")
            Text(text = "Phone: ${branch.phone}")
            Text(text = "Hours: ${branch.hours}")
            Text(text = "Location: ${branch.location}")
        }
    }
}


//Branch Dummy data

val sampleBranch = BranchData(
    id = 1,
    name = "Kuwait City Branch",
    type = BranchType.MAIN,
    address = "Downtown, Kuwait City",
    phone = "+965 1234 5678",
    hours = "8am - 3pm",
    location = "https://maps.google.com",
    imageURi = "https://images.skyscrapercenter.com/building/nbk_rendering-full_(c)foster.jpg"
)
