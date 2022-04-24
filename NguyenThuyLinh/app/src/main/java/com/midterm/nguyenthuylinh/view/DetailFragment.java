package com.midterm.nguyenthuylinh.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.midterm.nguyenthuylinh.R;
import com.midterm.nguyenthuylinh.databinding.FragmentDetailBinding;
import com.midterm.nguyenthuylinh.model.item;

public class DetailFragment extends Fragment {

    private item dog;
    private FragmentDetailBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dog = (item) getArguments().getSerializable("item");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(),R.layout.fragment_detail,null,false);
        View viewRoot = binding.getRoot();
        binding.setItem(dog);
        return viewRoot;
    }
}