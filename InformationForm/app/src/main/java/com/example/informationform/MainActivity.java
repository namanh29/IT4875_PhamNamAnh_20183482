package com.example.informationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextName = findViewById(R.id.editText_name);
                String name = editTextName.getText().toString();
                EditText editTextId = findViewById(R.id.editText_id);
                String id = editTextId.getText().toString();
                EditText editTextDob = findViewById(R.id.editText_dob);
                String dob = editTextDob.getText().toString();
                EditText editTextPhone = findViewById(R.id.editText_phone);
                String phone = editTextPhone.getText().toString();
                EditText editTextEmail = findViewById(R.id.editText_email);
                String email = editTextEmail.getText().toString();

                if(name.length() == 0){
                    Toast toast = Toast.makeText(getBaseContext(), "Tên không được để trống", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if(id.length() == 0){
                    Toast toast = Toast.makeText(getBaseContext(), "MSSV không được để trống", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if(dob.length() == 0){
                    Toast toast = Toast.makeText(getBaseContext(), "Ngày sinh không được để trống", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if(phone.length() == 0){
                    Toast toast = Toast.makeText(getBaseContext(), "Số điện thoại không được để trống", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if(email.length() == 0){
                    Toast toast = Toast.makeText(getBaseContext(), "Email không được để trống", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
            }
        });
    }
}