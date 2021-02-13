package com.seerkanyilmazz.androidwidgets;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    //button_example.xml
    private EditText editTextParameter1;
    private EditText editTextParameter2;
    private Button additionButton;

    //toggle_button_example.xml
    private ToggleButton toggleButton1;
    private ToggleButton toggleButton2;
    private Button submitButton;

    //checkbox_exampl.xml
    private CheckBox coffee;
    private CheckBox pizza;
    private CheckBox burger;
    private Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //if you want to change widget example write layout name.
        setContentView(R.layout.activity_main);
//        setContentView(R.layout.button_example);
//        setContentView(R.layout.toggle_button_example);
//        setContentView(R.layout.checkbox_example);

//        addListenerOnButtonExample();
//        addListenerOnToggleButtonExample();
//        addListenerOnCheckboxExample();
    }

    public void addListenerOnButtonExample ()
    {
        editTextParameter1 = (EditText) findViewById(R.id.editTextParameter1);
        editTextParameter2 = (EditText) findViewById(R.id.editTextParameter2);
        additionButton     = (Button)   findViewById(R.id.additionButton);

        additionButton.setOnClickListener(new View.OnClickListener() {
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

    public void addListenerOnToggleButtonExample ()
    {
        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleButton2 = (ToggleButton) findViewById(R.id.toggleButton2);
        submitButton  = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder result = new StringBuilder();
                result.append("Toggle Button1: ").append(toggleButton1.getText());
                result.append("\nToggle Button2: ").append(toggleButton2.getText());

                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void addListenerOnCheckboxExample()
    {
        coffee = (CheckBox) findViewById(R.id.checkBox1);
        pizza = (CheckBox) findViewById(R.id.checkBox2);
        burger = (CheckBox) findViewById(R.id.checkBox3);
        orderButton = (Button) findViewById(R.id.orderButton);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float orderAmount = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items:");

                if (coffee.isChecked())
                {
                    result.append("\nCoffee: 2,5$");
                    orderAmount += 2.5;
                }
                if (pizza.isChecked())
                {
                    result.append("\nPizza: 13$");
                    orderAmount += 13;
                }
                if (burger.isChecked())
                {
                    result.append("\nBurger: 12,25$");
                    orderAmount += 12.25;
                }

                result.append("\nTotal Order Amount: " + orderAmount + "$");

                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}