package screens.museums_list

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import data.museum.MuseumRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class MuseumsListScreenModel(
    museumRepository: MuseumRepository
) : ScreenModel {
    val objects = museumRepository.getAllObjects()
        .stateIn(
            scope = screenModelScope,
            started = SharingStarted.WhileSubscribed(
                stopTimeoutMillis = 5_000
            ),
            initialValue = emptyList()
        )
}
