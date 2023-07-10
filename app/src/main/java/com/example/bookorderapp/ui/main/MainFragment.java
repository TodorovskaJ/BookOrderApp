package com.example.bookorderapp.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookorderapp.R;
import com.example.bookorderapp.databinding.FragmentMainBinding;
import com.example.bookorderapp.util.AppHolder;


public class MainFragment extends Fragment {

    FragmentMainBinding binding;
    boolean hasOrderCreated = false;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentMainBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasOrderCreated){
                    Navigation.findNavController(requireActivity(),R.id.nav_host_fragment).navigate(R.id.action_mainFragment_to_reviewOrderFragment);
                } else {
                    Navigation.findNavController(requireActivity(),R.id.nav_host_fragment).navigate(R.id.action_mainFragment_to_menuFragment);
                }
            }
        });

    }

    private void setUpButton (){
        if (AppHolder.order.getItems().size() == 0){
            binding.btnOrder.setText(getString(R.string.create_order));
            hasOrderCreated = false;
        } else {
            binding.btnOrder.setText(getString(R.string.review_order));
            hasOrderCreated = true;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        setUpButton();
    }

}