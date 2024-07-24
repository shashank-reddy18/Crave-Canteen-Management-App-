package com.example.canteenapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.Viewholder> {
    String categories[];
    Context context;
    int pic;
    public RecyclerAdapter1(Context context, String[] categories, int biryani) {
        this.categories=categories;
        this.context=  context;
        this.pic=biryani;
    }
    @NonNull
    @Override
    public RecyclerAdapter1.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.viewholder_category,parent,false);
        RecyclerAdapter1.Viewholder viewholder= new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter1.Viewholder holder, int position) {
        holder.textView.setText(categories[position]);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x;
                x= (String) holder.textView.getText();
                Toast.makeText(context,"Opening "+x+" items",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    public class Viewholder extends  RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        ConstraintLayout mainLayout;
        public Viewholder(@NonNull View itemView) {

            super(itemView);
            textView=itemView.findViewById(R.id.categoryName);
            imageView=itemView.findViewById(R.id.categoryPic);
            mainLayout=itemView.findViewById(R.id.mainLayout1);

        }
    }
}
