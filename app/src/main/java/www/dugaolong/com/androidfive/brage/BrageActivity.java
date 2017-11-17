package www.dugaolong.com.androidfive.brage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import www.dugaolong.com.androidfive.R;

/**
 * Created by wangtao on 2017/11/17.
 */

public class BrageActivity extends Activity {
    private Handler handler = new Handler();

    private Runnable runnable = new MyRunnable();

    public class MyRunnable implements Runnable {

        @Override
        public void run() {
            handler.postDelayed(runnable, 5000);
            BadgeUtil.setBadgeCount(getApplicationContext(), getCount(), R.mipmap.ic_launcher);
        }
    }

    private int getCount() {

        return new Random().nextInt(100);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button start = (Button) findViewById(R.id.button);
        Button stop = (Button) findViewById(R.id.button2);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (handler == null) {
                    handler = new Handler();
                }

                if (runnable == null) {
                    runnable = new MyRunnable();
                }

                handler.post(runnable);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (handler != null) {
                    BadgeUtil.resetBadgeCount(getApplicationContext(), R.mipmap.ic_launcher);
                    handler.removeCallbacksAndMessages(null);
                    runnable = null;
                    handler = null;
                }
            }
        });
    }
}
