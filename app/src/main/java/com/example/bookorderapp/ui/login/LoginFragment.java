package com.example.bookorderapp.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bookorderapp.R;
import com.example.bookorderapp.databinding.ActivityMainBinding;
import com.example.bookorderapp.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {

    FragmentLoginBinding binding;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        enableLoginButton(false);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (checkRequirements()){
                    enableLoginButton(true);
                } else {
                    enableLoginButton(false);
                }

            }
        };
        binding.etLoginUsername.addTextChangedListener(textWatcher);
        binding.etPassword.addTextChangedListener(textWatcher);


    binding.btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Navigation.findNavController(requireActivity(),R.id.nav_host_fragment).navigate(R.id.action_loginFragment_to_mainFragment);
        }


    });

    }


    public boolean checkRequirements(){
        if (binding.etLoginUsername.getText().toString().length() >3 && binding.etPassword.getText().toString().length() > 3 ){
            return true;
        } else {
            return false;
        }
}


    public void enableLoginButton(boolean enable) {
        if (enable) {
            binding.btnLogin.setEnabled(true);
            binding.btnLogin.setClickable(true);
            binding.btnLogin.setAlpha(1f);
        } else {
            binding.btnLogin.setEnabled(false);
            binding.btnLogin.setClickable(false);
            binding.btnLogin.setAlpha(0.5f);
        }
    }
}