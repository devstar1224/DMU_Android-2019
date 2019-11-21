package com.example.a210.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListViewItem data;
    private ArrayList<ListViewItem> arrays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = null;
        ListViewAdapter adapter;
        arrays = new ArrayList<ListViewItem>();

        initialData();

        listview = (ListView)findViewById(R.id.listview1);


         adapter = new ListViewAdapter(arrays);
         Log.i("kani", "test");


        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

//        adapter.addItem(getResources().getDrawable(R.drawable.p1),"홍길동", "010-0000-0000");
//
//        adapter.addItem(getResources().getDrawable(R.drawable.p2),"라마다", "010-1000-0000");
//
//        adapter.addItem(getResources().getDrawable(R.drawable.p3),"가나다", "010-2000-0000");

            listview.setAdapter(adapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                    Toast.makeText(MainActivity.this,position + "번째 선택 \n" + item.getTitle() + item.getDesc() + item.getLocation() + item.getEmail(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    private void initialData() {
        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p1),"홍길동", "010-0000-0000", "서울", "hello@nanana.cmcm");
        arrays.add(data);

        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p2),"라마다", "010-1000-0000", "인천", "world@nananan.caca");
        arrays.add(data);

        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p1),"이동건", "010-0300-0000", "해남", "ffa@alala.ccaaa");
        arrays.add(data);
        }
}

