package com.example.jsjx.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    GridView gridView;
    List<Entity> list;
    int[] images = new int[]{R.drawable.tab_focus, R.drawable.tab_local, R.drawable.tab_news, R.drawable.tab_pics
            , R.drawable.tab_read, R.drawable.tab_ties, R.drawable.tab_ugc, R.drawable.tab_vote};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new Entity("数据" + i, images[i]));
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
                View view = LayoutInflater.from(Main2Activity.this).inflate(R.layout.item, null);
                TextView textView = view.findViewById(R.id.textView);
                ImageView imageView = view.findViewById(R.id.imageView);
                textView.setText(list.get(position).getTitle());
                imageView.setImageResource(list.get(position).getPicture());

                return view;
            }
        });

    }
}
