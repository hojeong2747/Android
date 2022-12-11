package ddwucom.mobile.test12.exam02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    EditText etFood;
    EditText etNation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        etFood = findViewById(R.id.et_food_name);
        etNation = findViewById(R.id.et_nation);
    }

    public void onClick(View view) {
//        버튼의 종류에 따라 결과 설정 후 finish()
        switch (view.getId()) {
            case R.id.btn_add:
                String food = etFood.getText().toString();
                String nation = etNation.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_data", new Food(food, nation));
                setResult(RESULT_OK, resultIntent);
                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}

