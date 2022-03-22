package com.example.helloword;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloword.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_EXAMPLE = 0x9345;
    private ActivityMainBinding binding;
    private MyViewModel model;
    //private ListViewModel listModel;

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList;

    private  Integer position;

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        model.updateNumber(position, data.getStringExtra("numberEdit").toString());
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(MyViewModel.class);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);

        //arrayList = new ArrayList<String>();

        arrayAdapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_list_item_1,
                model.getListNumber().getValue());
        binding.lvCount.setAdapter(arrayAdapter);

        model.getNumber().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.tvCount.setText(""+integer);

            }
        });


        binding.btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.increaseNumber();
                model.addNumber(binding.tvCount.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });


        binding.lvCount.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                model.delNumber(i);
                arrayAdapter.notifyDataSetChanged();
                return false;
            }
        });

        binding.lvCount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);


                intent.putExtra("number", model.getListNumber().getValue().get(i));
                position = i;

                someActivityResultLauncher.launch(intent);

            }
        });





    }
// @Override
//     protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//         super.onActivityResult(requestCode, resultCode, data);
//
//         // Kiểm tra requestCode có trùng với REQUEST_CODE vừa dùng
//         if(resultCode == RESULT_OK && requestCode==345) {
//
//             String num = data.getStringExtra("numberEdit");
//             arrayList.set(position, num);
//             arrayAdapter.notifyDataSetChanged();
//
//         }
//     }




}


