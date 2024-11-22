package data.museum

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

interface MuseumStorage {
    suspend fun saveObjects(newObjects: List<MuseumObject>)

    fun getObjectById(objectId: Int): Flow<MuseumObject?>

    fun getAllObjects(): Flow<List<MuseumObject>>
}

class InMemoryMuseumStorage : MuseumStorage {
    private val storedObjects: MutableStateFlow<List<MuseumObject>> = MutableStateFlow(emptyList())

    override suspend fun saveObjects(newObjects: List<MuseumObject>) {
        storedObjects.value = newObjects
    }

    override fun getObjectById(objectId: Int): Flow<MuseumObject?> {
        return storedObjects.map { objects: List<MuseumObject> ->
            objects.find { it.objectID == objectId }
        }
    }

    override fun getAllObjects(): Flow<List<MuseumObject>> = storedObjects
}
