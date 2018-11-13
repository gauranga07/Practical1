package com.example.kyle.practical1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button calc;

    private RadioButton rb1, rb2;
    private RadioGroup rg, rg2;
    private CheckBox check;
    private double total = 0.0;
    private EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = (Button) findViewById(R.id.button);
        calc.setOnClickListener(new Button_Clicker());

        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        check = (CheckBox) findViewById(R.id.checkBox);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,
                        "VAT checked", Toast.LENGTH_SHORT).show();

                Log.d("MyApp", "Check box selected");

            }

        });


    }

    public void checkButton1(View v) {
        int r1;
        r1 = rg.getCheckedRadioButtonId();
        rb1 = findViewById(r1);
        if (rb1.getText().toString().equals("red($5)")) {
            total = total + 5;
        } else {
            total = total + 10;
        }
        Toast.makeText(MainActivity.this, rb1.getText() + " Selected", Toast.LENGTH_SHORT).show();

    }

    public void checkButton2(View v) {
        int r2;
        r2 = rg2.getCheckedRadioButtonId();
        rb2 = findViewById(r2);
        if (rb2.getText().toString().equals("Green($5)")) {
            total = total + 5;

        } else {
            total = total + 10;
        }
        Toast.makeText(MainActivity.this, rb2.getText() + " Selected", Toast.LENGTH_SHORT).show();

    }

    class Button_Clicker implements Button.OnClickListener

    {

        @Override

        public void onClick(View v) {

            if (v == calc) {
                Toast.makeText(MainActivity.this,
                        "Calculation button clicked", Toast.LENGTH_SHORT).show();

                doCalculations();
            }

        }
    }

    public void doCalculations() {

        Context context = getApplicationContext();
        CharSequence text = "In doCalculations()";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        if(check.isChecked()){
            double vat=0.2*total*1.0;
            total=total+vat;

        }

        e = (EditText)findViewById(R.id.editText);
        e.setText( total + "");
    }
}