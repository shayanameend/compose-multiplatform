package views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun BottomBarView(
    bottomNavigationIndex: MutableState<Int>
) {
    BottomAppBar(
        actions = {
            NavigationBarItem(
                icon = {
                    Icon(Icons.AutoMirrored.Filled.Chat, contentDescription = "Chats")
                },
                label = {
                    Text(text = "Chats")
                },
                selected = bottomNavigationIndex.value == 0,
                onClick = {
                    bottomNavigationIndex.value = 0
                },
            )
            NavigationBarItem(
                icon = {
                    Icon(Icons.Filled.Update, contentDescription = "Updates")
                },
                label = {
                    Text(text = "Updates")
                },
                selected = bottomNavigationIndex.value == 1,
                onClick = {
                    bottomNavigationIndex.value = 1
                },
            )
            NavigationBarItem(
                icon = {
                    Icon(Icons.Filled.Settings, contentDescription = "Settings")
                },
                label = {
                    Text(text = "Settings")
                },
                selected = bottomNavigationIndex.value == 2,
                onClick = {
                    bottomNavigationIndex.value = 2
                },
            )
        }
    )
}
