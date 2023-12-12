package com.example.tasteme.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasteme.databinding.CardItemBinding
import com.example.tasteme.databinding.PopularItemBinding

class CartAdapter(
    private val cartItems: MutableList<String>,
    private val cartItemPrices: MutableList<String>,
    private val cartImages: MutableList<Int>
) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private val itemQuantities = IntArray(cartItems.size) { 1 }

    inner class CartViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                tvFoodName.text = cartItems[position]
                tvFoodPrice.text = cartItemPrices[position]
                imgViewFood.setImageResource(cartImages[position])
                tvQuantity.text = quantity.toString()
                btnMinus.setOnClickListener {
                    if (itemQuantities[position] > 1) {
                        itemQuantities[position]--
                        binding.tvQuantity.text = itemQuantities[position].toString()
                    }
                }
                btnPlus.setOnClickListener {
                    if (itemQuantities[position] <10) {
                        itemQuantities[position]++
                        binding.tvQuantity.text = itemQuantities[position].toString()
                    }
                }
                btnDelete.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        cartItems.removeAt(position)
                        cartItemPrices.removeAt(position)
                        cartImages.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position, cartItems.size)
                    }
                }


            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }
}