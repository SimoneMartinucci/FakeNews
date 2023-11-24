package it.itsacademy.fakenews.core.viewmodel.mapper

import it.itsacademy.fakenews.core.remote.response.NewsResponse
import it.itsacademy.fakenews.core.viewmodel.model.PostItemUI

fun NewsResponse.mapToUI() : PostItemUI{
    return PostItemUI(
        title,
        body
    )
}