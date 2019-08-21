package com.test.pwpbsesi7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class GoJek_Order extends AppCompatActivity {

    public static String CODE_ORDER = "tipe_order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_jek__order);

        //MULAI CUSTOMIZING UI BERDASARKAN ONCLICK USER DI MAIN
        TipeOrder gojekOrder = getIntent().getParcelableExtra(CODE_ORDER);
        //da imageview
        ImageView imgOrder = findViewById(R.id.img_order);
        imgOrder.setImageDrawable(getDrawable(gojekOrder.id_image));
        //label dibawah imgview
        TextView tvLabel = findViewById(R.id.lbl_order);
        tvLabel.setText(gojekOrder.getLabel_order());
        //label item 3 yang bisa jadi pesanan dan alamat tujuan
        TextView tvData3 = findViewById(R.id.lbl_data3);
        final EditText etData3 = findViewById(R.id.txt_data3);
        if(gojekOrder.getTipe_order()==1){
            tvData3.setText("Pesanan");
            etData3.setHint("Pesanan Anda");
        }else{
            tvData3.setText("Alamat Tujuan");
            etData3.setHint("Alamat Tujuan");
        }
        //warnaButton
        Button btnOrder = findViewById(R.id.btn_order);
        btnOrder.setBackgroundColor(getResources().getColor(gojekOrder.getOrder_color()));

        //MENUJU CONFIRM
        //inisialisasi edittext yang lupa
        final EditText etNama = findViewById(R.id.txt_data_nama);
        final EditText etAlamat = findViewById(R.id.txt_data_alamat);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(GoJek_Order.this,GoJek_Confirm.class);
                pindah.putExtra("DATA_NAMA",etNama.getText().toString());
                pindah.putExtra("DATA_ALAMAT",etAlamat.getText().toString());
                pindah.putExtra("DATA_3",etData3.getText().toString());
                startActivity(pindah);
            }
        });
    }
}
