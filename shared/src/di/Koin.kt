package di

import data.museum.*
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import screens.museums_list.MuseumsListScreenModel

val dataModule: Module = module {
    single {
        val json = Json {
            ignoreUnknownKeys = true
        }

        HttpClient {
            install(ContentNegotiation) {
                json(
                    json = json,
                    contentType = ContentType.Any,
                )
            }
        }
    }

    single<MuseumApi> {
        KtorMuseumApi(get())
    }

    single<MuseumStorage> {
        InMemoryMuseumStorage()
    }

    single {
        MuseumRepository(get(), get()).apply {
            initilize()
        }
    }
}

val viewModelsModule = module {
    factoryOf(::MuseumsListScreenModel)
}

fun initKoin() {
    startKoin {
        modules(
            dataModule,
            viewModelsModule,
        )
    }
}
