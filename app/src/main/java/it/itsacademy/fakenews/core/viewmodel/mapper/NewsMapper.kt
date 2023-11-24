package it.itsacademy.fakenews.core.viewmodel.mapper

import it.itsacademy.fakenews.R
import it.itsacademy.fakenews.core.remote.response.NewsResponse
import it.itsacademy.fakenews.core.viewmodel.model.PostItemUI
import it.itsacademy.fakenews.ui.home.adapter.PostItemType

fun NewsResponse.mapToUI() : PostItemUI{
    val mod = this.id % 2
    val type = if(mod == 0) PostItemType.LANDSCAPE else PostItemType.PORTRAIT

    return PostItemUI(
        R.drawable.fakenewslogo,
        title,
        body,
        type
    )
}