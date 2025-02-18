package com.example.ansopedia;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.ansopedia.adapters.CategoryDetailsAdapter;
//import com.example.ansopedia.databinding.ActivityCategoryDetailsBinding;
import com.example.ansopedia.models.CategoryDetailsModel;

import java.util.ArrayList;

public class CategoryDetailsActivity extends AppCompatActivity {

    private CategoryDetailsAdapter adapter;
    private ArrayList<CategoryDetailsModel> arrayList;


    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private RecyclerView topicLists;

    private ImageView backarrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);

        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar = findViewById(R.id.toolbar);
        topicLists = findViewById(R.id.topiclists);
        backarrow = findViewById(R.id.backarrow);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        String name = getIntent().getStringExtra("name");
        String icon = getIntent().getStringExtra("icon");
        String color = getIntent().getStringExtra("color");
        String desc = getIntent().getStringExtra("desc");
        String id = getIntent().getStringExtra("id");

//        when user clicks on back arrow button
        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initTopics();
    }

    private void initTopics() {
        arrayList = new ArrayList<>();
        adapter = new CategoryDetailsAdapter(CategoryDetailsActivity.this,arrayList);

        arrayList.add(new CategoryDetailsModel("Variable",1));
        arrayList.add(new CategoryDetailsModel("Data Type",2));
        arrayList.add(new CategoryDetailsModel("Function",3));
        arrayList.add(new CategoryDetailsModel("Operator",4));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        topicLists.setLayoutManager(layoutManager);
        topicLists.setAdapter(adapter);
    }

}
