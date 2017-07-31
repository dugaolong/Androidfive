package www.dugaolong.com.androidfive.charts;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

import www.dugaolong.com.androidfive.R;

import static www.dugaolong.com.androidfive.R.layout.chart;

/**
 * Created by dugaolong on 17/5/31.
 */

public class ChartsAcitivty extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(chart);

        LineChart chart = (LineChart) findViewById(R.id.line_chart);
        ChartData chartData = new ChartData() {
            @Override
            protected void init() {
                super.init();
            }

            @Override
            public void notifyDataChanged() {
                super.notifyDataChanged();
            }

            @Override
            public void calcMinMax(int start, int end) {
                super.calcMinMax(start, end);
            }

            @Override
            protected void calcYValueSum() {
                super.calcYValueSum();
            }

            @Override
            protected void calcYValueCount() {
                super.calcYValueCount();
            }

            @Override
            public int getDataSetCount() {
                return super.getDataSetCount();
            }

            @Override
            public float getAverage() {
                return super.getAverage();
            }

            @Override
            public float getYMin() {
                return super.getYMin();
            }

            @Override
            public float getYMin(YAxis.AxisDependency axis) {
                return super.getYMin(axis);
            }

            @Override
            public float getYMax() {
                return super.getYMax();
            }

            @Override
            public float getYMax(YAxis.AxisDependency axis) {
                return super.getYMax(axis);
            }

            @Override
            public float getXValAverageLength() {
                return super.getXValAverageLength();
            }

            @Override
            public float getYValueSum() {
                return super.getYValueSum();
            }

            @Override
            public int getYValCount() {
                return super.getYValCount();
            }

            @Override
            public List<String> getXVals() {
                return super.getXVals();
            }

            @Override
            public void addXValue(String xVal) {
                super.addXValue(xVal);
            }

            @Override
            public void removeXValue(int index) {
                super.removeXValue(index);
            }

            @Override
            public List getDataSets() {
                return super.getDataSets();
            }

            @Override
            protected int getDataSetIndexByLabel(List dataSets, String label, boolean ignorecase) {
                return super.getDataSetIndexByLabel(dataSets, label, ignorecase);
            }

            @Override
            public int getXValCount() {
                return super.getXValCount();
            }

            @Override
            protected String[] getDataSetLabels() {
                return super.getDataSetLabels();
            }

            @Override
            public Entry getEntryForHighlight(Highlight highlight) {
                return super.getEntryForHighlight(highlight);
            }

            @Override
            public DataSet<? extends Entry> getDataSetByLabel(String label, boolean ignorecase) {
                return super.getDataSetByLabel(label, ignorecase);
            }

            @Override
            public DataSet<? extends Entry> getDataSetByIndex(int index) {
                return super.getDataSetByIndex(index);
            }

            @Override
            public void addDataSet(DataSet d) {
                super.addDataSet(d);
            }

            @Override
            public boolean removeDataSet(DataSet d) {
                return super.removeDataSet(d);
            }

            @Override
            public boolean removeDataSet(int index) {
                return super.removeDataSet(index);
            }

            @Override
            public void addEntry(Entry e, int dataSetIndex) {
                super.addEntry(e, dataSetIndex);
            }

            @Override
            public boolean removeEntry(Entry e, int dataSetIndex) {
                return super.removeEntry(e, dataSetIndex);
            }

            @Override
            public boolean removeEntry(int xIndex, int dataSetIndex) {
                return super.removeEntry(xIndex, dataSetIndex);
            }

            @Override
            public DataSet<? extends Entry> getDataSetForEntry(Entry e) {
                return super.getDataSetForEntry(e);
            }

            @Override
            public int[] getColors() {
                return super.getColors();
            }

            @Override
            public int getIndexOfDataSet(DataSet dataSet) {
                return super.getIndexOfDataSet(dataSet);
            }

            @Override
            public DataSet<? extends Entry> getFirstLeft() {
                return super.getFirstLeft();
            }

            @Override
            public DataSet<? extends Entry> getFirstRight() {
                return super.getFirstRight();
            }

            @Override
            public void setValueFormatter(ValueFormatter f) {
                super.setValueFormatter(f);
            }

            @Override
            public void setValueTextColor(int color) {
                super.setValueTextColor(color);
            }

            @Override
            public void setValueTypeface(Typeface tf) {
                super.setValueTypeface(tf);
            }

            @Override
            public void setValueTextSize(float size) {
                super.setValueTextSize(size);
            }

            @Override
            public void setDrawValues(boolean enabled) {
                super.setDrawValues(enabled);
            }

            @Override
            public void setHighlightEnabled(boolean enabled) {
                super.setHighlightEnabled(enabled);
            }

            @Override
            public boolean isHighlightEnabled() {
                return super.isHighlightEnabled();
            }

            @Override
            public void clearValues() {
                super.clearValues();
            }

            @Override
            public boolean contains(Entry e) {
                return super.contains(e);
            }

            @Override
            public boolean contains(DataSet dataSet) {
                return super.contains(dataSet);
            }
        };
        //上面右边效果图的部分代码，设置X轴
        XAxis xAxis = chart.getXAxis();
        //X轴文字
        xAxis.setTextColor(Color.BLUE);
        xAxis.setTextSize(24f);
        //X轴网格线
        xAxis.setGridLineWidth(10f);
        xAxis.setGridColor(Color.RED);
        //X轴线
