package com.hqsoft.esales.esales_trainee.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.Toast;

import com.hqsoft.esales.esales_trainee.R;
import com.hqsoft.esales.esales_trainee.adapter.CustomerAdapter;
import com.hqsoft.esales.esales_trainee.bll.AR_CustomerHandler;
import com.hqsoft.esales.esales_trainee.bll.AR_SalespersonHandler;
import com.hqsoft.esales.esales_trainee.databinding.ActivityMainBinding;
import com.hqsoft.esales.esales_trainee.model.AR_CUSTOMER;
import com.hqsoft.esales.esales_trainee.model.AR_SALESPERSON;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static ActivityMainBinding binding;

    CustomerAdapter adapter;
    ArrayList<String> custID,name,address,phone;
    AR_CustomerHandler db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitleActionBar();
       /* addDataForDB();
        addDataCustomer();*/

        db = new AR_CustomerHandler(MainActivity.this);
        custID = new ArrayList<>();
        name = new ArrayList<>();
        address = new ArrayList<>();
        phone = new ArrayList<>();

        storeDataInArrays();

        adapter = new CustomerAdapter(this,MainActivity.this,custID,name,address,phone);
        binding.customerRecyclerView.setAdapter(adapter);


    }

    private void storeDataInArrays() {
        Cursor cursor = db.getAll();
        if(cursor.getCount() == 0){
            Toast.makeText(MainActivity.this,"GET DATA FAIL !",Toast.LENGTH_SHORT).show();

        }
        else {
            while (cursor.moveToNext()){
                custID.add(cursor.getString(0));
                name.add(cursor.getString(1));
                address.add(cursor.getString(2));
                phone.add(cursor.getString(3));

            }
        }

    }

   /* private void addDataForDB() {
        AR_SalespersonHandler db = new AR_SalespersonHandler(MainActivity.this);
        AR_SALESPERSON person = new AR_SALESPERSON("1","sa1","TrinhNgocKinh","Nghe An");
        AR_SALESPERSON person1 = new AR_SALESPERSON("2","sa1","Thanh Hang","Nghe An");
        db.addSalesPerson(person);
        db.addSalesPerson(person1);
    }*/
   /* private void addDataCustomer(){
        AR_CustomerHandler db = new AR_CustomerHandler(MainActivity.this);
        AR_CUSTOMER customer1 = new AR_CUSTOMER("1","Khách hàng A","Quận 7","0981714206");
        AR_CUSTOMER customer2 = new AR_CUSTOMER("2","Khách hàng B","Quận 1","0123456788");
        AR_CUSTOMER customer3 = new AR_CUSTOMER("3","Khách hàng C","Quận 2","0981712206");
        AR_CUSTOMER customer4 = new AR_CUSTOMER("4","Khách hàng D","Quận 3","0981776506");
        AR_CUSTOMER customer5 = new AR_CUSTOMER("5","Khách hàng E","Quận 4","0987654421");
        AR_CUSTOMER customer6 = new AR_CUSTOMER("6","Khách hàng F","Quận 5","01727813721");
        AR_CUSTOMER customer7 = new AR_CUSTOMER("7","Khách hàng G","Quận 6","127468127");
        AR_CUSTOMER customer8 = new AR_CUSTOMER("8","Khách hàng H","Quận 7","1624871412");
        db.addCustomer(customer1);
        db.addCustomer(customer2);
        db.addCustomer(customer3);
        db.addCustomer(customer4);
        db.addCustomer(customer5);
        db.addCustomer(customer6);
        db.addCustomer(customer7);
        db.addCustomer(customer8);


    }*/

    private void setTitleActionBar() {
        ActionBar actionBar = getSupportActionBar();
        int red = Color.RED;
        actionBar.setBackgroundDrawable(new ColorDrawable(red));
        setActionbarTextColor(actionBar,Color.WHITE);
        actionBar.setTitle("Danh sach khach hang");
    }

    private void setActionbarTextColor(ActionBar actionBar, int color) {

        String title = actionBar.getTitle().toString();
        Spannable spannablerTitle = new SpannableString(title);
        spannablerTitle.setSpan(new ForegroundColorSpan(color), 0, spannablerTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(spannablerTitle);

    }
}