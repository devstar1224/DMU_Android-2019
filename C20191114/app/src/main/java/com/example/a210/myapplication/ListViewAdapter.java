package com.example.a210.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter{
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public ListViewAdapter(ArrayList<ListViewItem>data){
        this.listViewItemList = data;
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, parent, false);
        }

        ImageView button2 = (ImageView) convertView.findViewById(R.id.imageView1);
        button2.setOnClickListener((v) ->{
                Intent it = new Intent(context, ProfileActivity.class);
                it.putExtra("image", pos);
                it.putExtra("title", listViewItemList.get(pos).getTitle());
                it.putExtra("desc", listViewItemList.get(pos).getDesc());
                it.putExtra("location", listViewItemList.get(pos).getLocation());

                context.startActivity(it);
        });
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2);
        TextView locationTextView = (TextView) convertView.findViewById(R.id.textView3);
        ListViewItem listViewItem = listViewItemList.get(position);

        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());
        locationTextView.setText(listViewItem.getLocation());

        ImageView button = (ImageView)convertView.findViewById(R.id.imageView2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, pos + "번째 선택", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);
                alertdialog.setMessage(listViewItemList.get(pos).getDesc() + "으로 전화하시겠습니까?");

                alertdialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "'확인' 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
                        context.startActivity(intent);
                    }
                });
                alertdialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "'취소 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alert = alertdialog.create();
                alert.setIcon(R.mipmap.ic_launcher);
                alert.setTitle("전화연결");
                alert.show();

            }
        });


        return  convertView;
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    public  void  addItem(Drawable icon, String title, String desc, String location){
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);
        item.setLocation(location);

        listViewItemList.add(item);
    }
}
