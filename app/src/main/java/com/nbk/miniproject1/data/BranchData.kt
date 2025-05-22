package com.nbk.miniproject1.data

enum class BranchType {
    MAIN, ATM, SERVICE_CENTER, FEMALES, MALES
}

data class BranchData(
    var id: Int = 0 ,
    var name: String = "",
    var type: BranchType = BranchType.MAIN,
    var address: String = "",
    var phone: String = "",
    var hours: String = "",
    var location: String = "",
    var imageURi: String = ""
    )