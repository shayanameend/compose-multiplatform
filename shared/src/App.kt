import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import views.*

@Composable
fun App() {
    MaterialTheme {
        val bottomNavigationIndex: MutableState<Int> = mutableStateOf(value = 0)

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBarView()
            },
            bottomBar = {
                BottomBarView(bottomNavigationIndex)
            },
        ) { safePadding: PaddingValues ->
            when (bottomNavigationIndex.value) {
                0 -> ChatsView(safePadding)
                1 -> UpdatesView(safePadding)
                2 -> SettingsView(safePadding)
            }
        }
    }
}
