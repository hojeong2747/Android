package ddwu.mobile.finalreport.finalreport_02_20201030;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {

    Music music;
    ArrayList<Music> musicList;
    int pos;

    EditText etTitle;
    EditText etArtist;
    EditText etGenre;
    EditText etDate;
    EditText etReport;
    EditText etLyrics;

    MusicDBManager musicDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        music = (Music) getIntent().getSerializableExtra("music");
        musicList = (ArrayList<Music>) getIntent().getSerializableExtra("musicList");
        pos = (int) getIntent().getSerializableExtra("pos");

        etTitle = findViewById(R.id.et_title);
        etArtist = findViewById(R.id.et_artist);
        etGenre = findViewById(R.id.et_genre);
        etDate = findViewById(R.id.et_date);
        etReport = findViewById(R.id.et_report);
        etLyrics = findViewById(R.id.et_lyrics);

        etTitle.setText(music.getTitle());
        etArtist.setText(music.getArtist());
        etGenre.setText(music.getGenre());
        etDate.setText(musicList.get(pos).getDate());
        etReport.setText(musicList.get(pos).getReport());
        etLyrics.setText(musicList.get(pos).getLyrics());

        musicDBManager = new MusicDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                music.setTitle(etTitle.getText().toString());
                music.setArtist(etArtist.getText().toString());
                music.setGenre(etGenre.getText().toString());
                music.setDate(etDate.getText().toString());
                music.setReport(etReport.getText().toString());
                music.setLyrics(etLyrics.getText().toString());

                if (musicDBManager.modifyMusic(music)) {
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("music", music);
                    setResult(RESULT_OK, resultIntent);
                } else {
                    setResult(RESULT_CANCELED);
                }
                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                break;
        }
        finish();
    }
}