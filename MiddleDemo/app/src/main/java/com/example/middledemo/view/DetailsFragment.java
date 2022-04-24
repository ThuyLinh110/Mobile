package com.example.middledemo.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.middledemo.R;
import com.example.middledemo.databinding.FragmentDetailsBinding;
import com.example.middledemo.model.DogBreed;


public class DetailsFragment extends Fragment {


    private DogBreed dog;
    private FragmentDetailsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            dog = (DogBreed) getArguments().getSerializable("dogBreed");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.fragment_details,null,false);
        View viewRoot = binding.getRoot();
        binding.setDog(dog);
        return viewRoot;
    }
}