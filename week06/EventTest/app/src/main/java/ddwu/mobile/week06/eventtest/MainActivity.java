package ddwu.mobile.week06.eventtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
//    1) 멤버변수로 만들어야 한다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        2) 상수로 만들어 사용한다.
//        final TextView textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                textView.setText("Mobile Software");
                return true;
            }
        });
    }
}
    //    에러가 뜬다. textView에.
//    textView는 화면에서 만들어진 텍스트뷰를 갖고 온 객체다. onCreate으로 만들어진 지역변수다.
//    onCreate이 실행되면 만들어지고 끝나면 사라진다.
//    나중에 longclick을 하면 textView는 존재하지 않는다. 지역변수는 쓸 수 없다.
//    textView를 옮기던지 사용할 수 있는 방법이 있어야 한다.
//    View.OnLongClickListener longClick = new View.OnLongClickListener() {
//        @Override
//        public boolean onLongClick(View view) {
//            textView.setText("Mobile Software");
//            return true;
//        }
//    };
//}


//        터치 이벤트는 세가지 종류로 나눠서 볼 수 있다.
//        View.OnTouchListener myTouch = new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                motionevent로 3가지 터치 구분할 수 있다.

                // 상태 알 수 있다.
//                motionEvent.getAction() == MotionEvent.ACTION_DOWN

                //좌표 값을 할 수 있다.
//                motionEvent.getX()

//                return false;
//            }
//        }



//        Button button = findViewById(R.id.button);
//        MyClick myClick = new MyClick();
//        버튼과 마이클릭을 연결한다.
//        클릭 기능 구현한 마이클래스 객체에 연결한다.
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "2.5 Click!!!", Toast.LENGTH_SHORT).show();
//            }
//        } );
//    }




    //    클릭했을 때 동작하도록 하는 클래스 만든다.
//
//    class MyClick implements View.OnClickListener {
//  alt enter 하면 onClick 나오고 추가 되고 에러 없어진다.

//        @Override
//        public void onClick(View view) {
//            Toast.makeText(MainActivity.this, "Click!!!", Toast.LENGTH_SHORT).show();
//            this라고 하면 Myclick이 된다. 근데 mainactivity를 넣어야 한다.
//            정확하게 어떤 클래스인지 적어야 한다.
//            여기까지 하면 아직 버튼과 연결이 안 되어 있다. onCreate에서.
//        }
//    }
//
// 원래 안 되지만 만드는 시점에 만들면 객체 생성 가능하다. 동일 타입 변수에 보관.
//    View.OnClickListener myInterfaceClick = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(MainActivity.this, "Interface Click!!!", Toast.LENGTH_SHORT).show();
//        }
//    };
//    ;이 끝에 붙는다.

//}