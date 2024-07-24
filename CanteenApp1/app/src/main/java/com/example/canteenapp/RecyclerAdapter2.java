package com.example.canteenapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.Viewholder> {
    String categories[];
    Context context;
    int pic;
    int K=0;
    int L=0;
    public RecyclerAdapter2(Context context, String[] categories, int biryani) {
        this.categories=categories;
        this.context=  context;
        this.pic=pic;
    }
    @NonNull
    @Override
    public RecyclerAdapter2.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.menucards,parent,false);
        RecyclerAdapter2.Viewholder viewholder= new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter2.Viewholder holder, int position) {
        holder.textView.setText(categories[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show();
            }
        });
        holder.fav_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,"clicked on fav",Toast.LENGTH_SHORT).show();
                if(L==0){
                    Glide.with(context).load(R.drawable.fav_icon_aftr).into(holder.fav_icon);
                    L=1;
                }
                else{
                    Glide.with(context).load(R.drawable.fav_icon_bfre).into(holder.fav_icon);
                    L=0;
                }

            }
        });
        holder.add_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                K++;
                holder.count.setText(String.valueOf(K));
                Toast.makeText(context,"clicked on add icon",Toast.LENGTH_SHORT).show();
            }
        });
        holder.sub_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( Integer.valueOf(holder.count.getText().toString())>0){
                    K--;
                    holder.count.setText(String.valueOf(K));
                }
                else {

                    holder.count.setText("0");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    public class Viewholder extends  RecyclerView.ViewHolder{
        TextView textView,item_price,count;
        ImageView imageView,fav_icon,add_icon,sub_icon;
        public Viewholder(@NonNull View itemView) {

            super(itemView);
            textView=itemView.findViewById(R.id.item_name);
            item_price=itemView.findViewById(R.id.price);
            count=itemView.findViewById(R.id.count_txt);
            fav_icon=itemView.findViewById(R.id.fav_icon);
            add_icon=itemView.findViewById(R.id.sub_icon);
            sub_icon=itemView.findViewById(R.id.add_icon);
            imageView=itemView.findViewById(R.id.item_img);
        }
    }
}