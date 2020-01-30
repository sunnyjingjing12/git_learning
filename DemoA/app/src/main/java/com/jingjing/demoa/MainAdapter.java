package com.jingjing.demoa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends BaseLoadAdapter<Text> {
    Context context;
    LoadMoreListener listener;

    public  MainAdapter(Context context, List<Text> textList, MainActivity listener) {

        this.context = context;
        this.textList = textList;
        this.listener = listener;
    }

    @Override
    protected RecyclerView.ViewHolder setItemViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_item_layout,parent,false));
    }

    @Override
    public void  onBindItemViewHolder(RecyclerView.ViewHolder holder, int position){
        ((MainViewHolder) holder).nameText.setText(textList.get(position).getText());
    }

    @Override
    protected  void  LoadingMore() {
        if(listener == null) {
            return;
        }
        listener.loadMoreData();
    }
    static class MainViewHolder extends RecyclerView.ViewHolder{
        TextView nameText;
//        TextView typeText;

        public MainViewHolder(View itemView) {
            super(itemView);

            nameText = (TextView)itemView.findViewById(R.id.text);
//            typeText = (TextView)itemView.findViewById(R.id.type);
        }
    }

    public interface LoadMoreListener{
        void loadMoreData();
    }
}
