package com.jingjing.demoa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity  implements MainAdapter.LoadMoreListener{

    private static final int

    RecyclerView recyclerView;
    MainAdapter adapter;
    SwipeRefreshLayout layout;

    private List<Text> textList = new ArrayList<>();//传入数据

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case BaseLoadAdapter.STATE_LOADING:
                    adapter.setErrorStatus();
                    break;
                case BaseLoadAdapter.STATE_LASTED:
                    adapter.setLastedStatus();
                case BaseLoadAdapter.STATE_ERROR:
                    textList.clear();
                    for (int i=0; i<3; i++) {
                        Text txt = new Text();
                        textList.add(txt);
                    }
                    //adapter.addList(list);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("OhYear", "i am coming");

        intiTexts();
        Text txt = readAssetsTxt(this, "test");
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(this, textList,this);
        recyclerView.setOnScrollListener(new LoadMoreScrollListener(recyclerView));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void loadMoreData() {
        if(adapter.isLoading()) {
            return;
        }
        adapter.setLoading(true);
        Random random =  new Random();
        int randomInt = random.nextInt(3)+1;
        if(randomInt ==1) {
            handler.sendEmptyMessageDelayed(1,3000);
        }else if(randomInt ==2) {
            handler.sendEmptyMessageDelayed(2,3000);
        }else{
            handler.sendEmptyMessageDelayed(3,3000);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void intiTexts() {
        for (int i=0; i<3; i++) {
            textList.add(readAssetsTxt(this, "test"));
        }
        Button button = (Button) findViewById(R.id.button);
        final Text txt = readAssetsTxt(this, "test");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textview = (TextView)findViewById(R.id.text_view);
                textview.setText((CharSequence) txt);
            }
        });
    }

    public Text readAssetsTxt(Context context, String fileName) {
//        super.attachBaseContext(context);
        Text result = null;
        try {
            InputStream is = context.getResources().getAssets().open(fileName + ".txt");
            int length = is.available();
            byte[] butter = new byte[length];
            is.read(butter);
            is.close();
           result = new Text(butter, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}


