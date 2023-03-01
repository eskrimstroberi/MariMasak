package com.example.uklrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

    class GridResepAdapter (val listResep: ArrayList<Resep>) : RecyclerView.Adapter<GridResepAdapter.GridViewHolder>() {
        private lateinit var onItemClickCallback: OnItemClickCallback
            fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
                this.onItemClickCallback = onItemClickCallback
            }
            class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
                var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
            }
            override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
                val view: View = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.item_grid_resep, viewGroup, false)
                return GridViewHolder(view)
            }
            override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
                val (nama) = listResep[position]
                Glide.with(holder.itemView.context)
                    .load(listResep[position].photo)
                    .apply(RequestOptions().override(350, 550))
                    .into(holder.imgPhoto)
                    holder.tvName.text = nama
                    holder.itemView.setOnClickListener {
                        onItemClickCallback.onItemClicked(listResep[holder.adapterPosition])
                }
            }
            override fun getItemCount(): Int {
                return listResep.size
            }
            interface OnItemClickCallback {
                fun onItemClicked(data: Resep)
            }
        }




