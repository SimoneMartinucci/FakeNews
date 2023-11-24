package it.itsacademy.fakenews.core.app.module

import it.itsacademy.fakenews.core.viewmodel.HomeViewModel
import org.koin.dsl.module

val appModule = module {
    single { HomeViewModel(get()) }
}