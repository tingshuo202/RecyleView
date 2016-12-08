package com.shy.recyleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Toast;

import com.shy.recyleview.com.shy.recyleview.adapter.SimpleAdapter;
import com.shy.recyleview.com.shy.recyleview.adapter.StaggeredAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class StaggeredActivity extends AppCompatActivity implements SimpleAdapter.OnItemClickListener {

    private RecyclerView mRecyleView;
    private ArrayList<String> datas;
    private StaggeredAdapter adapter;
    private StaggeredGridLayoutManager linearlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    private void initView() {
        mRecyleView = (RecyclerView) findViewById(R.id.recyle_view);
        adapter = new StaggeredAdapter(this, datas);
        mRecyleView.setAdapter(adapter);

        //设置展示方式
        linearlayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mRecyleView.setLayoutManager(linearlayoutManager);

        //设置分割线,默认的是白色的分割线
       // mRecyleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        adapter.setOnClickListener(this);
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            datas.add("" + (char) i);
        }

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,"click"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongItemClick(View view, int position) {
        adapter.delete(position);

    }
}
