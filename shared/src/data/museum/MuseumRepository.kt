package data.museum

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MuseumRepository(
    private val museumApi: MuseumApi,
    private val museumStorage: MuseumStorage,
) {
    private val scope: CoroutineScope = CoroutineScope(SupervisorJob())

    fun initilize() {
        scope.launch {
            refresh()
        }
    }

    private suspend fun refresh() {
        museumStorage.saveObjects(museumApi.getData())
    }

    fun getObjectById(objectId: Int): Flow<MuseumObject?> =
        museumStorage.getObjectById(objectId)

    fun getAllObjects(): Flow<List<MuseumObject>> =
        museumStorage.getAllObjects()
}
