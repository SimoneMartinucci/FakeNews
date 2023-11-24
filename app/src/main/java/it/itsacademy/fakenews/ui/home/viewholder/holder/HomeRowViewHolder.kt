package it.itsacademy.fakenews.ui.home.viewholder.holder

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import it.itsacademy.fakenews.core.viewmodel.model.RowPostItemUI
import it.itsacademy.fakenews.databinding.ItemRowBinding
import it.itsacademy.fakenews.ui.home.adapter.HomeAdapter
import it.itsacademy.fakenews.ui.home.adapter.PostItemType

class HomeRowViewHolder(view: View) : ViewHolder(view) {
    fun bind(data: RowPostItemUI){
        with(ItemRowBinding.bind(itemView)){
            rowTitleTextview.text = data.title
            itemListRecyclerview.run {
                    val type = data.postList.first().type
                    val orientation = if(type == PostItemType.LANDSCAPE) RecyclerView.HORIZONTAL
                                      else RecyclerView.VERTICAL
                    layoutManager =
                        LinearLayoutManager(itemView.context, orientation,false )
                    adapter = HomeAdapter(data.postList)
            }
        }
    }
}