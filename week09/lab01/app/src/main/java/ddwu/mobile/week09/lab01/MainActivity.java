package ddwu.mobile.week09.lab01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager();
        ArrayList<String> subjectList = dataManager.getSubjectList();
//        subjectList.add("good 4 u");
//        subjectList.add("deja vu");
//        subjectList.add("drivers license");
//        subjectList.add("feel me");
//        subjectList.add("good 4 u");
//        subjectList.add("deja vu");
//        subjectList.add("drivers license");
//        subjectList.add("feel me");
//        subjectList.add("good 4 u");
//        subjectList.add("deja vu");
//        subjectList.add("drivers license");
//        subjectList.add("feel me");
//        subjectList.add("good 4 u");
//        subjectList.add("deja vu");
//        subjectList.add("drivers license");
//        subjectList.add("feel me");

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        subjectList);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}