package com.haier.cellarette.baselibrary.emptyview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.haier.cellarette.baselibrary.R;

public class EmptyViewMainActivity extends AppCompatActivity implements View.OnClickListener {

    private EmptyView mEmptyView;
    private LinearLayout containlayout;
    private TextView tv1, tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        mEmptyView = (EmptyView) findViewById(R.id.empty_view);
//        mEmptyView.setIs_an(1);
        containlayout = (LinearLayout) findViewById(R.id.containlayout);
//        mEmptyView.notices("暂无酒品", "获取数据失败\n请检查网络是否通畅", "loading...", "");//提供自定义文字 默认可不传
        mEmptyView.bind(containlayout).setRetryListener(new EmptyView.RetryListener() {
            @Override
            public void retry() {
                //重试
                mEmptyView.loading();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //加载数据
                        mEmptyView.success();
                    }
                }, 3000);
            }
        });

//        mEmptyView.getmNodataLayout().findViewById(R.id.empty_nodata_notice).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //重试
//                mEmptyView.loading();
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        //加载数据
//                        mEmptyView.success();
//                    }
//                }, 3000);
//            }
//        });
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
        tv5.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tv1) {
            mEmptyView.loading();

        } else if (i == R.id.tv2) {
            mEmptyView.errorNet();

        } else if (i == R.id.tv3) {
            mEmptyView.nodata();

        } else if (i == R.id.tv4) {
            mEmptyView.success();

        } else if (i == R.id.tv5) {
//            startActivity(new Intent(EmptyViewMainActivity.this, EmptyViewMainActivity.class));

        } else {
        }
    }
}
