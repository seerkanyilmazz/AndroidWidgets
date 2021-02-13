package com.seerkanyilmazz.androidwidgets;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextParameter1;
    private EditText editTextParameter2;
    private Button additionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //if you want to change widget example write layout name.
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.button_example);

//        addListenerOnButton();
    }

    public void addListenerOnButton ()
    {
        editTextParameter1 = (EditText) findViewById(R.id.editTextParameter1);
        editTextParameter2 = (EditText) findViewById(R.id.editTextParameter2);
        additionButton     = (Button)   findViewById(R.id.additionButton);

        additionButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                String stringParameter1 = editTextParameter1.getText().toString();
                String stringParameter2 = editTextParameter2.getText().toString();
                
                int intParameter1 = Integer.parseInt(stringParameter1);
                int intParameter2 = Integer.parseInt(stringParameter2);

                int total = intParameter1 + intParameter2;

                Toast.makeText(getApplicationContext(), String.valueOf(total), Toast.LENGTH_LONG).show();
            }
        });
    }
}