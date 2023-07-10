package com.example.bookorderapp.ui.order;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookorderapp.databinding.ItemOrderItemBinding;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private ItemOrderItemBinding binding;
    private ArrayList<com.example.bookorderapp.data.menu.MenuItem> items;


    public OrderAdapter(ArrayList<com.example.bookorderapp.data.menu.MenuItem> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemOrderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new OrderViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        com.example.bookorderapp.data.menu.MenuItem item = (com.example.bookorderapp.data.menu.MenuItem) items.get(holder.getAdapterPosition());
        holder.tvName.setText(item.getName());
        holder.tvAuthor.setText(item.getAuthor());
        holder.tvType.setText(item.getType());
        holder.tvPages.setText(String.valueOf(item.getPages() + " pages"));
        holder.tvPrice.setText(String.valueOf(item.getPrice() + " $"));
    }
    

    @Override
    public int getItemCount() {
        return items.size();
    }
 class OrderViewHolder extends RecyclerView.ViewHolder {
     TextView tvName, tvAuthor, tvType, tvPages, tvPrice;
     public OrderViewHolder(@NonNull View itemView) {
         super(itemView);
         tvName = binding.tvName;
         tvAuthor = binding.tvAuthor;
         tvType = binding.tvType;
         tvPages = binding.tvPage;
         tvPrice = binding.tvPrice;
     }
 }



}
