package com.android.quangthai.lab2b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Khai báo các thành phần
    private TextView txtResult;
    private EditText txtHeight;
    private EditText txtWeight;
    private Button btnCal;
    private double weight;
    private double height;
    @Override
    //Khởi tạo app
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
    //Trả kết luận
    private String result(double BMI)
    {
       if(BMI < 18.5)
       {
            return "You are categorized as underweight";
       }
       else if (BMI < 24.9)
       {
           return "You are categorized as normal weight.";
       }
       else if (BMI < 29.9)
       {
           return "You are categorized as overweight.";
       }
       else if (BMI < 34.9)
       {
           return "You are categorized as obese class I (Moderately obese). ";
       }
       else if (BMI < 39.9)
       {
           return "You are categorized as obese class II (Severely obese).";
       }
       else
           return "You are categorized as obese class III (Very severely) ";
    }
    //Tính toán BMI
    private double calculateBMI(double weight, double height)
    {
        return (weight/ Math.pow(height, 2));
    }
    //Thêm listener cho button
    private void addEvents()
    {
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = Double.parseDouble(txtWeight.getText().toString());
                height = Double.parseDouble(txtHeight.getText().toString());
                txtResult.setText(result(calculateBMI(weight, height)));
            }
        });
    }
    //Inject các control
    private void addControls()
    {
        txtResult = findViewById(R.id.txtKetQua);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        btnCal = findViewById(R.id.btnCal);
    }
}
