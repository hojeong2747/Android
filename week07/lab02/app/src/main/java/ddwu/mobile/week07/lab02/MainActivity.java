package ddwu.mobile.week07.lab02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Custom View 객체*/
        MyCircle myCircle = findViewById(R.id.myCircle);
        //롱탭시 context menu 뜨도록 한다. myview 등록
        registerForContextMenu(myCircle);
    }

    //options menu
    //메뉴 만드는 코드 이 메소드에서 구현한다.
    //빈 메뉴에 내가 만든 xml 메뉴 inflate 하면서 넣어준다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu_size, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //롱탭 시 context menu 만드는 코드
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
/*        switch (v.getId()) {
            case R.id.myCircle:
                getMenuInflater().inflate(R.menu.activity_menu_color, menu);
                break;
        }*/
        super.onCreateContextMenu (menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_menu_color, menu);
    }

    //롱탭 시 context menu 나와서 그 항목 선택 처리
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        MyCircle myCircle = findViewById(R.id.myCircle);

        switch (item.getItemId()) {
            case R.id.item01:
                myCircle.setColor(Color.RED);
                myCircle.invalidate();
                break;
            case R.id.item02:
                myCircle.setColor(Color.GREEN);
                myCircle.invalidate();
                break;
            case R.id.item03:
                myCircle.setColor(Color.BLUE);
                myCircle.invalidate();
                break;
        }
        return super.onContextItemSelected(item);
    }

    //options menu 사용(항목 선택 처리)
    //메뉴를 선택했을 때 호출하는 메소드에 id로 구분해서 item을 처리한다.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        MyCircle myCircle = findViewById(R.id.myCircle);
        switch (item.getItemId()) {
            case R.id.item_bigger:
                myCircle.setR(myCircle.getR()+50);
                myCircle.invalidate();
                break;
            case R.id.item_smaller:
                myCircle.setR(myCircle.getR()-50);
                myCircle.invalidate();
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}