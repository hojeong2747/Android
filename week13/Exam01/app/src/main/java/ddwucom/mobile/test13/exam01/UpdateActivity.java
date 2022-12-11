package ddwucom.mobile.test13.exam01;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText etFoodId;
    EditText etNewFood;
    FoodDBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etFoodId = findViewById(R.id.etUpdateId);
        etNewFood = findViewById(R.id.etUpdateFood);
        dbHelper = new FoodDBHelper(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUpdateFood:
                String foodId = etFoodId.getText().toString();
                String newFood = etNewFood.getText().toString();

                ContentValues row = new ContentValues();
                row.put(FoodDBHelper.COL_FOOD, newFood);
                String whereClause = "_id=?";
                String[] whereArgs = new String[] {foodId};

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.update(FoodDBHelper.TABLE_NAME, row, whereClause, whereArgs);

                dbHelper.close();

                break;
            case R.id.btnUpdateCancel:

                break;
        }
        finish();
    }
}
