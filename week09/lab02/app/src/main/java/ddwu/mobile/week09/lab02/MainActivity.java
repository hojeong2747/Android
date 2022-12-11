package ddwu.mobile.week09.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SubjectManager subjectManager;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectManager = new SubjectManager();
        subjectList = subjectManager.getSubjectList();

        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, subjectList
        );

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        editText = findViewById(R.id.editText);
        listView.setOnItemClickListener(itemClickListener);
        listView.setOnItemLongClickListener(itemLongClickListener);
    }

    AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
                    //항목 클릭 시 해당 항목을 editText에 표시
                    editText.setText(adapter.getItem(i));
                    //수정을 위한 pos. 클릭 시 항목 위치 저장해 놓는다.
                    pos = i;
                }
            };

    AdapterView.OnItemLongClickListener itemLongClickListener =
            new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    subjectManager.removeData(i);
                    adapter.notifyDataSetChanged();
                    return false;
                }
            };

    public void onClick (View v) {
        switch (v.getId()) {
            //EditText에 문자열 입력 후 추가 버튼을 눌러 항목 추가
            case R.id.btn_add:
                String str1 = editText.getText().toString();
                subjectManager.addData(str1);
                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_modify:
                String str2 = editText.getText().toString();
                subjectManager.modifyData(pos,str2);
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
