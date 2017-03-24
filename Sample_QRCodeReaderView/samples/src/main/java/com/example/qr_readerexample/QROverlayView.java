package com.example.qr_readerexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

/**
 * Created by fcd015 on 16/11/24.
 */
class QROverlayView extends View {

  public static final int COLOR_BG_GRAY= R.color.bk_black_bg_tran60;
  public static final int COLOR_BG_BLUE=R.color.bl01_blue_tran80;
  public static final int COLOR_BG_YELLOW=R.color.ye01_yellow_tran80;
  public static final int COLOR_BG_RED=R.color.re01_red_tran80;
  public int[] bgStateColors = new int[]{COLOR_BG_GRAY, COLOR_BG_BLUE, COLOR_BG_YELLOW, COLOR_BG_RED, COLOR_BG_RED};


  private final Paint paint = new Paint();

  private final float top;
  private final float left;
  private final float cornerH;
  private final float cornerW;

  private RectF viewFinderRect;

  public QROverlayView(Context context, AttributeSet attrs) {
    super(context, attrs);

    top = TypedValue.applyDimension(COMPLEX_UNIT_DIP, 28, getResources().getDisplayMetrics());
    left = TypedValue.applyDimension(COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
    cornerH = TypedValue.applyDimension(COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
    cornerW = TypedValue.applyDimension(COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
    paint.setColor(ContextCompat.getColor(getContext(), R.color.bk_black_bg_tran60));
  }

  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    viewFinderRect = new RectF(left, top, w - left, top + w - left * 2);
  }

  @Override
  protected void onDraw(Canvas canvas) {
    canvas.drawRect(0, 0, viewFinderRect.left, getHeight(), paint);
    canvas.drawRect(viewFinderRect.left, 0, getWidth(), viewFinderRect.top, paint);
    canvas.drawRect(viewFinderRect.right, viewFinderRect.top, getWidth(), getHeight(), paint);
    canvas.drawRect(viewFinderRect.left, viewFinderRect.bottom, viewFinderRect.right,
            getHeight(), paint);

    paint.setColor(ContextCompat.getColor(getContext(), R.color.corner_color));
    canvas.drawRect(viewFinderRect.left - cornerW, viewFinderRect.top - cornerW,
            viewFinderRect.left, viewFinderRect.top + cornerH - cornerW, paint);
    canvas.drawRect(viewFinderRect.left, viewFinderRect.top - cornerW,
            viewFinderRect.left + cornerH - cornerW, viewFinderRect.top, paint);
    canvas.drawRect(viewFinderRect.right - cornerH + cornerW, viewFinderRect.top - cornerW,
            viewFinderRect.right + cornerW, viewFinderRect.top, paint);
    canvas.drawRect(viewFinderRect.right, viewFinderRect.top, viewFinderRect.right + cornerW,
            viewFinderRect.top + cornerH - cornerW, paint);
    canvas.drawRect(viewFinderRect.right, viewFinderRect.bottom - cornerH + cornerW,
            viewFinderRect.right + cornerW, viewFinderRect.bottom + cornerW, paint);
    canvas.drawRect(viewFinderRect.right - cornerH + cornerW, viewFinderRect.bottom,
            viewFinderRect.right, viewFinderRect.bottom + cornerW, paint);
    canvas.drawRect(viewFinderRect.left - cornerW, viewFinderRect.bottom - cornerH + cornerW,
            viewFinderRect.left, viewFinderRect.bottom + cornerW, paint);
    canvas.drawRect(viewFinderRect.left, viewFinderRect.bottom,
            viewFinderRect.left + cornerH - cornerW, viewFinderRect.bottom + cornerW, paint);
  }

  public void setBackColorByState(int state){
    paint.setColor(getResources().getColor(bgStateColors[state]));
    Log.i("tag","paint.setcolor==" + state);
    invalidate();
  }

}
