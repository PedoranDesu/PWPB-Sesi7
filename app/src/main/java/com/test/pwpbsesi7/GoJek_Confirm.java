package com.test.pwpbsesi7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GoJek_Confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_jek__confirm);

        TextView tvNama = findViewById(R.id.data1);
        TextView tvAlamat = findViewById(R.id.data2);
        TextView tvData3 = findViewById(R.id.data3);

        tvNama.setText(getIntent().getStringExtra("DATA_NAMA"));
        tvAlamat.setText(getIntent().getStringExtra("DATA_ALAMAT"));
        tvData3.setText(getIntent().getStringExtra("DATA_3"));

        Button btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homie = new Intent(GoJek_Confirm.this,MainActivity.class);
                startActivity(homie);
            }
        });
    }
}
