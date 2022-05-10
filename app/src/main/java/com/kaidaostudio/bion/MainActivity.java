package com.kaidaostudio.bion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    EditText txtUser,txtPhone,txtAddress;
    Button btnOrder, btnCancel;
    Spinner spnItemType, spnItem, spnItemQuantity;
    String [] arrItemType = {"ຊາ", "ກະທ່ອມ"};
    String [][] arrItem = {
            {"Wedding Cake","Gorilla Glue (GG4)","Sour Diesel","Green Crack","Double Diesel","Do si Dos"},
            {"ແມງດາ","ຫຼຽນທອງ","ກ້ານແດງ","ກ້ານຂຽວ"},
    };
    String [][] arrItemQuantity = {
            {"100 g", "200 g", "300 g", "400 g","500 g"},
            {"30 ໃບ","50 ໃບ","100 ໃບ","200 ໃບ"}
    };

    String [][] arrPrice = {
            {"50,000","67,000","80,000","89,000"},
            {"30,000","40,000","70,000","130,000"}
    } ;

    String getItemPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtUser = findViewById(R.id.txtUser);
        txtPhone = findViewById(R.id.txtPhone);
        txtAddress = findViewById(R.id.txtAddress);

        btnOrder = findViewById(R.id.btnOrder);
        btnCancel = findViewById(R.id.btnCancel);

        spnItemType = findViewById(R.id.spnItemType);
        spnItem = findViewById(R.id.spnItem);
        spnItemQuantity = findViewById(R.id.spnItemQuantity);





        ArrayAdapter arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, arrItemType);
        spnItemType.setAdapter(arrayAdapter_parent);


        spnItemType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    ArrayAdapter arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, arrItem[position]);

                    spnItem.setAdapter(arrayAdapter_child);



                    ArrayAdapter arrayAdapter_super_child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, arrItemQuantity[position]);

                    spnItemQuantity.setAdapter(arrayAdapter_super_child);
                    spnItemQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int pirce_position, long id) {
                            getItemPrice = arrPrice[position][pirce_position];
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtUser.getText().toString().matches("") || txtPhone.getText().toString().matches("") || txtAddress.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "ຂໍ້ມູນບໍ່ຄົບ", Toast.LENGTH_SHORT).show();
                    return;
                }


                String showItemtype = spnItemType.getSelectedItem().toString();
                String showItem = spnItem.getSelectedItem().toString();
                String showItemQuantity = spnItemQuantity.getSelectedItem().toString();
                String showUser = txtUser.getText().toString();
                String showPhone = txtPhone.getText().toString();
                String showAddress = txtAddress.getText().toString();

                Intent intentObj = new Intent(MainActivity.this, Completed.class);
                intentObj.putExtra("showItemType", showItemtype);
                intentObj.putExtra("showItem", showItem);
                intentObj.putExtra("showItemQuantity", showItemQuantity);
                intentObj.putExtra("showUser", showUser);
                intentObj.putExtra("showPhone", showPhone);
                intentObj.putExtra("showAddress", showAddress);
                intentObj.putExtra("showItemPrice", getItemPrice);




                startActivity(intentObj);



            }
        });

    }
}