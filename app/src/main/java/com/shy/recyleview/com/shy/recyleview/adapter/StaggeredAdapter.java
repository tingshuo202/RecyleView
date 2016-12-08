package com.shy.recyleview.com.shy.recyleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shy.recyleview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by holyca on 16/12/7.
 */

public class StaggeredAdapter extends SimpleAdapter {

//    private final LayoutInflater inflater;
    public Context mContext;
//    public List<String> data;
    public List<Integer> mHeights;

    public StaggeredAdapter(Context context, List<String> data) {
        super(context,data);
//        this.mContext = context;
//        this.data = data;
//        inflater = LayoutInflater.from(mContext);

        mHeights = new ArrayList<Integer>();
        for (int i = 0;i<data.size();i++){
            int h = (int) (Math.random() * 200 + 100);
            mHeights.add(h);
        }
    }

//    //创建viewholder
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.simple_item, parent, false);
//        MyViewHolder holder = new MyViewHolder(view);
//        return holder;
//    }
//
    //绑定viewholder
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(data.get(position));

        setUpClick(holder,position);
    }

//    @Override
//    public int getItemCount() {
//        return data.size();
//    }

//    class MyViewHolder extends ViewHolder {
//
//        TextView tv;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//
//            tv = (TextView) itemView.findViewById(R.id.tv_text);
//        }
//
//    }

}


