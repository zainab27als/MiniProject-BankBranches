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
            ),
            BranchData(
                id = 4,
                name = "NBK Branch - Salmiya",
                type = BranchType.MAIN,
                address = "Salmiya, Block 10",
                phone = "+965 5678 1122",
                hours = "8am - 3pm",
                location = "https://maps.google.com",
                imageURi = "https://www.arabtimesonline.com/uploads/imported_images/2020/03/salmiya-1.jpg"
            ),
            BranchData(
                id = 5,
                name = "NBK ATM - The Avenues",
                type = BranchType.ATM,
                address = "The Avenues Mall",
                phone = "+965 2222 3344",
                hours = "Open 24/7",
                location = "https://maps.google.com",
                imageURi = "https://www.the-avenues.com/storage/about-sections/districts-photos-14-1521755508.jpg"
            ),
            BranchData(
                id = 6,
                name = "NBK Service Center - Shuwaikh",
                type = BranchType.SERVICE_CENTER,
                address = "Shuwaikh Industrial Area",
                phone = "+965 8877 6655",
                hours = "8am - 8pm",
                location = "https://maps.google.com",
                imageURi = "https://www.arabtimesonline.com/uploads/imported_images/2024/05/shuwaikh.jpg"
            ),
            BranchData(
                id = 7,
                name = "NBK ATM - Kuwait Airport",
                type = BranchType.ATM,
                address = "Kuwait International Airport",
                phone = "+965 4455 7788",
                hours = "Open 24/7",
                location = "https://maps.google.com",
                imageURi = "https://www.airport-technology.com/wp-content/uploads/sites/14/2017/10/1l-image-119.jpg"
            ),
            BranchData(
                id = 8,
                name = "NBK Branch - Fahaheel",
                type = BranchType.MAIN,
                address = "Fahaheel, Al-Dabbous Street",
                phone = "+965 3344 5566",
                hours = "8am - 3pm",
                location = "https://maps.google.com",
                imageURi = "https://www.gckuwait.com/wp-content/uploads/2016/12/gulf-consult-Fahaheel-Water-Front-1.jpg"
            ),
            BranchData(
                id = 9,
                name = "NBK Service Center - Jahra",
                type = BranchType.SERVICE_CENTER,
                address = "Jahra City",
                phone = "+965 9988 1122",
                hours = "8am - 8pm",
                location = "https://maps.google.com",
                imageURi = "https://travelsetu.com/apps/uploads/new_destinations_photos/destination/2024/07/01/6f2a32bbc5f571bdba80e45969a36443_1000x1000.jpg"
            ),
            BranchData(
                id = 10,
                name = "NBK ATM - 360 Mall",
                type = BranchType.ATM,
                address = "360 Mall, Zahra",
                phone = "+965 1122 3344",
                hours = "Open 24/7",
                location = "https://maps.google.com",
                imageURi = "https://cdn.prod.website-files.com/5c7a306cee88075d06b7ccfd/5c7a306cee88070739b7ce6f_360-MALL-G-1.jpg"
            )
        )
    }
}
