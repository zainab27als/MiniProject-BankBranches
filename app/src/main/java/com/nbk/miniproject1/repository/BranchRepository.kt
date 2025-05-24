package com.nbk.miniproject1.repository

import com.nbk.miniproject1.data.BranchData
import com.nbk.miniproject1.data.BranchType

object BranchRepository {
    fun getBranches(): List<BranchData> {
        return listOf(
            BranchData(
                id = 1,
                name = "NBK HQ - Kuwait City",
                type = BranchType.MAIN,
                address = "Downtown, Kuwait City",
                phone = "+965 1234 5678",
                hours = "8am - 3pm",
                location = "https://maps.google.com",
                imageURi = "https://www.hilitehomes.com/images/National_Bank_of_Kuwait.jpg"
            ),
                    BranchData(
                    id = 2,
            name = "NBK Service Center - Daiya",
            type = BranchType.SERVICE_CENTER,
            address = "Daiya",
            phone = "+965 7398 4723",
            hours = "Open 24/7",
            location = "https://maps.google.com",
            imageURi = "https://www.mailam-shaalan.com/uploads/projects/1478781180.jpg"
        ),
            BranchData(
                id = 3,
                name = "NBK ATM - Marina",
                type = BranchType.ATM,
                address = "Marina Mall",
                phone = "+965 8765 4321",
                hours = "Open 24/7",
                location = "https://maps.google.com",
                imageURi = "https://www.daleeeel.com/f/res/w06/locations-photos/000/067/0006748-269-rinnoo-e9f4503f78a7441481fc7e0a44156249-r01.jpg"
            )
        )
    }
}
