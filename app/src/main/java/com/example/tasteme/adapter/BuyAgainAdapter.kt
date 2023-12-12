package com.example.tasteme.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasteme.databinding.BuyAgainItemBinding
import com.example.tasteme.databinding.CardItemBinding

class BuyAgainAdapter(
    private val menuItems: MutableList<String>,
    private val menuItemPrices: MutableList<String>,
    private val menuImages: MutableList<Int>
) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    class BuyAgainViewHolder(private val binding: BuyAgainItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String, price: String, image: Int) {
            binding.tvFoodName.text = item
            binding.tvPrice.text = price
            binding.imgViewFood.setImageResource(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding =
            BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuyAgainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        val item = menuItems[position]
        val image = menuImages[position]
        val price = menuItemPrices[position]
        holder.bind(item, price, image)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }
}