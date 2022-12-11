package ddwu.mobile.finalreport.finalreport_02_20201030;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etArtist;
    EditText etGenre;
    MusicDBManager musicDBManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etTitle = findViewById(R.id.et_title);
        etArtist = findViewById(R.id.et_artist);
        etGenre = findViewById(R.id.et_genre);

        musicDBManager = new MusicDBManager(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                boolean result = musicDBManager.addNewMusic(
                        new Music(etTitle.getText().toString(), etArtist.getText().toString(), etGenre.getText().toString())
                );

                if (result) {
                    setResult(RESULT_OK);
                    finish();
                } else {
                    Toast.makeText(this,"새로운 music 추가 실패!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}