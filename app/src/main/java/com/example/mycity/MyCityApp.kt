package com.example.mycity

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.Category
/*import com.example.mycity.ui.ExpandedStartScreen*/
import com.example.mycity.ui.MyCityUiState
import com.example.mycity.ui.MyCityViewModel
import com.example.mycity.ui.PickCategoryScreen
import com.example.mycity.ui.PickPlaceScreen
import com.example.mycity.ui.PlaceScreen
/*import com.example.mycity.ui.StartScreen*/
import com.example.mycity.ui.theme.MyCityTheme
import com.example.mycity.utils.WindowStateContentType


enum class MyCityScreen {
     CategoryList, PlacesList, Place

}

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    navController: NavHostController = rememberNavController(),
    viewModel: MyCityViewModel = viewModel()
) {
    val contentType = when (windowSize) {
        WindowWidthSizeClass.Expanded -> WindowStateContentType.ListDetail
        else -> WindowStateContentType.ListOnly
    }
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.CategoryList.name
    )
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(topBar = {
        MyCityAppBar(
            title = determineTopBarTitle(currentScreen.name, uiState),
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() },
        )
    },) { innerPadding ->


        NavHost(navController = navController, startDestination = MyCityScreen.CategoryList.name) {

            composable(
                route = MyCityScreen.CategoryList.name
            ) {
                PickCategoryScreen(
                    viewModel = viewModel,
                    navigateFunction = { navController.navigate(MyCityScreen.PlacesList.name) },
                    uiState = uiState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
            composable(
                route = MyCityScreen.PlacesList.name
            ) {
                PickPlaceScreen(
                    navigateFunction = { navController.navigate(MyCityScreen.Place.name) },
                    viewModel = viewModel,
                    uiState = uiState,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )

            }
            composable(
                route = MyCityScreen.Place.name
            ) {
                PlaceScreen(
                    uiState = uiState, modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
        }
    }
}

private fun shouldButtonsAppear(
    currentScreen: MyCityScreen,
    contentType: WindowStateContentType
) =
    currentScreen.name != MyCityScreen.CategoryList.name && contentType != WindowStateContentType.ListDetail

private fun determineTopBarTitle(
    currentScreen: String, uiState: MyCityUiState
) = when (currentScreen) {
    MyCityScreen.CategoryList.name -> R.string.categorias
    MyCityScreen.PlacesList.name -> uiState.currentCategory!!.name
    MyCityScreen.Place.name -> uiState.currentCategory!!.name
    else -> R.string.app_name
}

private fun determineIcon(category: Category?): Int {
    return when (category?.name) {
        R.string.cafeterias -> R.drawable.restaurant_icon
        R.string.restaurantes -> R.drawable.bar_icon
        R.string.centrosComerciales -> R.drawable.shops_icon
        R.string.parques -> R.drawable.nature_icon
        R.string.lugaresParaNinios -> R.drawable.attractions_icon
        else -> -1
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    modifier: Modifier = Modifier,
    @StringRes title: Int = R.string.app_name,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    TopAppBar(colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = stringResource(id = title),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                if (title == R.string.app_name) {
                    Image(
                        painter = painterResource(id = R.drawable.bar_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(
                                end = dimensionResource(id = R.dimen.padding_medium)
                            )
                    )
                }
            }
        },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back_button)
                    )
                }
            }
        })
}

@Preview
@Composable
fun MyAppPreview() {
    MyCityTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            MyCityApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }
}

@Preview(device = Devices.TABLET)
@Composable
fun MyAppExpandedPreview() {
    MyCityTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            MyCityApp(windowSize = WindowWidthSizeClass.Expanded)
        }
    }
}