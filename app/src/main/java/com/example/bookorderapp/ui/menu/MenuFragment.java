package com.example.bookorderapp.ui.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bookorderapp.R;
import com.example.bookorderapp.data.menu.MenuItem;
import com.example.bookorderapp.databinding.FragmentMenuBinding;
import com.example.bookorderapp.util.AppHolder;

import java.util.ArrayList;


public class MenuFragment extends Fragment implements MenuItemInterface {

    FragmentMenuBinding binding;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentMenuBinding.inflate(inflater,container,false);
      return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       MenuItem item1 = new MenuItem("Romeo and Juliet","William Sheakspir", "tragedy", 98, 20);
        MenuItem item2 = new MenuItem("Harry Potter","J.K.Rowling", "adventure", 250, 25);
        MenuItem item3 = new MenuItem("Petar Pan","Ana Nikolova", "adventure", 115, 20);
        MenuItem item4 = new MenuItem("And then","Sindy Sheldon", "love story", 198, 18);
        MenuItem item5 = new MenuItem("Because i love you","Sindy Sheldon", "love story", 202, 22);
        MenuItem item6 = new MenuItem("Fast and furious","Anton Panov", "action", 352, 22.5);
        MenuItem item7 = new MenuItem("Home alone","Ana Donev", "comedy", 280, 22.5);
        MenuItem item8 = new MenuItem("How to have self-control","Denis Todorovski", "motivational", 110, 20);
        MenuItem item9 = new MenuItem("Read and get rich","Vidoe Podgorec", "motivational", 105, 18.5);
        MenuItem item10 = new MenuItem("The kids from the street","I.J.Bozinova", "comedy", 125, 20.5);

        ArrayList <MenuItem> items = new ArrayList<>();

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        items.add(item10);

        com.example.bookorderapp.ui.menu.MenuAdapter adapter = new com.example.bookorderapp.ui.menu.MenuAdapter(items,this);
        binding.rvMenu.setAdapter(adapter);



    }

    @Override
    public void addItem(MenuItem item) {
        AppHolder.order.getItems().add(item);
        Toast.makeText(requireActivity(), "You have added " + item.getName() + "to your order", Toast.LENGTH_SHORT).show();
    }
}