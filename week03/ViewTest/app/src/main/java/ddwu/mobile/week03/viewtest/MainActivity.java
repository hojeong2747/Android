package ddwu.mobile.week03.viewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

//        TextView textView = findViewById(R.id.my_text);
//        textView.setText("한호정");
    }

    public void onMyClick (View v) {

//        취소,확인 버튼 구분 위해 추가. 근데 보통 switch로 많이 쓴다. 보통 아이디가 상수.

//        EditText editText = findViewById(R.id.editText);

        switch (v.getId()) {
            case R.id.btn_ok:
                String str = editText.getText().toString();
                Toast.makeText( this, str, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_cancel:
                editText.setText("");
                break;
        }

//        버튼 누르면 먼저 입력 값의 객체를 찾아야 한다. 가져와서 객체에 저장해야 하는데
//        어디에 저장해야 하는가?
//        EditText editText = findViewById(R.id.editText);

//        글자를 가져와야 한다.
//        String str = editText.getText().toString();


//        Toast.makeText( this, str, Toast.LENGTH_SHORT).show();


    }

}