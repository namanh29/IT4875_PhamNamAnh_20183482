package com.example.convertnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String[] items = { "Binary", "Octal", "Decimal", "Hex"};
    Integer[] numberBase = {2,8,10,16};
    Spinner spinner1;
    Spinner spinner2;
    EditText editTextNumber;
    Long inputNumber;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        editTextNumber = findViewById(R.id.editTextNumber);
        txtResult = findViewById(R.id.txtResult);
        findViewById(R.id.button).setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            String txtNumber = editTextNumber.getText().toString();

            int index1 = spinner1.getSelectedItemPosition();
            int index2 = spinner2.getSelectedItemPosition();
            try {
                inputNumber = Long.parseLong(txtNumber, numberBase[index1]);
                String txtOutputNumber = Long.toString(inputNumber, numberBase[index2]);
                txtResult.setText("Result: " + txtOutputNumber);
            } catch(Exception e){
                Toast.makeText(getApplicationContext(), "Đầu vào không hợp lệ",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}