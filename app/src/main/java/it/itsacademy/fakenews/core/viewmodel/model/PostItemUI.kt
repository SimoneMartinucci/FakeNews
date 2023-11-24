package it.itsacademy.fakenews.core.viewmodel.model

import androidx.annotation.DrawableRes
import it.itsacademy.fakenews.ui.home.adapter.PostItemType

data class PostItemUI(
    @DrawableRes
    val res: Int,
    val title : String,
    val body : String,
    val type : PostItemType
)