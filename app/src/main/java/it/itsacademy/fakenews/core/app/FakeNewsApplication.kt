package it.itsacademy.fakenews.core.app

import android.app.Application
import it.itsacademy.fakenews.core.app.module.appModule
import it.itsacademy.fakenews.core.app.module.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FakeNewsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FakeNewsApplication)
            modules(remoteModule,appModule)
        }
    }
}