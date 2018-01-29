package www.dgl.com.androidfive;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import www.dgl.com.androidfive.charts.ChartsAcitivty;
import www.dgl.com.androidfive.charts.PieChartActivity;
import www.dgl.com.androidfive.charts.PieChartActivityT;

/**
 * Created by dugaolong on 16/8/21.
 * adapter
 * datas
 * recycleview
 */
public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView mRecycleview;
    private List<String> mDatas;
    private RecycleAdapter mRecycleAdapter;

    private Context mContext;
    private RecyclerView.LayoutManager mLayoutManager;
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;

    private PackageManager mPackageManager;
    private List<ResolveInfo> mAllApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        mContext = this;


        initDatas();
        initViews();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            for(int i=0;i<Build.SUPPORTED_ABIS.length;i++){
                Log.e("QtsppApplication", "SUPPORTED_ABIS:"+Build.SUPPORTED_ABIS[i]);
            }
        }
        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(this);
        // 设置是否允许嵌套滑动
        mRecycleview.setNestedScrollingEnabled(false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        //设置布局管理器
        mRecycleview.setLayoutManager(linearLayoutManager);

        mRecycleAdapter = new RecycleAdapter(this, mDatas);
        mRecycleview.setAdapter(mRecycleAdapter);
        mRecycleAdapter.setOnItemClickListener(new RecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                clickItem(position);
            }

        });
        initToolBar();
    }

    private void initViews() {
        mRecycleview = (RecyclerView) findViewById(R.id.id_recycleview);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);
        navigationView =
                (NavigationView) findViewById(R.id.nv_main_navigation);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            menuItem.setChecked(true);
                            mDrawerLayout.closeDrawers();
                            return true;
                        }
                    });
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"fab clicked",Toast.LENGTH_LONG).show();
                Snackbar.make(v, "data delete ", Snackbar.LENGTH_SHORT).setAction("yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "data has delete", Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        mDatas.add("0CardView,CardView,CardView,CardView,CardView,CardView,");
        mDatas.add("1ToolBBar,ToolBBar,ToolBBar");
        mDatas.add("2RippleEffect,RippleEffect,RippleEffect");
        mDatas.add("3TabLayoutActivity");
        mDatas.add("4MaterialDesignActivity");
        mDatas.add("5ChartsAcitivty,ChartsAcitivty,ChartsAcitivty,ChartsAcitivty");
        mDatas.add("6PieChartActivity,PieChartActivity,PieChartActivity,PieChartActivity");
        mDatas.add("7PieChartActivityT,PieChartActivityT,PieChartActivityT,PieChartActivityT");
        mDatas.add("8ResolveInfo");
        mDatas.add("9menu");
        mDatas.add("10menu");
        mPackageManager = getPackageManager();

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
        if (position == 2) {
            Intent intent = new Intent(RecycleViewActivity.this, RippleEffectActivity.class);
            startActivity(intent);
        }
        if (position == 3) {
            Intent intent = new Intent(RecycleViewActivity.this, TabLayoutActivity.class);
            startActivity(intent);
        }
        if (position == 4) {
            Intent intent = new Intent(RecycleViewActivity.this, MaterialDesignActivity.class);
            startActivity(intent);
        }
        if (position == 5) {
            Intent intent = new Intent(RecycleViewActivity.this, ChartsAcitivty.class);
            startActivity(intent);
        }

        if (position == 6) {
            Intent intent = new Intent(RecycleViewActivity.this, PieChartActivity.class);
            startActivity(intent);
        }

        if (position == 7) {
            Intent intent = new Intent(RecycleViewActivity.this, PieChartActivityT.class);
            startActivity(intent);
        }

        if (position == 8) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //应用过滤条件
                    Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
                    mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
                    mAllApps = mPackageManager.queryIntentActivities(mainIntent, 0);
                    for(int i=0;i<mAllApps.size();i++){
                        Log.e("mAllApps",mAllApps.get(i).activityInfo.packageName.toString());
                    }
                }
            }).start();
        }

        if (position == 9) {
            IntentProjectUtil.startActivityByActionName((Activity) mContext, "MainActivity");
//            Intent intent = new Intent(RecycleViewActivity.this, PieChartActivityT.class);
//            startActivity(intent);
        }
        if (position == 10) {
            new android.app.AlertDialog.Builder(RecycleViewActivity.this,R.style.AlertDialog)
//                .setTitle("提醒")
                    .setMessage("该产品体验期已结束，需开通后使用")
                    .setNegativeButton("好的", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();

        }

    }

    private void showNormalDialog(){
        //创建dialog构造器
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(this);
        //设置title
        normalDialog.setTitle("title");
        //设置icon
        normalDialog.setIcon(R.mipmap.ic_launcher);
        //设置内容
        normalDialog.setMessage("this is content");
        //设置按钮
        normalDialog.setPositiveButton("confirm"
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(RecycleViewActivity.this,"confirm"
                                ,Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

        //创建并显示
        normalDialog.create().show();
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
                Toast.makeText(getApplicationContext(), "list", Toast.LENGTH_LONG).show();
                //设置布局管理
                mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                mRecycleview.setLayoutManager(mLayoutManager);
                return true;
            case R.id.menu_gridview:
                Toast.makeText(getApplicationContext(), "grid", Toast.LENGTH_LONG).show();
                //设置布局管理
                mLayoutManager = new GridLayoutManager(this, 3);
                mRecycleview.setLayoutManager(mLayoutManager);
                return true;
            case R.id.menu_staggaredgridview:
                Toast.makeText(getApplicationContext(), "staggaredgridview", Toast.LENGTH_LONG).show();
                int spanCount = 2;

                mLayoutManager = new StaggeredGridLayoutManager(
                        spanCount,
                        StaggeredGridLayoutManager.VERTICAL);
                mRecycleview.setLayoutManager(mLayoutManager);
                return true;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolBar() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle(R.string.app_name);
//        toolbar.setTitleTextColor(Color.parseColor(getResources().getColor(R.color.app_theme_color)));
        toolbar.collapseActionView();
//        toolbar.setBackground(getResources().getDrawable(R.drawable.skin2));
        setSupportActionBar(toolbar);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TestInstance.i();
                openOrCloseDrawer();
            }
        });
    }

    private void openOrCloseDrawer() {
        if (mDrawerLayout.isDrawerOpen(navigationView)) {
            mDrawerLayout.closeDrawer(navigationView);
        } else {
            mDrawerLayout.openDrawer(navigationView);
        }
    }

}
