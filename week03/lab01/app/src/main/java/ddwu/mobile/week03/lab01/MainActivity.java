package ddwu.mobile.week03.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etMyName;
    EditText etMyPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMyName = findViewById(R.id.etMyName);
        etMyPhone = findViewById(R.id.etMyPhone);
    }

    public void onMyClick (View v) {

        switch (v.getId()) {
            case R.id.btnHello:
                String str1 = etMyName.getText().toString();
                String str2 = etMyPhone.getText().toString();
                String rslt = "안녕하세요, 저는 " + str1 + "입니다.\n" +
                                "전화번호는 " + str2 + "입니다.\n";
                Toast.makeText( this, rslt, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnExit:
                finish();
                break;
        }
    }

}