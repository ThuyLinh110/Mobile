package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.helloword.databinding.ActivityDetailsBinding;
import com.example.helloword.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;
    public static final String EXTRA_DATA = "EXTRA_DATA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);
//        Integer ind = null;
        Intent intent = getIntent();
        if (intent != null){
            String data = intent.getStringExtra("number");
           // String index = intent.getStringExtra("index");

            //ind = Integer.parseInt(index);
            binding.tvDetail.setText(data);
        }

        //Integer finalInd = ind;
        binding.btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent();
                intent1.putExtra("numberEdit",binding.tvDetail.getText().toString());
                setResult(RESULT_OK,intent1);
                finish();
            }
        });

    }


}