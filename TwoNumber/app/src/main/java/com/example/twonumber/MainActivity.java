package com.example.twonumber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.twonumber.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private MyViewModel model;
    private ActivityMainBinding binding;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        model = new ViewModelProvider(this).get(MyViewModel.class);
        arrayAdapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_list_item_1,
                model.getListNumber().getValue());
        binding.lvHistory.setAdapter(arrayAdapter);

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.addNumber(Integer.parseInt(binding.edvA.getText().toString()), Integer.parseInt(binding.edvB.getText().toString()));
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.subNumber(Integer.parseInt(binding.edvA.getText().toString()), Integer.parseInt(binding.edvB.getText().toString()));
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.mulNumber(Integer.parseInt(binding.edvA.getText().toString()), Integer.parseInt(binding.edvB.getText().toString()));
                arrayAdapter.notifyDataSetChanged();
            }
        });
        binding.btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.devNumber(Integer.parseInt(binding.edvA.getText().toString()), Integer.parseInt(binding.edvB.getText().toString()));
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}