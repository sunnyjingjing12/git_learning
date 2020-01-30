package com.jingjing.abstractdemo;

import android.util.Log;

public class Cat extends Animal {
    @Override
    public void Shout() {
        super.Shout();
        Log.i("good","喵喵喵");
    }
}
