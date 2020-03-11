package com.wjl.flexboxlayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_list;

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_list = findViewById(R.id.rv_list);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager();
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setAlignItems(AlignItems.STRETCH);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);
        rv_list.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter(MainActivity.this);

        rv_list.setAdapter(adapter);
        initData();
        adapter.setList(list);


        adapter.setOnItemClickListener(new MyAdapter.ItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void initData() {

        list.add("论语");
        list.add("圣经");
        list.add("娱乐");
        list.add("达尔文《物种起源》");
        list.add("斯塔夫理阿诺斯《全球通史》");
        list.add("司马迁《史记》");

        list.add("孙武《孙子兵法》");
        list.add("罗贯中《三国演义》");
        list.add("克劳塞维茨《战争论》");
        list.add("《水浒传》");

        list.add("《曾国藩家书》");
        list.add("司汤达《红与黑》");

        list.add("《红楼梦》");
        list.add("玛格丽特·米切尔《飘》");
        list.add("吴承恩《西游记》");
        list.add("鲁迅《呐喊》");
    }
}
