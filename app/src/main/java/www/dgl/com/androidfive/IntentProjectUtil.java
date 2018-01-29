/**
 * Copyright (C) 2014 Guangzhou QTONE Technologies Ltd.
 * <p/>
 * 本代码版权归广州全通教育股份有限公司所有，且受到相关的法律保护。没有经过版权所有者的书面同意，
 * 任何其他个人或组织均不得以任何形式将本文件或本文件的部分代码用于其他商业用途。
 *
 * @date 2015-2-28 下午6:15:39
 * @version V1.0
 */
package www.dgl.com.androidfive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

/**
 *
 *
 * @ClassName IntentProjectUtil
 * @author 黄培桂
 * @date 2015-2-28 下午6:15:39  
 */
public class IntentProjectUtil {


    public static StringBuilder getActionName(Activity activity, String name) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("menu" + name);
        return stringBuilder;
    }

    public static void startActivityByActionName(Activity activity, String name, Bundle mbundle) {
        StringBuilder stringBuilder = getActionName(activity, name);
        Intent intent = new Intent(stringBuilder.toString());
        if (mbundle != null) {
            intent.putExtras(mbundle);
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }


    public static void startActivityByActionName(Activity activity, String name) {
        StringBuilder stringBuilder = getActionName(activity, name);
        Intent intent = new Intent(stringBuilder.toString());
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void startActivityByActionNameForResult(Activity activity, String name, int requestCode) {
        StringBuilder stringBuilder = getActionName(activity, name);
        Intent intent = new Intent(stringBuilder.toString());
        activity.startActivityForResult(intent, requestCode);
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void startActivityByActionNameForResult(Activity activity, String name, int requestCode, Bundle mbundle) {
        StringBuilder stringBuilder = getActionName(activity, name);
        Intent intent = new Intent(stringBuilder.toString());
        intent.putExtras(mbundle);
        activity.startActivityForResult(intent, requestCode);
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void startActivityByActionNameSeries(Activity activity, String name, String key, Serializable serializable) {
        StringBuilder stringBuilder = getActionName(activity, name);
        Intent intent = new Intent(stringBuilder.toString());
        intent.putExtra(key, serializable);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void startActivityByActionNameStringValue(Activity activity, String name, String key1, int value1, String key2, String[] value2) {
        StringBuilder stringBuilder = getActionName(activity, name);
        Intent intent = new Intent(stringBuilder.toString());
        intent.putExtra(key1, value1);
        intent.putExtra(key2, value2);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public static void startActivityByActionNameStringValue(Activity activity, String name, String key, String value) {
        StringBuilder stringBuilder = getActionName(activity, name);
        Intent intent = new Intent(stringBuilder.toString());
        intent.putExtra(key, value);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

}
