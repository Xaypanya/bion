package com.kaidaostudio.bion;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Completed extends AppCompatActivity {

    TextView showUser, showPhone, showAddress, showItemType, showItem, showItemQuantity, showItemPrice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        showUser = findViewById(R.id.showUser);
        showPhone = findViewById(R.id.showPhone);
        showAddress = findViewById(R.id.showAddress);
        showItemType = findViewById(R.id.showItemType);
        showItem = findViewById(R.id.showItem);
        showItemQuantity = findViewById(R.id.showItemQuantity);
        showItemPrice = findViewById(R.id.showItemPrice);

        String  getShowUser, getShowPhone, getShowAddress, getShowItem, getShowItemQuantity, getShowItemPrice, getShowItemType;

        getShowUser = getIntent().getStringExtra("showUser");
        getShowPhone = getIntent().getStringExtra("showPhone");
        getShowAddress = getIntent().getStringExtra("showAddress");
        getShowItemType = getIntent().getStringExtra("showItemType");
        getShowItem = getIntent().getStringExtra("showItem");
        getShowItemQuantity = getIntent().getStringExtra("showItemQuantity");
        getShowItemPrice = getIntent().getStringExtra("showItemPrice");

        showUser.setText("ຊື່: "+getShowUser);
        showPhone.setText("ໂທ: "+getShowPhone);
        showAddress.setText("ທີ່ຢູ່: "+getShowAddress);
        showItemType.setText("ສິນຄ້າ: "+getShowItemType);
        showItem.setText("ປະເພດ: "+getShowItem);
        showItemQuantity.setText("ຈຳນວນ: "+getShowItemQuantity);
        showItemPrice.setText("ລາຄາສຸດທິ: "+getShowItemPrice + " ກີບ");

    }
}
