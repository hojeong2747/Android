package ddwu.mobile.week07.menutest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuAdapter;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean checkStatus[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //context menu등록한다. 롱탭 시 자동 호출된다. 밑의 함수가
        TextView textView = findViewById(R.id.textView);
        registerForContextMenu(textView);

        checkStatus = new boolean[] {false, false};
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            //이렇게 case를 나누는 이유는 textView가 여러 개인데
            //어떤 것은 menu띄우고 어떤 것은 안 띄우게 하고 싶을 수 있고
            //또 다른 것은 다른 모양의 메뉴를 띄우고 싶을 수 있다. 구분 해야함!
            //메뉴 만드는 방법은 같다.
            case R.id.textView:
                getMenuInflater().inflate(R.menu.activity_menu, menu);
                break;
        }
        //메뉴가 만들어지고, v 객체에 textView가 들어왔다면 이 xml 형식을 이용해서 메뉴를 만든다.
        //근데 context menu는 내가 context menu다 라고 등록해야 한다.
        //앱이 실행될 때 미리 준비가 다 되어 있어야 하므로 onCreate에서 등록한다.
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item01:
                Toast.makeText(this, "context click!!", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item01:
                Toast.makeText(this, "Menu Click!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.subitem01:
                if (item.isChecked()) {
                    item.setChecked(false); //화면에 체크 상태 유지
                    checkStatus[0] = false; //실제 체크된 것 코드에서 확인하면서 작업하고자 할 때
                } else {
                    item.setChecked(true);
                    checkStatus[0]=true;
                }
                break;
            case R.id.subitem02:

                break;
        }
        return true;
    }

//    public void onMenuClick(MenuItem item) {
//        Toast.makeText(this, "Sub01 Click!!", Toast.LENGTH_SHORT).show();
//    }
}