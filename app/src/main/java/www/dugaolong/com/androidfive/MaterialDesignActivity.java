package www.dugaolong.com.androidfive;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 17/3/3.
 */

public class MaterialDesignActivity extends AppCompatActivity {
    private RecyclerView mRecycleview;
    private List<String> mDatas;
    private RecycleAdapter mRecycleAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int ii = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.md_recycle_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();
        mDatas = new ArrayList<String>();
        initData();
        mRecycleAdapter = new RecycleAdapter(this, mDatas);
        mRecycleview.setAdapter(mRecycleAdapter);
        mRecycleAdapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(MaterialDesignActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }
        });

//        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        mRecycleview.setNestedScrollingEnabled(false);
//        linearLayoutManager.setSmoothScrollbarEnabled(true);
        //设置布局管理器
        mRecycleview.setLayoutManager(linearLayoutManager);


    }

    protected void initViews() {
        mRecycleview = (RecyclerView) findViewById(R.id.id_recycleview);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refrash);
        //进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.app_theme_color1, R.color.app_theme_color2, R.color.app_theme_color);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrashData();
            }
        });
    }

    private void refrashData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                        mRecycleAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initData() {
        ii++;
        mDatas.clear();
        for (int i = 0; i <= 30; i++) {
            mDatas.add(i  + ""+ ii);
        }
    }

}