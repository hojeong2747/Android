package ddwu.mobile.week05.myviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyCustomView extends View {

    int color;

    public MyCustomView(Context context) {
        super(context);
        color = Color.RED;
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        color = Color.RED;
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        color = Color.RED;
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        color = Color.RED;
    }

//    color에 대한 getter/setter 추가
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }



    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.LTGRAY);
        Paint pnt = new Paint();
        pnt.setColor(color);

        canvas.drawCircle(100,100,80,pnt);
        canvas.drawRect(300,300,500,500, pnt);
    }
}
