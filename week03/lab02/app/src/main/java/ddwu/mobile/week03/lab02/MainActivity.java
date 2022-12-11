package ddwu.mobile.week03.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        editText.setText("");
    }

    public void onMyClick (View v) {
        switch (v.getId()) {
            case R.id.btnOne:
                editText.setText(editText.getText().toString() + "1");
                break;
            case R.id.btnTwo:
                editText.setText(editText.getText().toString() + "2");
                break;
            case R.id.btnThree:
                editText.setText(editText.getText().toString() + "3");
                break;
            case R.id.btnClear:
                editText.setText("");
                break;
        }
    }
}