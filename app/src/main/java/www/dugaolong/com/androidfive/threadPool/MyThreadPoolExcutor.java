package www.dugaolong.com.androidfive.threadPool;

import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dugaolong on 18/1/21.
 */

public class MyThreadPoolExcutor extends ThreadPoolExecutor {
    public MyThreadPoolExcutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    //在这些方法中还可以1添加日志、2计时、3监视或者4统计信息收集的功能
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        Log.v("beforeExecute", "线程：" + t.getName() + "准备执行任务！");
    }
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        Log.v("zxy", "线程：" +Thread.currentThread().getName()  + "任务执行结束！");
    }
}
