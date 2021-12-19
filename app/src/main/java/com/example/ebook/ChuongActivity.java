package com.example.ebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChuongActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragmentChuong = new FragmentChuong();
        fragmentTransaction.add(R.id.frameFragmentChuong, fragmentChuong);


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
           // Toast.makeText(this, "Lanscape Mode", Toast.LENGTH_SHORT).show();
            fragmentTransaction.add(R.id.frameFragmentNoiDung, new FragmentNoiDung());
        }
        fragmentTransaction.commit();

        btnBack = (Button) findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}