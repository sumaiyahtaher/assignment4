package com.example.assignment4;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Custom ListView
        ListView listView = findViewById(R.id.listView);
        List<Item> items = new ArrayList<>();
        items.add(new Item("Apple", R.drawable.ic_launcher_foreground));
        items.add(new Item("Banana", R.drawable.ic_launcher_foreground));
        items.add(new Item("Cherry", R.drawable.ic_launcher_foreground));

        CustomAdapter customAdapter = new CustomAdapter(this, items);
        listView.setAdapter(customAdapter);


        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        List<String> listGroup = new ArrayList<>();
        HashMap<String, List<String>> listChild = new HashMap<>();

        listGroup.add("Fruits");
        listGroup.add("Vegetables");

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        List<String> vegetables = new ArrayList<>();
        vegetables.add("Carrot");
        vegetables.add("Potato");
        vegetables.add("Tomato");

        listChild.put(listGroup.get(0), fruits);
        listChild.put(listGroup.get(1), vegetables);

        CustomExpandableListAdapter expandableAdapter = new CustomExpandableListAdapter(this, listGroup, listChild);
        expandableListView.setAdapter(expandableAdapter);
    }
}