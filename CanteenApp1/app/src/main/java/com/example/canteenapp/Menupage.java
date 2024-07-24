package com.example.canteenapp;
import static com.example.canteenapp.R.layout.activity_menupage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class Menupage extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
//    private RecyclerView.Adapter adapter;
    RecyclerView recyclerView,recyclerView1,recyclerView2;
    RecyclerAdapter adapter;
    RecyclerAdapter1 adapter1;
    RecyclerAdapter2 adapter2;

    String[] Todayspl ={"Biryani","Poori","Masala vada","Bisibele bath","Mangaluru Bun"};
    String[] Categories ={"All","Breakfast","Lunch","Juice\nBeverages","Snacks","Icecreams"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_menupage);
//        recyclerViewCategory();
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter=new RecyclerAdapter(this,Todayspl,R.drawable.biryani);
        recyclerView.setAdapter(adapter);

        recyclerView1=findViewById(R.id.recyclerView2);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter1=new RecyclerAdapter1(this,Categories,R.drawable.biryani);
        recyclerView1.setAdapter(adapter1);

        recyclerView2=findViewById(R.id.recyclerView_menu);
        recyclerView2.setLayoutManager(new GridLayoutManager(this,3));
        adapter2=new RecyclerAdapter2(this,Todayspl,R.drawable.biryani);
        recyclerView2.setAdapter(adapter2);



        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

//    private void recyclerViewCategory() {
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        RecyclerView recyclerViewCategoryList = findViewById(R.id.recyclerView2);
//        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
//
//        ArrayList<CategoryDomain> category=new ArrayList<>();
//        category.add(new CategoryDomain("Tomato Bath","biryani"));
//        category.add(new CategoryDomain("Biryani","biryani"));
//        category.add(new CategoryDomain("Poori","biryani"));
//        category.add(new CategoryDomain("Mangaluru Bun","biryani"));
//        category.add(new CategoryDomain("Masala vada","biryani"));
//        category.add(new CategoryDomain("Student spl","biryani"));
//        category.add(new CategoryDomain("Bisibele bath","biryani"));
//
//        adapter=new CategoryAdaptor(category);
//        recyclerViewCategoryList.setAdapter(adapter);
//
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void cartpage(View view) {
        Intent intent=new Intent(getApplicationContext(),Cartpagee.class);
        startActivity(intent);
        RecyclerAdapter3.sum=0;
        Toast.makeText(Menupage.this, "Going to Cart", Toast.LENGTH_LONG).show();

    }
}
