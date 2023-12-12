package com.example.tasteme.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tasteme.databinding.NotificationItemBinding

class NotificationAdapter(
    private val notification: MutableList<String>,
    private val menuImages: MutableList<Int>
) : RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    class NotificationViewHolder(private val binding: NotificationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(notification: String, image: Int) {
            binding.tvNotification.text = notification
            binding.imageViewNotification.setImageResource(image)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotificationAdapter.NotificationViewHolder {
        val binding =
            NotificationItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotificationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val item = notification[position]
        val image = menuImages[position]
        holder.bind(item, image)
    }

    override fun getItemCount(): Int {
        return notification.size
    }

}