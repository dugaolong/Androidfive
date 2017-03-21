package www.dugaolong.com.androidfive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangjitao on 2016/3/7.
 */
public class MyFragmentFour extends Fragment {

    public MyFragmentFour(){
 
    }
 
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
 
        return inflater.inflate(R.layout.fragment_four, container, false);
    }
}