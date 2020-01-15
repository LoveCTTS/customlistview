package com.hfad.customlistview;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;


import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter { //xml에 있는 뷰들을 리스트뷰에 적용할수있도록 BaseAdapter을 기준으로 customlistView 클래스 생성

     static ArrayList<ListViewItem> listViewItemList= new ArrayList<ListViewItem>() ; //이 클래스에서만 사용할수있는 item을 저장하는 변수 listViewitemList생성

    public ListViewAdapter(){

    }


    @Override
    public int getCount(){
        return listViewItemList.size();

    }
    // 배열리스트에 들어가있는 요소의 수가 몇개인지 반환
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) //xml의 View를 받아서 안드로이드 메모리에 생성시키도록해주는 함수
    {


        final int pos = position; //뷰의 위치를 얻어오는 변수 pos에 뷰의 위치 초기화
        final Context context = parent.getContext(); // 어플리케이션의 id를 얻어오는 context변수 생성




        if (convertView == null) //뷰를 실질적으로 사용할수있도록하는 convertView가 아무값도 들어있지않다면
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //context를 통해서 inflater생성(메모리에 xml을 로드해서 실질적 객체로 만들어주는 inflater)
            convertView = inflater.inflate(R.layout.listview_item, parent, false); //리스트뷰에들어갈 xml과 그외 인자들을 infalte에 넣어서 그 주소값을 convertView로 초기화

        }


        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2);
        Button Delete2=(Button)convertView.findViewById(R.id.Delete);
        Switch sw=(Switch)convertView.findViewById(R.id.Colorswitch);



        //위젯찾기(객체로 생성된 listview_item(즉, 리스트뷰에 들어갈 뷰들)들의 정보가 저장된 convertView를 통해서 ID를 통해 각 뷰들의 View를 찾아내서 주소를 각 변수에 저장


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean IsChcked) {
                if(IsChcked)
                {
                Toast.makeText(context,R.string.TOAST_MESSAGE_ON,Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(context,R.string.TOAST_MESSAGE_OFF,Toast.LENGTH_SHORT).show();
                }

            }
        });

        ListViewItem listViewItem = listViewItemList.get(position); //position으로 인덱스를 받아서 배열리스트내의 뷰의 주소를 찾아서 listViewitem으로 초기화

        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());

        Delete2.setOnClickListener(new Button.OnClickListener()
                                   {

                                       @Override
                                       public void onClick(View view)
                                       {
                                        listViewItemList.remove(position); //배열에서 position값에 위치한 한 뷰의 묶음 삭제
                                        notifyDataSetChanged(); //이떄까지 Main에 생성된 자신의 다른 인스턴스를 불러와서 사용하려고했으니 당연히 안되지. adapter2.notefyDataSetChanged() 처럼
                                       }
                                   });





        return convertView; //리스트뷰에 사용할 한 행의 뷰들을 실질적으로 사용할수있는 객체가 저장된 convertView를 통해 다른 곳(listViewItem)에 따로 저장하고 convertView를 반환
    }

@Override
    public long getItemId(int position){
        return position;
} // id를 얻어와서 long으로 반환
@Override
public Object getItem(int position){
        return listViewItemList.get(position);
} // id를 얻어와서 오브젝트로 반환

public void addItem(Drawable icon,String title,String desc) {
    ListViewItem item = new ListViewItem();

    item.setIcon(icon);
    item.setTitle(title);
    item.setDesc(desc);


    listViewItemList.add(item);
} //listview의 배열에 이미지,제목 2개, 버튼 한개 저장
}
