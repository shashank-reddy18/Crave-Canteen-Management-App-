package com.example.canteenapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter3 extends RecyclerView.Adapter<RecyclerAdapter3.Viewholder> {
    String cart_items[];
    int[] price;
    int[] item_count;
    Context context;
    int pic;
    static float sum=0;
    TextView amt;

    public RecyclerAdapter3(Context context, String[] cart_items, int biryani, int[] price, TextView amt, int[] item_count) {
        this.cart_items=cart_items;
        this.context=context;
        this.pic=biryani;
        this.price=price;
        this.amt=amt;
        this.item_count=item_count;
    }



    @NonNull
    @Override
    public RecyclerAdapter3.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.cartcard,parent,false);
        RecyclerAdapter3.Viewholder viewholder= new RecyclerAdapter3.Viewholder(view);
        return viewholder;
        //Loop through the array to calculate sum of elements
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter3.Viewholder holder, int position) {
        holder.textView.setText(cart_items[position]);
        holder.item_price.setText("₹ "+ price[position]);
        holder.item_count.setText("x"+item_count[position]);
        sum = sum + (price[position]*item_count[position]);
        amt.setText("₹ "+sum);


    }

    @Override
    public int getItemCount() {
        return cart_items.length;
    }
    public class Viewholder extends  RecyclerView.ViewHolder{
        TextView textView,item_price,item_count;
        ImageView imageView,dustbin;
        ConstraintLayout mainLayout;
        public Viewholder(@NonNull View itemView) {

            super(itemView);
            textView=itemView.findViewById(R.id.textView);
            imageView=itemView.findViewById(R.id.imageView);
            dustbin=itemView.findViewById(R.id.imageView2);
            item_count=itemView.findViewById(R.id.textView3);
            item_price=itemView.findViewById(R.id.textView4);
            mainLayout=itemView.findViewById(R.id.mainlayout2);

        }
    }
}
