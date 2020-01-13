package com.hfad.customlistview;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;




import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter { //xml에 있는 뷰들을 리스트뷰에 적용할수있도록 BaseAdapter을 기준으로 customlistView 클래스 생성

    static public ArrayList<ListViewItem> listViewItemList= new ArrayList<ListViewItem>() ; //이 클래스에서만 사용할수있는 item을 저장하는 변수 listViewitemList생성

    public ListViewAdapter(){

    }

    @Override
    public int getCount(){
        return listViewItemList.size();

    }
    // 리스트뷰에 들어있는 아이템의 수를 반환하는 함수 getCount
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        final int pos = position; //뷰의 위치를 얻어오는 변수 pos에 뷰의 위치 초기화
        final Context context = parent.getContext(); // 어플리케이션의 id를 얻어오는 context변수 생성

        if (convertView == null) //뷰를 실질적으로 사용할수있도록하는 convertView가 아무값도 들어있지않다면
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //context를 통해서 inflater생성(뷰를 실질적 사용가능하게해주는 장치같은거
            convertView = inflater.inflate(R.layout.listview_item, parent, false); //리스트뷰에들어갈 xml과 그외 인자들을 infalte에 넣어서 그 주소값을 convertView로 초기화

        }


        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2);
        //위젯찾기




        ListViewItem listViewItem = listViewItemList.get(position); //뷰의 위치를 얻어서 listViewitem에 저장

        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());
//각 포지션에 세팅




        

        return convertView;
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
} //listview에 item추가하는 함수
}
