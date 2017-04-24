package com.mei_husky.sampleneterrorutil.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mei_husky.sampleneterrorutil.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mBtnShow;
    private ImageView mIvSuccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {
        mBtnShow = (Button) findViewById(R.id.btn_show);
        mIvSuccess = (ImageView) findViewById(R.id.iv_success);

        mBtnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show:
                showAnimator();
                break;
        }
    }

    private void showAnimator() {
        Log.i("tag","加载动画");

        try {
            Glide
                    .with(this)
                    .load(R.raw.anim_success)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                .asGif()
                    .into(mIvSuccess);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
