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

import java.util.List;

/**
 * Created by holyca on 16/12/7.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.MyViewHolder> {

    private final LayoutInflater inflater;
    public Context mContext;
    public List<String> data;

    public SimpleAdapter(Context context, List<String> data) {
        this.mContext = context;
        this.data = data;
        inflater = LayoutInflater.from(mContext);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onLongItemClick(View view, int position);
    }

    private OnItemClickListener mClickListener;

    public void setOnClickListener(OnItemClickListener listener) {
        this.mClickListener = listener;
    }

    //创建viewholder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    //绑定viewholder
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv.setText(data.get(position));

        setUpClick(holder,position);

    }

    protected void setUpClick(final MyViewHolder holder,final int position) {
        if (null != mClickListener) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //使用这个值是为了避免插入数据之后造成的position不准确
                    int layoutPosition = holder.getLayoutPosition();
                    mClickListener.onItemClick(holder.itemView,layoutPosition);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mClickListener.onLongItemClick(holder.itemView,position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void add(int pos) {
        data.add(pos, "insert");
        notifyItemInserted(pos);
    }

    public void delete(int pos) {
        data.remove(pos);
        notifyItemRemoved(pos);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv_text);
        }

    }

}


