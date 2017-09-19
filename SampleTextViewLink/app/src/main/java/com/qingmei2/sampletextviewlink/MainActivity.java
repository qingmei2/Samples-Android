package com.qingmei2.sampletextviewlink;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tvContent);

        final SpannableStringBuilder style = new SpannableStringBuilder();

        //设置文字
        style.append("关于本活动更多规则，请点我查看");

        //设置部分文字点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "触发点击事件!", Toast.LENGTH_SHORT).show();
            }
        };
        style.setSpan(clickableSpan, 11, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(style);

        //改变部分文字颜色
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#0000FF"));
        style.setSpan(foregroundColorSpan, 11, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setMovementMethod(LinkMovementMethod.getInstance());
        tv.setText(style);
    }

}