//        xAxis.setAxisLineColor(Color.GREEN);
//        xAxis.setAxisLineWidth(5f);
        // 制作7个数据点（沿x坐标轴）
        LineData mLineData = makeLineData(7);
        setChartStyle(chart, mLineData, Color.WHITE);
    }

    /**
     * @param count
     *            数据点的数量。
     * @return
     */
    private LineData makeLineData(int count) {
        ArrayList<String> x = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            // x轴显示的数据
            x.add("x:" + i);
        }

        // y轴的数据
        ArrayList<Entry> y = new ArrayList<Entry>();
        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * 100);
            Entry entry = new Entry(val, i);
            y.add(entry);
        }

        // y轴数据集
        LineDataSet mLineDataSet = new LineDataSet(y, "测试数据集。by ZhangPhil");

        // 用y轴的集合来设置参数
        // 线宽
        mLineDataSet.setLineWidth(3.0f);

        // 显示的圆形大小
        mLineDataSet.setCircleSize(5.0f);

        // 折线的颜色
        mLineDataSet.setColor(Color.DKGRAY);

        // 圆球的颜色
        mLineDataSet.setCircleColor(Color.GREEN);

        // 设置mLineDataSet.setDrawHighlightIndicators(false)后，
        // Highlight的十字交叉的纵横线将不会显示，
        // 同时，mLineDataSet.setHighLightColor(Color.CYAN)失效。
        mLineDataSet.setDrawHighlightIndicators(true);

        // 按击后，十字交叉线的颜色
        mLineDataSet.setHighLightColor(Color.CYAN);

        // 设置这项上显示的数据点的字体大小。
        mLineDataSet.setValueTextSize(10.0f);

        // mLineDataSet.setDrawCircleHole(true);

        // 改变折线样式，用曲线。
        // mLineDataSet.setDrawCubic(true);
        // 默认是直线
        // 曲线的平滑度，值越大越平滑。
        // mLineDataSet.setCubicIntensity(0.2f);

        // 填充曲线下方的区域，红色，半透明。
        // mLineDataSet.setDrawFilled(true);
        // mLineDataSet.setFillAlpha(128);
        // mLineDataSet.setFillColor(Color.RED);

        // 填充折线上数据点、圆球里面包裹的中心空白处的颜色。
        mLineDataSet.setCircleColorHole(Color.YELLOW);

        // 设置折线上显示数据的格式。如果不设置，将默认显示float数据格式。
        mLineDataSet.setValueFormatter(new ValueFormatter() {

            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                int n = (int) value;
                String s = "y:" + n;
                return s;
            }

        });

        ArrayList<LineDataSet> mLineDataSets = new ArrayList<LineDataSet>();
        mLineDataSets.add(mLineDataSet);

        LineData mLineData = new LineData(x, mLineDataSets);

        return mLineData;
    }

    // 设置chart显示的样式
    private void setChartStyle(LineChart mLineChart, LineData lineData,
                               int color) {
        // 是否在折线图上添加边框
        mLineChart.setDrawBorders(false);

        mLineChart.setDescription("描述@ZhangPhil");// 数据描述

        // 如果没有数据的时候，会显示这个，类似listview的emtpyview
        mLineChart
                .setNoDataTextDescription("如果传给MPAndroidChart的数据为空，那么你将看到这段文字。@Zhang Phil");

        // 是否绘制背景颜色。
        // 如果mLineChart.setDrawGridBackground(false)，
        // 那么mLineChart.setGridBackgroundColor(Color.CYAN)将失效;
        mLineChart.setDrawGridBackground(false);
        mLineChart.setGridBackgroundColor(Color.CYAN);

        // 触摸
        mLineChart.setTouchEnabled(true);

        // 拖拽
        mLineChart.setDragEnabled(true);

        // 缩放
        mLineChart.setScaleEnabled(true);

        mLineChart.setPinchZoom(false);

        // 设置背景
        mLineChart.setBackgroundColor(color);

        // 设置x,y轴的数据
        mLineChart.setData(lineData);

        // 设置比例图标示，就是那个一组y的value的
        Legend mLegend = mLineChart.getLegend();

        mLegend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        mLegend.setForm(Legend.LegendForm.CIRCLE);// 样式
        mLegend.setFormSize(15.0f);// 字体
        mLegend.setTextColor(Color.BLUE);// 颜色

        // 沿x轴动画，时间2000毫秒。
        mLineChart.animateX(2000);
    }

}
