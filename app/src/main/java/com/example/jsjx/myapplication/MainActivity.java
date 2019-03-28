package com.example.jsjx.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Map<String, Object> map;
    List<Map<String, Object>> list;
    int[] images = new int[]{R.drawable.tab_focus, R.drawable.tab_local, R.drawable.tab_news, R.drawable.tab_pics
            , R.drawable.tab_read, R.drawable.tab_ties, R.drawable.tab_ugc, R.drawable.tab_vote};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            map = new HashMap<>();
            map.put("title", "数据" + i);
            map.put("picture", images[i]);
            list.add(map);


        }
        gridView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);
                TextView textView = view.findViewById(R.id.textView);
                ImageView imageView = view.findViewById(R.id.imageView);
                textView.setText((String) (list.get(position).get("title")));
                imageView.setImageResource((Integer) list.get(position).get("picture"));
                return view;
            }
        });

    }

}
