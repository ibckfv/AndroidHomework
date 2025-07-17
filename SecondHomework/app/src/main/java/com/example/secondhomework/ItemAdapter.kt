package com.example.secondhomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.secondhomework.databinding.ItemViewBinding

class ItemAdapter(
    private val items: List<ItemModel>,
    private val onItemClick: (ItemModel) -> Unit,
    private val onImageClick: (ItemModel) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemModel) {
            binding.title.text = item.title
            binding.description.text = item.description
            binding.image.setImageResource(item.imageResId)

            binding.root.setOnClickListener { onItemClick(item) }
            binding.image.setOnClickListener {
                item.imageResId = ModelFactory.getRandomImage()
                notifyItemChanged(adapterPosition)
                onImageClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}