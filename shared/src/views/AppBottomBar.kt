package views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AppBottomBar() {
    BottomAppBar(
        actions = {
            NavigationBarItem(
                icon = {
                    Icon(Icons.AutoMirrored.Filled.Chat, contentDescription = "Chats")
                },
                label = {
                    Text(text = "Chats")
                },
                selected = true,
                onClick = {},
            )
            NavigationBarItem(
                icon = {
                    Icon(Icons.Filled.Update, contentDescription = "Updates")
                },
                label = {
                    Text(text = "Updates")
                },
                selected = false,
                onClick = {},
            )
            NavigationBarItem(
                icon = {
                    Icon(Icons.Filled.Settings, contentDescription = "Settings")
                },
                label = {
                    Text(text = "Settings")
                },
                selected = false,
                onClick = {},
            )
        }
    )
}
