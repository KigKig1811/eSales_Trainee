package com.hqsoft.esales.esales_trainee.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.hqsoft.esales.esales_trainee.R;
import com.hqsoft.esales.esales_trainee.bll.AR_CustomerHandler;
import com.hqsoft.esales.esales_trainee.databinding.ItemCustomerBinding;
import com.hqsoft.esales.esales_trainee.model.AR_CUSTOMER;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHodler> {

    Context context;
    Activity activity;
    ArrayList<String> custID,name,address,phone;

    public CustomerAdapter(Context context, Activity activity, ArrayList<String> custID, ArrayList<String> name, ArrayList<String> address, ArrayList<String> phone) {
        this.context = context;
        this.activity = activity;
        this.custID = custID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public CustomerAdapter.CustomerViewHodler onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_customer,parent,false);

        return new CustomerViewHodler(view);
    }

    @Override
    public void onBindViewHolder( CustomerAdapter.CustomerViewHodler holder, int position) {


        holder.idTv.setText(custID.get(position));
        holder.customerTv.setText(name.get(position));
        holder.addressTv.setText(address.get(position));

    }

    @Override
    public int getItemCount() {
        return custID.size();
    }

    public class CustomerViewHodler extends RecyclerView.ViewHolder {
        TextView idTv,customerTv,addressTv;
        public CustomerViewHodler( View itemView) {
            super(itemView);

            idTv = itemView.findViewById(R.id.idTv);
            customerTv = itemView.findViewById(R.id.customerTv);
            addressTv = itemView.findViewById(R.id.addressTv    );


        }
    }
}
