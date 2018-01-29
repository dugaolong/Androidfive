package www.dgl.com.androidfive;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 17/3/21.
 */

public class TabLayoutActivity extends AppCompatActivity {
    public static final String TAG = "TabLayoutActivity";
    private TabLayout mTabLayout ;
    private ViewPager mViewPager ;

    private List<Fragment> list_Fragments ;
    private List<String> list_Titles ;

    private MyAdapter mMyAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);
        initView();
        initData();
    }

    private void initData() {
        list_Fragments = new ArrayList<>();
        list_Titles = new ArrayList<>();

        list_Fragments.add(new MyFragmentOne());
        list_Fragments.add(new MyFragmentTwo());
        list_Fragments.add(new MyFragmentThree());
        list_Fragments.add(new MyFragmentFour());
        list_Fragments.add(new MyFragmentFive());
        list_Fragments.add(new MyFragmentSix());
        list_Fragments.add(new MyFragmentSeven());
        list_Fragments.add(new MyFragmentEight());

        list_Titles.add("精品推荐");
        list_Titles.add("最近新闻");
        list_Titles.add("精彩视频");
        list_Titles.add("gif图片");
        list_Titles.add("新浪体育");
        list_Titles.add("搜狐娱乐");
        list_Titles.add("凤凰财经");
        list_Titles.add("腾讯科技");

        mMyAdapter = new MyAdapter(getSupportFragmentManager(),list_Fragments,list_Titles);
        mViewPager.setAdapter(mMyAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initView() {
        mTabLayout = (TabLayout)findViewById(R.id.tablayout);
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

}
