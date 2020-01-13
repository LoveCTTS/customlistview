package com.hfad.customlistview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Add=(Button) findViewById(R.id.add);




        ListView listview;
        ListViewAdapter adapter;

         adapter = new ListViewAdapter(); //데이터들을 리스트뷰에 넣을수있도록 어댑터 생성

        listview = (ListView) findViewById(R.id.listview1); // 리스트뷰의 id를 얻어서 listview에 초기화
        listview.setAdapter(adapter); //어뎁터를 리스트뷰에 장착

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.test), "Linux", "Linux contents");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.windows), "Windows", "Windows contents");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.redhat), "Red hat", "Redhat Linux contents");
        //장착된 어뎁터를 통해서 데이터를받고 화면에 set

        Add.setOnClickListener(new Button.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

                
            }

        });


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()  //리스트뷰의 아이템 터치에 반응하는 함수
        {

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

