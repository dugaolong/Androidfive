package www.dugaolong.com.androidfive.charts;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

import www.dugaolong.com.androidfive.R;

/**
 * Created by dugaolong on 17/6/2.
 *  MPAndroidChart比较复杂的部分在于绘制图表的数据源的数据结构。
 * 通常，在一个二位的坐标体系内，一个任意的坐标点应包含（x,y）这样的对应数据点。
 * 一般模型是在x坐标轴的x-i位置，y存在一个对应的y-i值对应，形成坐标点（i-x，i-y）
 * MPAndroidChart在一定角度上将x轴的数据集处理成（i，字符标签）的简单模式，
 * 但MPAndroidChart对于y轴的数据集整合成复杂的复合体。初级，y轴的Entry包含（x，y）这样的坐标点数据。
 * 比如，在坐标点（xi，yi）的位置绘制数据点，那么在MPAndroidChart中，
 * 在x轴的i位置绘制字符串表示是x坐标轴的数值，
 * 然后构造y坐标轴的Entry，Entry包含（value，i）
 *
 */

public class PieChartActivity extends Activity {

    private PieChart mChart;
    private String[] x = new String[] { "习悦", "蝉鸣", "知了" };

    // 凑成100 % 100
    private float[] y = { 10f, 60f, 30f };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.piechart);

        mChart = (PieChart) findViewById(R.id.chart);

        // 图的描述
        mChart.setDescription("by dgl @ http://blog.csdn.net/zhangphil");

        // 以3个对应数据集做测试
        setData(x.length);
    }

    private void setData(int count) {

        // 准备x"轴"数据：在i的位置，显示x[i]字符串
        ArrayList<String> xVals = new ArrayList<String>();

        // 真实的饼状图百分比分区。
        // Entry包含两个重要数据内容：position和该position的数值。
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for (int xi = 0; xi < count; xi++) {
            xVals.add(xi, x[xi]);

            // y[i]代表在x轴的i位置真实的百分比占
            yVals.add(new Entry(y[xi], xi));
        }

        PieDataSet yDataSet = new PieDataSet(yVals, "百分比占");

        // 每个百分比占区块绘制的不同颜色
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.BLUE);
        colors.add(Color.LTGRAY);
        colors.add(Color.RED);
        yDataSet.setColors(colors);

        // 将x轴和y轴设置给PieData作为数据源
        PieData data = new PieData(xVals, yDataSet);

        // 设置成PercentFormatter将追加%号
        data.setValueFormatter(new PercentFormatter());

        // 文字的颜色
        data.setValueTextColor(Color.BLACK);

        // 最终将全部完整的数据喂给PieChart
        mChart.setData(data);
        mChart.invalidate();
    }
}
