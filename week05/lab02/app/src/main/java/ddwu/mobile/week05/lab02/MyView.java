package ddwu.mobile.week05.lab02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;

public class MyView extends View {

    Random random = new Random();

    int xValue = random.nextInt(500);
    int yValue = random.nextInt(800);
    int rValue = (random.nextInt(3)+1)*100;

    int check = 0;

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getxValue() {
        return xValue;
    }

    public void setxValue(int xValue) {
        this.xValue = xValue;
    }

    public int getyValue() {
        return yValue;
    }

    public void setyValue(int yValue) {
        this.yValue = yValue;
    }

    public int getrValue() {
        return rValue;
    }

    public void setrValue(int rValue) {
        this.rValue = rValue;
    }

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getCheck() == 0) {
            setCheck(1);
            canvas.drawColor(Color.YELLOW);
        }

        else if (getCheck() == 1) {
            canvas.drawColor(Color.YELLOW);
            Paint pnt = new Paint();
            pnt.setColor(Color.CYAN);

            setxValue(random.nextInt(500));
            setyValue(random.nextInt(800));
            setrValue((random.nextInt(3)+1)*100);

            canvas.drawCircle(getxValue(),getyValue(),getrValue(),pnt);
        }
    }

}
