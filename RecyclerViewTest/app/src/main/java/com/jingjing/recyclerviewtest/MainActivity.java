package com.jingjing.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化水果数据
        initFruits();
        //创建RecyclerView实例，加载布局
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //创建LinearLayoutManager实例，用来指定RecyclerView的布局类型--线性
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //将LinearLayoutManager放入RecyckerView中
        recyclerView.setLayoutManager(layoutManager);
        //添加适配器并创建实例
        FruitAdapter adapter = new FruitAdapter(fruitList);//将fruitList数据传入FruitAdapter
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.mipmap.apple);
            fruitList.add(apple);
        }
    }
}
