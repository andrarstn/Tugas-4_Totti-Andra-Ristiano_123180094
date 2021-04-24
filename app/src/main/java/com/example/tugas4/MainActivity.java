package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nama,password;
    Button login;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences getPreferences = getSharedPreferences("SAVED_LOGIN", MODE_PRIVATE);
        Boolean check = getPreferences.getBoolean("LOGGED",false);

        if (check){
            Intent intent = new Intent(MainActivity.this, FrameworkActivity.class);
            MainActivity.this.startActivity(intent);
            finish();
        }

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.et_nama);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.btn_login);

        sharedPreferences = getSharedPreferences("SAVED_LOGIN", MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNama = nama.getText().toString();
                String getPassword = password.getText().toString();

                if (getNama.equals("andra") && getPassword.equals("123")){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("LOGGED", true);
                    editor.apply();

                    Toast.makeText(getApplicationContext(),"Login Berhasil",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, FrameworkActivity.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Login Gagal",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}