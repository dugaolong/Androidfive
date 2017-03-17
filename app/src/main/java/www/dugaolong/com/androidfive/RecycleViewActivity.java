package www.dugaolong.com.androidfive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 16/8/21.
 * adapter
 * datas
 * recycleview
 */
public class RecycleViewActivity extends Activity {
    private RecyclerView mRecycleview;
    private List<String> mDatas;
    private RecycleAdapter mRecycleAdapter;

    private Context mContext;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        mContext = this;


        initDatas();
        initViews();
        mRecycleAdapter = new RecycleAdapter(this, mDatas);
        mRecycleview.setAdapter(mRecycleAdapter);
        mRecycleAdapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                clickItem(position);

//                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }

        });
        //设置布局管理
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        mRecycleview.setLayoutManager(linearLayoutManager);

        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(this);
        mRecycleview.setNestedScrollingEnabled(false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        //设置布局管理器
        mRecycleview.setLayoutManager(linearLayoutManager);

    }

    private void initViews() {
        mRecycleview = (RecyclerView) findViewById(R.id.id_recycleview);
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        mDatas.add("CardView");
        mDatas.add("CardView,CardView,CardView");
        mDatas.add("CardView,CardView,CardView");
        mDatas.add("CardView");
        mDatas.add("CardView,CardView,CardView,CardView,CardView,CardView,CardView,CardView,CardView,CardView,CardView");
        mDatas.add("CardView,CardView,CardView");
        mDatas.add("CardView,CardView,CardView,CardView,CardView,CardView,CardView,CardView," +
                "CardView,CardView,CardView,CardView,CardView,CardView,CardView,CardView,CardView,CardView,CardView");
        mDatas.add("CardView");
        mDatas.add("CardView,CardView,CardView,CardView");


    }

    private void clickItem(int position) {
        if (position == 0) {
            Intent intent = new Intent(RecycleViewActivity.this, CardViewActivity.class);
            startActivity(intent);
        }
        if (position == 1) {
            Intent intent = new Intent(RecycleViewActivity.this, ToolBarActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_listview:
                Toast.makeText(this, "list", Toast.LENGTH_LONG).show();
                //设置布局管理
                mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                mRecycleview.setLayoutManager(mLayoutManager);
                break;
            case R.id.menu_gridview:
                Toast.makeText(this, "grid", Toast.LENGTH_LONG).show();
                //设置布局管理
                mLayoutManager = new GridLayoutManager(this, 3);
                mRecycleview.setLayoutManager(mLayoutManager);
                break;
            case R.id.menu_staggaredgridview:
                Toast.makeText(this, "staggaredgridview", Toast.LENGTH_LONG).show();
                int spanCount = 2;
                mLayoutManager = new StaggeredGridLayoutManager(
                        spanCount,
                        StaggeredGridLayoutManager.VERTICAL);
                mRecycleview.setLayoutManager(mLayoutManager);
//                startActivity(new Intent(this,StaggaredRecycleView.class));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
