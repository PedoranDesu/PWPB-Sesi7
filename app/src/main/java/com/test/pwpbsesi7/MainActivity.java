package com.test.pwpbsesi7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button goFood;
    Button goMart;
    Button goSend;
    Button goRide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goFood = findViewById(R.id.btn_food);
        goFood.setOnClickListener(this);
        goSend = findViewById(R.id.btn_send);
        goSend.setOnClickListener(this);
        goMart = findViewById(R.id.btn_mart);
        goMart.setOnClickListener(this);
        goRide = findViewById(R.id.btn_ride);
        goRide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TipeOrder orderTypes = new TipeOrder();
        switch (view.getId()){
            case R.id.btn_food :
                orderTypes.setId_image(R.drawable.menu_gofood);
                orderTypes.setLabel_order("Go-Food");
                orderTypes.setOrder_color(R.color.GoFood);
                orderTypes.setTipe_order(1); //untuk gofood dan gomart
                intentPindah(GoJek_Order.class,orderTypes);
                break;
            case R.id.btn_send :
                orderTypes.setId_image(R.drawable.menu_gosend);
                orderTypes.setLabel_order("Go-Send");
                orderTypes.setOrder_color(R.color.GoSend);
                orderTypes.setTipe_order(2); //untuk gosend dan goride
                intentPindah(GoJek_Order.class,orderTypes);
                break;
            case R.id.btn_ride :
                orderTypes.setId_image(R.drawable.menu_goride);
                orderTypes.setLabel_order("Go-Ride");
                orderTypes.setOrder_color(R.color.GoRide);
                orderTypes.setTipe_order(2); //untuk gosend dan goride
                intentPindah(GoJek_Order.class,orderTypes);
                break;
            case R.id.btn_mart :
                orderTypes.setId_image(R.drawable.menu_gomart);
                orderTypes.setLabel_order("Go-Mart");
                orderTypes.setOrder_color(R.color.GoMart);
                orderTypes.setTipe_order(1); //untuk gofood dan gomart
                intentPindah(GoJek_Order.class,orderTypes);
                break;
        }
    }

    private void intentPindah(Class tujuan,TipeOrder order){
        Intent pindah = new Intent(MainActivity.this, tujuan);
        pindah.putExtra(GoJek_Order.CODE_ORDER,order);
        startActivity(pindah);
    }
}
