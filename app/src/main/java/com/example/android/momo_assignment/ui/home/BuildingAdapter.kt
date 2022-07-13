package com.example.android.momo_assignment.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.momo_assignment.R
import com.example.android.momo_assignment.databinding.ItemBuildingBinding
import com.example.android.momo_assignment.logic.model.building.Building

class BuildingAdapter (
    private val onClickListener: OnClickListener
) : ListAdapter <Building, BuildingAdapter.BuildingVH>(DiffUtil()){
    
    
    class BuildingVH(private val binding: ItemBuildingBinding) : RecyclerView.ViewHolder(binding.root){
        
        fun bind(building: Building){
            
            val url = building.e_pic_url
            val uri = url.toUri().buildUpon().scheme("https").build()
            
            Glide.with(itemView.context).load(uri).centerCrop().into(binding.itemBuildingImage)
            binding.itemBuildingTitle.text = building.e_name
            binding.itemBuildingContent.text = building.e_info
            
            if (building.e_memo.isEmpty()){
                binding.itemBuildingRestDay.text = com.example.android.momo_assignment.util.Util.getString(
                    R.string.no_rest_day_info)
            } else {
                binding.itemBuildingRestDay.text = building.e_memo
            }

        }
    }
    
    class OnClickListener(val clickListener: (building: Building) -> Unit){
        fun onClick(building: Building) = clickListener(building)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildingVH {
        return BuildingVH(ItemBuildingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    
    override fun onBindViewHolder(holder: BuildingVH, position: Int) {
        val building = getItem(position)
        holder.bind(building = building)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(building)
        }
    }
    
    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Building>() {
        override fun areItemsTheSame(oldItem: Building, newItem: Building): Boolean {
            return oldItem === newItem
        }
    
        override fun areContentsTheSame(oldItem: Building, newItem: Building): Boolean {
            return oldItem == newItem
        }
    
    
    }
}