package ddwu.mobile.week07.lab02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCircle extends View {
    int cnt = 0;
    int r = 100;
    int color;

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public MyCircle(Context context, int color) {
        super(context);
        setColor(Color.RED);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int color) {
        super(context, attrs);
        setColor(Color.RED);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int color) {
        super(context, attrs, defStyleAttr);
        setColor(Color.RED);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, int color) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setColor(Color.RED);
    }

    public void onDraw(Canvas canvas) {
        if(cnt >= 1) {
            Paint paint = new Paint();
            paint.setColor(color);
            canvas.drawCircle(500, 500, getR(), paint);
        }
        cnt++;
    }
}
