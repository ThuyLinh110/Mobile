package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.calculator.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayAdapter<String> arrayAdapter;

    public int Cal(String st)
    {
        String operators[]=st.split("[0-9]+");
        String operands[]=st.split("[+-]");
        int result = Integer.parseInt(operands[0]);
        for (int i=1;i<operands.length;i++)
        {
            if (operators[i].equals("+"))
            {
                result+=Integer.parseInt(operands[i]);
            }
            else
            {
                result-=Integer.parseInt(operands[i]);

            }
        }
        return result;



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn0.getText().toString());
                binding.tvResult.append(binding.btn0.getText().toString());
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn1.getText().toString());
                binding.tvResult.append(binding.btn1.getText().toString());
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn2.getText().toString());
                binding.tvResult.append(binding.btn2.getText().toString());

            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn3.getText().toString());
                binding.tvResult.append(binding.btn3.getText().toString());

            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn4.getText().toString());
                binding.tvResult.append(binding.btn4.getText().toString());

            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn5.getText().toString());
                binding.tvResult.append(binding.btn5.getText().toString());

            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn6.getText().toString());
                binding.tvResult.append(binding.btn6.getText().toString());

            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn7.getText().toString());
                binding.tvResult.append(binding.btn7.getText().toString());

            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn8.getText().toString());
                binding.tvResult.append(binding.btn8.getText().toString());

            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText(binding.btn9.getText().toString());
                binding.tvResult.append(binding.btn9.getText().toString());

            }
        });
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvResult.append(binding.btnAdd.getText().toString());

            }
        });
        binding.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvResult.append(binding.btnSub.getText().toString());
            }
        });
        binding.btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvResult.append(binding.btnMul.getText().toString());

            }
        });
        binding.btnDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvResult.append(binding.btnDev.getText().toString());

            }
        });

        binding.btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String st=binding.tvResult.getText().toString();
                binding.tvNum.setText(""+Cal(st));
                binding.tvResult.append("="+Cal(st));

            }
        });
        binding.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvNum.setText("");
                binding.tvResult.setText("");
            }
        });

    }

}