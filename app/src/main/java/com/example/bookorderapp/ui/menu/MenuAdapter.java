package com.example.bookorderapp.ui.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookorderapp.data.menu.MenuItem;
import com.example.bookorderapp.databinding.ItemMenuItemBinding;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private ItemMenuItemBinding biding;
    private ArrayList<MenuItem>items;
    private  MenuItemInterface listener;

    public MenuAdapter(ArrayList<MenuItem> items, MenuItemInterface listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        biding = ItemMenuItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new MenuViewHolder(biding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        MenuItem item = items.get(holder.getAdapterPosition());
        holder.tvName.setText(item.getName());
        holder.tvAuthor.setText(item.getAuthor());
        holder.tvType.setText(item.getType());
        holder.tvPages.setText(String.valueOf(item.getPages() + " pages"));
        holder.tvPrice.setText(String.valueOf(item.getPrice() + " $"));
        holder.btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.addItem(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvAuthor, tvType, tvPages, tvPrice;
        ImageButton btnAddItem;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = biding.tvName;
            tvAuthor = biding.tvAuthor;
            tvType = biding.tvType;
            tvPages = biding.tvPage;
            tvPrice = biding.tvPrice;
            btnAddItem = biding.btnAddItem;
        }

    }
}
