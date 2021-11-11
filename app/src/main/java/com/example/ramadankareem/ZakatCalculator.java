package com.example.ramadankareem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ZakatCalculator extends AppCompatActivity {

    EditText edtGold;
    EditText edtGold2;
    EditText edtSilver;
    EditText edtSilver2;
    EditText edtCash;
    TextView edtResult;
    Double gp,g,sp,s,c,total;
    Button btnGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_calculator);
        edtGold=findViewById(R.id.edtGold);
        edtGold2=findViewById(R.id.edtGold2);
        edtSilver=findViewById(R.id.edtSilver);
        edtSilver2=findViewById(R.id.edtSilver2);
        edtCash=findViewById(R.id.edtCash);
        edtResult=findViewById(R.id.edtResult);
    }

    public void Generate(View view) {

        try{
            Double gp = new Double(edtGold.getText().toString());
            Double g = new Double(edtGold2.getText().toString());
            Double sp = new Double(edtSilver.getText().toString());
            Double s = new Double(edtSilver2.getText().toString());
            Double c = new Double(edtCash.getText().toString());
            total=0.0;
            if(g>85.00){
                total= total+(gp*g*2.5)/100;
            }
            if(s>585.00){
                total= total+(sp*s*2.5)/100;
            }
            if(c>(gp*85)){
                total= total+(c*2.5)/100;
            }
            if(total>0){
                edtResult.setText("Your Payable Zakat Amount is "+total);
            }else{
                edtResult.setText("Your not eligible for Zakat.");
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Empty Input", Toast.LENGTH_SHORT).show();
        }
    }

    public void Reset(View view) {
        edtGold.setText(null);
        edtGold2.setText(null);
        edtSilver.setText(null);
        edtSilver2.setText(null);
        edtCash.setText(null);
        edtResult.setText(null);
    }
}