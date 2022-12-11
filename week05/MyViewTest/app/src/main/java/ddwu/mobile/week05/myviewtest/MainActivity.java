package ddwu.mobile.week05.myviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyView myview = new MyView(this);
//        setContentView(myview);

    }

    public void onClick(View v) {
//        색 바꾸기. 바꾸자 하는 뷰를 먼저 찾는다. id 자동부여되어있고, 찾는다.
        MyCustomView myCustomView = findViewById(R.id.myCustomView);

        myCustomView.setColor(Color.YELLOW);
        myCustomView.invalidate();
    }



//    class MyView extends View {
//        public MyView(Context context) {
//            super(context);
//        }
//
//        protected void onDraw(Canvas canvas) {
//            super.onDraw(canvas);
//            canvas.drawColor(Color.LTGRAY);
//            Paint pnt = new Paint();
//            pnt.setColor(Color.BLUE);
//            canvas.drawCircle(100,100,80,pnt);
//        }
//    }
}