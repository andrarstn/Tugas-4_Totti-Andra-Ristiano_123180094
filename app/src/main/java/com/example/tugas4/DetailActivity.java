package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView, textViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail);

        imageView = findViewById(R.id.iv_logodetail);
        textView = findViewById(R.id.tv_nama);
        textViewDetail = findViewById(R.id.tv_detail);

        getIncomingExtra();
    }

    private void getIncomingExtra(){
            Integer logo = getIntent().getIntExtra("logo",0);
            String nama = getIntent().getStringExtra("nama");
            String detail = getIntent().getStringExtra("detail");

            setDataActivity(logo,nama,detail);
    }

    private void setDataActivity(Integer logo,String nama, String detail){
        Glide.with(this).asBitmap().load(logo).into(imageView);
        textView.setText(nama);
        textViewDetail.setText(detail);
    }
}