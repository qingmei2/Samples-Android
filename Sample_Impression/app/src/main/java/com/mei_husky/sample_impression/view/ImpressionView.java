package com.mei_husky.sample_impression.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mei_husky.sample_impression.MyUtils;
import com.mei_husky.sample_impression.R;

/**
 * Created by QingMei on 2017/1/15 11:39
 * email:mei_husky@qq.com
 * desc:Used to
 */

public class ImpressionView extends RelativeLayout implements View.OnClickListener {

    private Context ctx;
    private TextView mCardContent;
    private LinearLayout mBtRemove;
    private CardView mCardBg;

    public ImpressionView(Context context) {
        super(context);
        init(context);
    }

    public ImpressionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /**
     * 初始化控件
     */
    private void init(Context context) {
        this.ctx = context;
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_impression, this);
        mCardContent= (TextView) findViewById(R.id.card_content);
        mCardBg=(CardView) findViewById(R.id.card_bg);
        mBtRemove=(LinearLayout) findViewById(R.id.bt_remove);
        mBtRemove.setOnClickListener(this);
    }



    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        super.onLayout(b,i,i1,i2,i3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 设置背景色
     * @param color
     */
    public void setBgColor(int color){
        mCardBg.setCardBackgroundColor(color);
    }

    /**
     * 设置文字颜色
     * @param text
     */
    public void setBgText(String text){
        mCardContent.setText(text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_remove:
                if(listener!=null){
                    listener.onClick(mBtRemove);
                }
                break;
        }
    }

    private OnClickListener  listener;

    /**
     * 用户点击cancle按钮触发事件
     */
    public void setOnCheckCancleButton(View.OnClickListener listener) {
        this.listener=listener;
    }
}
