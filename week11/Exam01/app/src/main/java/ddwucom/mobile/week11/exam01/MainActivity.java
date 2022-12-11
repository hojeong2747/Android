package ddwucom.mobile.week11.exam01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FoodManager foodManager;
    ListView listView;
    ArrayAdapter adapter;
    ArrayList<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // DataManager 적용해 볼 것
        foodManager = new FoodManager();
        foodList = foodManager.getFoodList();

        // Food 객체의 toString() 메소드가 호출되어 하나의 문자열로 처리됨
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, foodList);

        listView.setAdapter(adapter);

        // listView 롱클릭 이벤트 추가
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int pos, long id) {
                final int position = pos;
                String foodName = foodList.get(pos).getFood();
                // 다이얼로그 생성 코드
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("음식 삭제")
                        .setMessage(foodName + " 을(를) 삭제하시겠습니까?")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                foodList.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
                return false;
            }
        });
}

    public void onClick(View v) {
        final ConstraintLayout orderLayout =
                (ConstraintLayout)View.inflate(this,R.layout.order_layout, null);

        switch (v.getId()) {
            case R.id.button:
                android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("음식 추가")
                        .setView(orderLayout)
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false) // 대화상자 확인 눌렀을 때만 dialog 닫힌다.back만 누른다고 닫히지 x.
                        .setPositiveButton("추가", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText foodName = orderLayout.findViewById(R.id.foodName);
                                String food = foodName.getText().toString();
                                EditText foodCountry = orderLayout.findViewById(R.id.foodCountry);
                                String country = foodCountry.getText().toString();
                                foodList.add(new Food(food, country));
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();

                break;
        }
    }
}
