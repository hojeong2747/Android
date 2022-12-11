package ddwu.mobile.finalreport.finalreport_02_20201030;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnExit:
                finish();
                break;
        }
    }
}