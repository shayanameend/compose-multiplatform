package compose.multiplatform

import android.app.Application
import di.initKoin

class ComposeMultiplatformApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}
