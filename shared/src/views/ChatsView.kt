package views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ChatsView(
    safePadding: PaddingValues
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(safePadding),
    ) {
        Text(text = "Chats")
    }
}
