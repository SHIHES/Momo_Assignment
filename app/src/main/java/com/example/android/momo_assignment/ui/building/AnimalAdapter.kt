package com.example.android.momo_assignment.ui.building

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.momo_assignment.databinding.ItemBuildingBinding
import com.example.android.momo_assignment.logic.model.animal.Animal

class AnimalAdapter(
    private val onClickListener: OnClickListener
) : ListAdapter<Animal, AnimalAdapter.AnimalVH>(DiffUtil()){
    
    
    class AnimalVH(private val binding: ItemBuildingBinding) : RecyclerView.ViewHolder(binding.root){
        
        fun bind(animal: Animal){
            
            val url = animal.A_Pic01_URL
            val uri = url.toUri().buildUpon().scheme("https").build()
            
            Glide.with(itemView.context).load(uri).centerCrop().into(binding.itemBuildingImage)
            binding.itemBuildingTitle.text = animal.name
            binding.itemBuildingContent.text = animal.A_Habitat
            
            
        }
    }
    
    class OnClickListener(val clickListener: (animal: Animal) -> Unit){
        fun onClick(animal: Animal) = clickListener(animal)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalVH {
        return AnimalVH(ItemBuildingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    
    override fun onBindViewHolder(holder: AnimalVH, position: Int) {
        val animal = getItem(position)
        holder.bind(animal)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(animal)
        }
    }
    
    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<Animal>() {
        override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem === newItem
        }
    
        override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
            return oldItem == newItem
        }
    
    
    }
}