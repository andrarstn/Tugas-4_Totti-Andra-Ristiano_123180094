package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {
    Button kembali,simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit_profile);

        kembali = findViewById(R.id.btn_kembali);
        simpan = findViewById(R.id.btn_simpan);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, FrameworkActivity.class);
                EditProfileActivity.this.startActivity(intent);
                finish();
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Tombol simpan berhasil ditekan",Toast.LENGTH_SHORT).show();

            }
        });
    }
}