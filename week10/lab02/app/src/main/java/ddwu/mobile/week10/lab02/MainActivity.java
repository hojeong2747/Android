package ddwu.mobile.week10.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataManager dataManager;
    private ArrayList<MyData> myDataList;
    private MyAdapter myAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dataManager로 뽑아 낼 수 있다.
        dataManager = new DataManager();
        myDataList = dataManager.getMyDataList();

        myAdapter = new MyAdapter(this,R.layout.custom_view_layout, myDataList);

        listView = (ListView) findViewById(R.id.customListView);

        listView.setAdapter(myAdapter);

        listView.setOnItemLongClickListener(itemLongClickListener);
    }

    AdapterView.OnItemLongClickListener itemLongClickListener =
            new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //dataManager.removeData(myDataList.get(i));
                    dataManager.removeData2(i);
                    myAdapter.notifyDataSetChanged();
                    return false;
                }
            };
}