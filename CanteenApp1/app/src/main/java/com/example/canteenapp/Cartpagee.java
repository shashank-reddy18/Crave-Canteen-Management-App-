package com.example.canteenapp;

import static com.example.canteenapp.R.layout.activity_cartpagee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class Cartpagee extends AppCompatActivity {
    Button paybtn;
    TextView pstatus, amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartpagee);
        RecyclerView recyclerView3;
        RecyclerAdapter3 adapter3;
        String[] Cart_items = {"Masala vada", "Bisibele bath", "Mangaluru Bun"};
        int[] item_count ={1,2,2};
        int[] Price = {20,30,35};

        paybtn = findViewById(R.id.paybtn);
        amt = findViewById(R.id.textView6);
        int famount=1;
        pstatus = findViewById(R.id.pstatus);
        recyclerView3 = findViewById(R.id.cart_recycler_View);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter3 = new RecyclerAdapter3(this, Cart_items, R.drawable.biryani, Price,amt,item_count);
        recyclerView3.setAdapter(adapter3);

        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String samount = String.valueOf(RecyclerAdapter3.sum);
                int amount = Math.round(Float.parseFloat(samount) * 100);

                Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_test_GSChNIODK8ONaY");
                checkout.setImage(R.drawable.cart);

                JSONObject object = new JSONObject();
                try {
                    object.put("name", "GAT Canteen");
                    object.put("description", "Pizza Order Payment");
                    object.put("theme.color", "");
                    object.put("amount", amount);
                    object.put("prefill.contact", "1234567890");
                    object.put("prefill.email", "demo@gmail.com");
                    checkout.open(Cartpagee.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void onPaymentSuccess(String s) {
        pstatus.setText("Order Successfully. \n Transaction No :" + s);
        Intent intent=new Intent(getApplicationContext(),Ordercomplete.class);
        startActivity(intent);

    }

    public void onPaymentError(int i, String s) {
        pstatus.setText("Something went wrong" + s);
    }
}