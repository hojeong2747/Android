package ddwu.mobile.week04.lab02;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etDisplay;
    String num1, num2;
    int no1, no2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDisplay = findViewById(R.id.etDisplay);
        etDisplay.setText("");
    }

    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                etDisplay.setText(etDisplay.getText().toString() + "1");
                break;
            case R.id.btn_2:
                etDisplay.setText(etDisplay.getText().toString() + "2");
                break;
            case R.id.btn_plus:
                num1 = etDisplay.getText().toString();
                no1 = Integer.parseInt(num1);
                etDisplay.setText("");
                break;
            case R.id.btn_equal:
                num2 = etDisplay.getText().toString();
                no2 = Integer.parseInt(num2);
                int rslt = no1 + no2;
                etDisplay.setText(Integer.toString(rslt));
                break;
        }
    }


}