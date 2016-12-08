package com.shy.recyleview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shy.recyleview.com.shy.recyleview.adapter.SimpleAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SimpleAdapter.OnItemClickListener{

    private RecyclerView mRecyleView;
    private ArrayList<String> datas;
    private SimpleAdapter adapter;
    private LinearLayoutManager linearlayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeActionOverflowMenuShown();
        initData();
        initView();



    }

    private void initView() {
        mRecyleView = (RecyclerView) findViewById(R.id.recyle_view);
        adapter = new SimpleAdapter(this, datas);
        mRecyleView.setAdapter(adapter);

        //设置展示方式
        linearlayoutManager = new LinearLayoutManager(this);
        mRecyleView.setLayoutManager(linearlayoutManager);

        //设置分割线,默认的是白色的分割线
       // mRecyleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        mRecyleView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnClickListener(this);
    }

    private void initData() {
        datas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            datas.add("" + (char) i);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.action_listview:
                mRecyleView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case R.id.action_gridview:
                mRecyleView.setLayoutManager(new GridLayoutManager(this, 3));//表示有3列
                break;
            case R.id.action_hor_gridview:
                mRecyleView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));//表示有5行
                break;
            case R.id.action_staggered:
                Intent intent = new Intent(this,StaggeredActivity.class);
                startActivity(intent);
                break;

            case R.id.action_add:
                adapter.add(1);
                break;

            case R.id.action_delete:
                adapter.delete(1);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);

    }

    //为了右上角menu不显示的问题添加的方法
    private void makeActionOverflowMenuShown() {
        //devices with hardware menu button (e.g. Samsung Note) don't show action overflow menu
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this,"short:"+position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLongItemClick(View view, int position) {
        Toast.makeText(this,"long:"+position,Toast.LENGTH_SHORT).show();
    }
}
