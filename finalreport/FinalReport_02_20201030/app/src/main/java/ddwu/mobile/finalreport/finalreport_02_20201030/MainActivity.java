// 과제명:
// 분반: 02 분반
// 학번: 20201030 성명: 한호정
// 제출일: 2022년 6월

package ddwu.mobile.finalreport.finalreport_02_20201030;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int REQ_CODE = 100;
    final int UPDATE_CODE = 200;

    ListView listView;
    MyAdapter myAdapter;
    ArrayList<Music> musicList = null;
    MusicDBManager musicDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicDBManager = new MusicDBManager(this);
        musicList = new ArrayList<Music>();
        musicList.addAll(musicDBManager.getAllMusic());

        myAdapter = new MyAdapter(this, R.layout.cutom_view_layout, musicList);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(myAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int pos = i;
                String titleName = musicList.get(pos).getTitle();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("삭제 확인")
                        .setMessage(titleName + "을(를) 삭제하시겠습니까?")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if(musicDBManager.removeMusic(musicList.get(pos).get_id())) {
                                    musicList.clear();
                                    musicList.addAll(musicDBManager.getAllMusic());
                                    myAdapter.notifyDataSetChanged();
                                }
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();

                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Music music = musicList.get(i);
//
//                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
//                intent.putExtra("music", music);
                Music music = musicList.get(i);
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);

                intent.putExtra("music", music);
                intent.putExtra("musicList", musicList);
                intent.putExtra("pos", i);

                startActivityForResult(intent, UPDATE_CODE);
            }
        });

    }

    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem01:
                Intent intent1 = new Intent(this, AddActivity.class);
                startActivityForResult(intent1, REQ_CODE);
                break;
            case R.id.menuItem02:
                Intent intent2 = new Intent(this, MyActivity.class);
                startActivity(intent2);
                break;
            case R.id.menuItem03:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("앱 종료")
                        .setMessage("앱을 종료하시겠습니까?")
                        .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("취소", null)
                        .setCancelable(false)
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        musicList.clear();
        musicList.addAll(musicDBManager.getAllMusic());
        myAdapter.notifyDataSetChanged();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    break;
                case RESULT_CANCELED:
                    break;
            }
        } else if(requestCode == UPDATE_CODE) {
            switch (resultCode) {
                case RESULT_OK:
                    break;
                case RESULT_CANCELED:
                    break;
            }
        }
    }
}