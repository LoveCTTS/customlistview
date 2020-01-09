package com.hfad.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview;
        ListViewAdapter adapter;

        adapter = new ListViewAdapter();

        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.test), "Box", "Account Box test");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.test), "Circle", "Account Circle test");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.test), "Ind", "Account Ind test");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);
                String titleStr = item.getTitle();
                String descStr = item.getDesc();
                Drawable iconDrawable = item.getIcon();
            }

        });


    }
}

