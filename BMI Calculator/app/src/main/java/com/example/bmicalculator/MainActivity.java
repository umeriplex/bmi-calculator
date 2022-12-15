package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.bmicalculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String[] w = {"kg", "pound"};
    String[] h = {"cm", "m", "ft", "inch"};
    int indexW, indexH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayAdapter<String> weight_adapter = new ArrayAdapter<>(this, R.layout.spinner_item, w);
        ArrayAdapter<String> height_adapter = new ArrayAdapter<>(this, R.layout.spinner_item, h);

        binding.spW.setAdapter(weight_adapter);
        binding.spH.setAdapter(height_adapter);

        binding.spW.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexW = binding.spW.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.spH.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexH = binding.spH.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculation();
            }
        });
    }

    private void calculation() {
        try {
            if (TextUtils.isEmpty(binding.etW.getText().toString())) {
                binding.etW.setError("put your weight");
            } else if (TextUtils.isEmpty(binding.etH.getText().toString())) {
                binding.etH.setError("put your height");
            } else {

                if (indexW == 0 & indexH == 0) {
                    double weight = Double.parseDouble(binding.etW.getText().toString());
                    double height = Double.parseDouble(binding.etH.getText().toString());
                    double res = (weight / height / height) * 10000;
                    binding.bmi.setText("Your BMI is : " + new DecimalFormat("##.#").format(res));
                    res(res);
                }

                if (indexW == 1 & indexH == 0) {
                    double weight = Double.parseDouble(binding.etW.getText().toString()) / 2.205;
                    double height = Double.parseDouble(binding.etH.getText().toString());
                    double res = (weight / height / height) * 10000;
                    binding.bmi.setText("Your BMI is : " + new DecimalFormat("##.#").format(res));
                    res(res);
                }
                if (indexW == 0 & indexH == 1) {
                    double weight = Double.parseDouble(binding.etW.getText().toString());
                    double height = Double.parseDouble(binding.etH.getText().toString()) * 100;
                    double res = (weight / height / height) * 10000;
                    binding.bmi.setText("Your BMI is : " + new DecimalFormat("##.#").format(res));
                    res(res);
                }
                if (indexW == 0 & indexH == 2) {
                    double weight = Double.parseDouble(binding.etW.getText().toString());
                    double height = Double.parseDouble(binding.etH.getText().toString()) * 30.48;
                    double res = (weight / height / height) * 10000;
                    binding.bmi.setText("Your BMI is : " + new DecimalFormat("##.#").format(res));
                    res(res);
                }
                if (indexW == 0 & indexH == 3) {
                    double weight = Double.parseDouble(binding.etW.getText().toString());
                    double height = Double.parseDouble(binding.etH.getText().toString()) * 2.54;
                    double res = (weight / height / height) * 10000;
                    binding.bmi.setText("Your BMI is : " + new DecimalFormat("##.#").format(res));
                    res(res);
                }
                if (indexW == 1 & indexH == 1) {
                    double weight = Double.parseDouble(binding.etW.getText().toString()) / 2.205;
                    double height = Double.parseDouble(binding.etH.getText().toString()) * 100;
                    double res = (weight / height / height) * 10000;
                    binding.bmi.setText("Your BMI is : " + new DecimalFormat("##.#").format(res));
                    res(res);
                }
                if (indexW == 1 & indexH == 2) {
                    double weight = Double.parseDouble(binding.etW.getText().toString()) / 2.205;
                    double height = Double.parseDouble(binding.etH.getText().toString()) * 30.48;
                    double res = (weight / height / height) * 10000;
                    binding.bmi.setText("Your BMI is : " + new DecimalFormat("##.#").format(res));
                    res(res);
                }
                if (indexW == 1 & indexH == 3) {
                    double weight = Double.parseDouble(binding.etW.getText().toString()) / 2.205;
                    double height = Double.parseDouble(binding.etH.getText().toString()) * 2.54;
                    double res = (weight / height / height) * 10000;
                    binding.bmi.setText("Your BMI is : " + new DecimalFormat("##.#").format(res));
                    res(res);
                }
            }
        } catch (Exception e) {
            Log.e("fields are empty", e.getLocalizedMessage());
        }
    }

    private void res(double res) {
        if (res < 18.5)
            binding.res.setText("Underweight");
        else if (res >= 18 && res <= 24.9)
            binding.res.setText("Normal (you are Fit!!)");
        else if (res > 24.9 && res <= 29.9)
            binding.res.setText("Overweight (you should start some body exersize..)");
        else if (res > 29.9 && res <= 34.9)
            binding.res.setText("Obese (moty!!)");
        else if (res > 29.9)
            binding.res.setText("Extremly Obese (mote sand!!)");
    }
}