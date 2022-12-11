package ddwucom.mobile.test13.exam01;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    FoodDBHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay); //화면 나오는 부분

        myDbHelper = new FoodDBHelper(this);
    }


    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSelect:
                //DB 얻어오는 작업
                SQLiteDatabase db = myDbHelper.getReadableDatabase();

                //Type1
                //select * from FoodDBHelper.TABLE_NAME
                //Type2
                Cursor cursor =
                        db.query(FoodDBHelper.TABLE_NAME, null, null, null,
                                null, null, null, null);

                //데이터를 꺼낸다
                String result = "";
                ArrayList<Food> list = new ArrayList<Food>();
                while (cursor.moveToNext()) {
                    long id = cursor.getInt(cursor.getColumnIndex(FoodDBHelper.COL_ID));
                    String foodName = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_FOOD));
                    String nation = cursor.getString(cursor.getColumnIndex(FoodDBHelper.COL_NATION));

                    //음식 하나에 대한 레코드를 저장한다. 객체 하나 만들어진다.
                    Food food = new Food(id, foodName, nation);
                    result += food.toString() + "\n";
                    list.add(food);
                }

                //main layout에 텍스트 보여지는 부분에 출력한다. 
                tvDisplay.setText(result);

                //마무리 close 작업
                cursor.close();
                myDbHelper.close();
                
                break;
            case R.id.btnAdd:
                Intent addIntent = new Intent(this, AddActivity.class);
                startActivity(addIntent);
                break;
            case R.id.btnUpdate:
                Intent updateIntent = new Intent(this, UpdateActivity.class);
                startActivity(updateIntent);
                break;
            case R.id.btnRemove:
                Intent removeIntent = new Intent(this, RemoveActivity.class);
                startActivity(removeIntent);
                break;
        }
        myDbHelper.close();
    }

}
