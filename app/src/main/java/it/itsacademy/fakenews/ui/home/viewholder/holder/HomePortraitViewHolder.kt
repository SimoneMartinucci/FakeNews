package it.itsacademy.fakenews.ui.home.viewholder.holder

import android.view.View
import it.itsacademy.fakenews.core.viewmodel.model.PostItemUI
import it.itsacademy.fakenews.databinding.ItemPortraitBinding
import it.itsacademy.fakenews.ui.home.viewholder.BaseViewHolder

class HomePortraitViewHolder(view : View) : BaseViewHolder(view) {

    fun bind(data: PostItemUI){
        with(ItemPortraitBinding.bind(itemView)){
            itemPortraitTitleTextview.text = data.title
            itemPortraitDescTextview.text = data.body
            itemPortraitImageview.setImageDrawable(itemView.context.resources.getDrawable(data.res))
        }
    }
}