package com.hfad.customlistview;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;

import android.widget.Switch;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("분실방지");

        actionBar.setDisplayHomeAsUpEnabled(true);




        final ListView listview;
        final ListViewAdapter adapter2;
        Button Add = (Button) findViewById(R.id.add);





               adapter2 = new ListViewAdapter();
        //데이터들을 리스트뷰에 넣을수있도록 어댑터 생성

        listview = (ListView)findViewById(R.id.listview1);
        // 리스트뷰의 id를 얻어서 listview에 listview의 view의 주소를 넣어줌

        listview.setAdapter(adapter2);
        //어뎁터를 리스트뷰에 장착

        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.test), "Linux", "Linux contents");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.windows), "Windows", "Windows contents");
        adapter2.addItem(ContextCompat.getDrawable(this, R.drawable.redhat), "Red hat", "Redhat Linux contents");

        //장착된 어뎁터를 통해서 데이터를받고 화면에 set

        Add.setOnClickListener(new Button.OnClickListener() //Add버튼을 눌렀을때 반응하도록 OnClickListener를 set하고, 그다음에 OnCLickListener를 객체로 생성하여 사용하도록함
        {

            @Override
            public void onClick(View view) //OnClickListener안의 OnClick을 커스터마이징하여 사용하며, view형태의 변수를 인자로 받음
            {
                adapter2.addItem(ContextCompat.getDrawable(MainActivity.this, R.drawable.redhat), "Red hat", "Redhat Linux contents");
                //이미지파일은 ContextCompat클래스의 getDrawable 함수를 사용하여 이미지를 불러오고, 나머지는 텍스트를 인자로보냄)
                adapter2.notifyDataSetChanged();
            }

        });










    }

}

