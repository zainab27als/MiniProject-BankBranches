package com.nbk.miniproject1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nbk.miniproject1.composables.BranchDetailsScreen
import com.nbk.miniproject1.composables.BranchListScreen
import com.nbk.miniproject1.repository.BranchRepository
import com.nbk.miniproject1.ui.theme.MiniProject1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiniProject1Theme {
                val navController = rememberNavController()
                val branches = BranchRepository.getBranches()
                val favoriteBranchId = remember { mutableStateOf<Int?>(null) }

                NavHost(navController = navController, startDestination = "branch_list") {

                    composable("branch_list") {
                        BranchListScreen(
                            branches = branches,
                            favoriteBranchId = favoriteBranchId.value,
                            onBranchClick = { selectedBranch ->
                                navController.navigate("branch_details/${selectedBranch.id}")
                            }
                        )
                    }

                    composable(
                        "branch_details/{branchId}",
                        arguments = listOf(navArgument("branchId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val branchId = backStackEntry.arguments?.getInt("branchId")
                        val branch = branches.find { it.id == branchId }
                        if (branch != null) {
                            BranchDetailsScreen(
                                branch = branch,
                                isFavorite = branch.id == favoriteBranchId.value,
                                onFavoriteClick = { favoriteBranchId.value = branch.id },
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}