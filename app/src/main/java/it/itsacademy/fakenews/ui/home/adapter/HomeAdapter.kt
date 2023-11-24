package it.itsacademy.fakenews.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import it.itsacademy.fakenews.R
import it.itsacademy.fakenews.core.viewmodel.model.PostItemUI
import it.itsacademy.fakenews.ui.home.viewholder.BaseViewHolder
import it.itsacademy.fakenews.ui.home.viewholder.holder.HomeLandscapeViewHolder
import it.itsacademy.fakenews.ui.home.viewholder.holder.HomePortraitViewHolder

class HomeAdapter(private val itemList : List<PostItemUI>) : Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType){
            PostItemType.LANDSCAPE.ordinal -> {
            val layout = layoutInflater.inflate(R.layout.item_landscape, parent, false)
            HomeLandscapeViewHolder(layout)
        }
            PostItemType.PORTRAIT.ordinal ->{
            val layout = layoutInflater.inflate(R.layout.item_portrait, parent, false)
            HomePortraitViewHolder(layout)
        }

            else -> {
                val layout = layoutInflater.inflate(R.layout.item_landscape, parent, false)
                HomeLandscapeViewHolder(layout)
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return when(itemList[position].type){
            PostItemType.LANDSCAPE -> PostItemType.LANDSCAPE.ordinal
            PostItemType.PORTRAIT ->  PostItemType.PORTRAIT.ordinal
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder){
            is HomeLandscapeViewHolder -> holder.bind(itemList[position])
            is HomePortraitViewHolder -> holder.bind(itemList[position])
        }
    }
}

enum class PostItemType{
    LANDSCAPE,
    PORTRAIT
}