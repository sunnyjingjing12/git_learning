package com.jingjing.abstractdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        animal = new Dog();
    }

    public void initView() {
//        ImageView imageView = new ImageView();
//        imageView
        Button button_main1 = (Button)findViewById(R.id.button_main1);
        Button button_main2 = (Button)findViewById(R.id.button_main2);
        final Button button_dog = (Button)findViewById(R.id.button_dog);
        Button button_cat = (Button)findViewById(R.id.button_cat);
        button_main1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animal.Shout();
            }
        });
        button_dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //doggy.Shout();rtti
            }
        });
        button_main2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal catty = new Cat();
                Log.i("good","创建猫猫对象");
            }
        });
        button_dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //加个判断
                Log.i("good","还没创建狗狗对象");

            }
        });
        button_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animal catty = new Cat();
            }
        });


    }

}
