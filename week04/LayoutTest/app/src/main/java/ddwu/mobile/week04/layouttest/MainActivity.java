package ddwu.mobile.week04.layouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        여기 이름을 바꿔도 되는데, 지금은 파일 이름을 바꿨다.



//        LinearLayout linear = new LinearLayout(this);
//        linear.setOrientation(LinearLayout.VERTICAL);
//        linear.setBackgroundColor(Color.LTGRAY);
//
//        TextView text = new TextView(this);
//        text.setText("TextView");
//        text.setGravity(Gravity.CENTER);
//        text.setTextColor(Color.RED);
//        text.setTextSize(20);
//
//        linear.addView(text);
//        //text객체를 linear객체에 넣는다.
//        //여기까지만 하면 linear는 화면에 나오지 않고
//        //메모리상으로만 있는 것이다.
//
//        setContentView(linear);
//        //이걸 써야 화면에 나온다.



        //인플레이션 직접 한다
        //xml 가져와서 자바 객체 직접 만들고 넘겨 보자.
        //시스템에 요청하는 메소드를 이용한다.
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_main,null);

        setContentView(layout);
    }

    public void onClick (View v) {
        //버튼 구분할 필요 없다.
        //linearlayout을 찾아야 한다. id 있어야 바꾼다. layout.
        LinearLayout layout = findViewById(R.id.layout);

//        switch (layout.getOrientation()) {
//            case LinearLayout.HORIZONTAL:
//                layout.setOrientation(LinearLayout.VERTICAL);
//                break;
//            case LinearLayout.VERTICAL:
//                layout.setOrientation(LinearLayout.HORIZONTAL;
//                break;
//        }

        //orientation값을 바꾼다. 지정되어있는 값이므로 상수로 되어있다.
        //linearlayout 클래스에 상수로 정의되어 있다.
        layout.setOrientation(LinearLayout.HORIZONTAL);
    }
}