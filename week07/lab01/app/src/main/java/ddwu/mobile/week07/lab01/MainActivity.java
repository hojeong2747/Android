package ddwu.mobile.week07.lab01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item01_1:
                Toast.makeText(this,"chobab goood!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item01_2:
                Toast.makeText(this,"lamen delicious!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item02_1:
                Toast.makeText(this,"i love pasta!!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item02_2:
                Toast.makeText(this,"subway so good!!",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}