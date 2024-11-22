import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import screens.museums_list.MuseumsListScreen

@Composable
fun App() {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            Navigator(MuseumsListScreen)
        }
    }
}
