package it.itsacademy.fakenews.ui.home.viewholder.holder

import android.view.View
import it.itsacademy.fakenews.core.viewmodel.model.PostItemUI
import it.itsacademy.fakenews.databinding.ItemLandscapeBinding
import it.itsacademy.fakenews.ui.home.viewholder.BaseViewHolder

class HomeLandscapeViewHolder(view : View) : BaseViewHolder(view) {

    fun bind(data : PostItemUI){
        with(ItemLandscapeBinding.bind(itemView)){
            newsImageview.setImageDrawable(itemView.context.resources.getDrawable(data.res))
            newsTitleTextview.text = data.title
        }
    }

}