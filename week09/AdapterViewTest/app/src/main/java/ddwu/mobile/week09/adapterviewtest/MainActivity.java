package ddwu.mobile.week09.adapterviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //여기 안에 넣어야 한다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager();
        subjectList = dataManager.getSubjectList();

        adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        subjectList);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(itemClickListener);
    }

    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                    Toast.makeText(MainActivity.this, subjectList.get(pos), Toast.LENGTH_SHORT).show();
                    dataManager.removeDate(pos);
                    adapter.notifyDataSetChanged();
                }
            };
    
//    ArrayList<String> subjectList = new ArrayList<String>();
//    subjectList.add("모바일소프트웨어");
//    subjectList.add("네트워크");
//    subjectList.add("웹서비스");
//    subjectList.add("운영체제");
//    subjectList.add("웹프로그래밍2");

}