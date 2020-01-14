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

import static com.hfad.customlistview.ListViewAdapter.listViewItemList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Add = (Button) findViewById(R.id.add);
        final ListView listview;
        final ListViewAdapter adapter2;
        Button Delete2=(Button)findViewById(R.id.Delete);


        adapter2= new ListViewAdapter();
        //데이터들을 리스트뷰에 넣을수있도록 어댑터 생성

        listview = (ListView)findViewById(R.id.listview1);
        // 리스트뷰의 id를 얻어서 listview에 listview의 view의 주소를 넣어줌

        listview.setAdapter(adapter2);
        //어뎁터를 리스트뷰에 장착

        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.test), "Linux", "Linux contents", "Delete");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.windows), "Windows", "Windows contents", "Delete");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.redhat), "Red hat", "Redhat Linux contents", "Delete");

        //장착된 어뎁터를 통해서 데이터를받고 화면에 set

        Add.setOnClickListener(new Button.OnClickListener() //Add버튼을 눌렀을때 반응하도록 OnClickListener를 set하고, 그다음에 OnCLickListener를 객체로 생성하여 사용하도록함
        {

            @Override
            public void onClick(View view) //OnClickListener안의 OnClick을 커스터마이징하여 사용하며, view형태의 변수를 인자로 받음
            {
                adapter2.addItem(ContextCompat.getDrawable(MainActivity.this, R.drawable.redhat), "Red hat", "Redhat Linux contents", "Delete");
                //이미지파일은 ContextCompat클래스의 getDrawable 함수를 사용하여 이미지를 불러오고, 나머지는 텍스트를 인자로보냄)
                adapter2.notifyDataSetChanged();
            }

        });
        Delete2.setOnClickListener(new Button.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                final int position = listview.getPositionForView((View)view.getParent());
                listViewItemList.remove(position);
                adapter2.notifyDataSetChanged();

            }

        });






    }
}

