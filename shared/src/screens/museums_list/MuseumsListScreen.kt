package screens.museums_list

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import data.museum.MuseumObject
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource

data object MuseumsListScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel = getScreenModel<MuseumsListScreenModel>()

        val objects by screenModel.objects.collectAsStateWithLifecycle()

        AnimatedContent(objects.isNotEmpty()) { objectsAvailable ->
            if (objectsAvailable) {
                MuseumsGrid(
                    museums = objects,
                    onClick = { },
                )
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(text = "No data available")
                }
            }
        }
    }
}

@Composable
private fun MuseumsGrid(
    museums: List<MuseumObject>,
    onClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        contentPadding = WindowInsets.safeDrawing.only(WindowInsetsSides.Vertical).asPaddingValues(),
        modifier = modifier
            .fillMaxSize()
            .padding(WindowInsets.safeDrawing.only(WindowInsetsSides.Vertical).asPaddingValues()),
    ) {
        items(museums, key = { it.objectID }) { museum ->
            MuseumFrame(
                museum = museum,
                onClick = { onClick(museum.objectID) },
            )
        }
    }
}

@Composable
private fun MuseumFrame(
    museum: MuseumObject,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        KamelImage(
            resource = asyncPainterResource(data = museum.primaryImageSmall),
            contentDescription = museum.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(ratio = 1f)
                .background(Color.LightGray),
        )

        Spacer(Modifier.height((2.dp)))

        Text(
            text = museum.title,
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = museum.artistDisplayName,
            style = MaterialTheme.typography.bodyMedium,
        )
        Text(
            text = museum.objectDate,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}
