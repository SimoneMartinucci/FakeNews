package it.itsacademy.fakenews.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import it.itsacademy.fakenews.R
import it.itsacademy.fakenews.core.viewmodel.model.RowPostItemUI
import it.itsacademy.fakenews.ui.home.viewholder.holder.HomeRowViewHolder


class HomeRowAdapter(private val itemList: List<RowPostItemUI>) : Adapter<HomeRowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRowViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return HomeRowViewHolder(layout)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: HomeRowViewHolder, position: Int) {
        holder.bind(itemList[position])
    }
}