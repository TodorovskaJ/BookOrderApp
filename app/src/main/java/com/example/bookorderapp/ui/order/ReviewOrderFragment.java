package com.example.bookorderapp.ui.order;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bookorderapp.R;
import com.example.bookorderapp.data.menu.MenuItem;
import com.example.bookorderapp.databinding.FragmentReviewOrderBinding;
import com.example.bookorderapp.util.AppHolder;


public class ReviewOrderFragment extends Fragment {
    FragmentReviewOrderBinding binding;

    public ReviewOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReviewOrderBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        OrderAdapter adapter = new OrderAdapter(AppHolder.order.getItems());
        binding.rvOrder.setAdapter(adapter);
        double sum = 0;
        for (MenuItem item : AppHolder.order.getItems()) {
            sum += item.getPrice();
        }

        binding.tvTotal.setText(getString(R.string.total_pay, sum));

        binding.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(requireActivity(), "Your order was successfully payed!", Toast.LENGTH_SHORT).show();
                AppHolder.order.getItems().clear();
                getActivity().onBackPressed();
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}