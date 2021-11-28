package com.example.gmail;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.gmail.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<ItemModel> items;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        items = new ArrayList<>();
        items.add(new ItemModel("Nam Anh", "CV thực tập", "Nộp CV thực tập", "10:01 AM"));
        items.add(new ItemModel( "Hoàn", "Nộp sơ yếu lý lịch", "Content 2", "10:01 AM"));
        items.add(new ItemModel( "Hùng", "Title 3", "Content 3", "10:01 AM"));
        items.add(new ItemModel("Tuấn Anh", "Title 4", "Content 4", "10:01 AM"));
        items.add(new ItemModel("Github.com", "Create repository", "Content 5", "10:01 AM"));
        items.add(new ItemModel("Quang", "Title 6", "Content 6", "10:01 AM"));
        items.add(new ItemModel( "Nhật Hà", "Title 7", "Content 7", "10:01 AM"));
        items.add(new ItemModel("Thu Thủy", "Title 8", "Content 8", "10:01 AM"));
        items.add(new ItemModel( "Văn Long", "Title 9", "Content 9", "10:01 AM"));
        items.add(new ItemModel( "Hoàng Đức", "Title 10", "Content 10", "10:01 AM"));
        items.add(new ItemModel( "Trọng Du", "Title 11", "Content 11", "10:01 AM"));
        items.add(new ItemModel( "Trần Anh", "Title 12", "Content 12", "10:01 AM"));

        adapter = new ItemAdapter(items);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}