package ddwu.mobile.finalreport.finalreport_02_20201030;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MusicDBHelper extends SQLiteOpenHelper {

    final static String DB_NAME = "musics.db";
    public final static String TABLE_NAME = "music_table";

    public final static String COL_ID = "_id";
    public final static String COL_ARTIST = "artist";
    public final static String COL_TITLE = "title";
    public final static String COL_GENRE = "genre";
    public final static String COL_DATE = "date";
    public final static String COL_REPORT = "report";
    public final static String COL_LYRICS = "lyrics";

    public MusicDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " integer primary key autoincrement, " +
                COL_ARTIST + " TEXT, " + COL_TITLE + " TEXT, " + COL_GENRE + " TEXT, " +
                COL_DATE + " TEXT, " + COL_REPORT + " TEXT, " + COL_LYRICS + " TEXT)";
        db.execSQL(sql);

        insertSample(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void insertSample(SQLiteDatabase db) {
        db.execSQL("insert into " + TABLE_NAME + " values (null, '백예린', '한계', '발라드', '20210910', '사랑을 담아', " +
                "'난 몇 마디의 말과 몇 번의 손짓에 " +
                "또 몇 개의 표정과 흐르는 마음에');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '백예린', '물고기', '모던록', '20220524', '사랑받던 순간의 기억으로 하루를 살아내고.', " +
                "'너만은 나를 알아봐야 해\n" +
                "너만 알 수 있는 내 마음을\n" +
                "복잡한 나만의 언어를 알아봐 줘');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '애쉬아일랜드', '멜로디', '힙합', '20210225', 'COMING SOON', " +
                "'영원할 것 같았던 약속들\n" +
                "손을 잡아주겠다던 너와 나 둘\n" +
                "앞이 안 보일 때 너가 돼준 내 눈\n" +
                "겨울에 함께 봤던 눈\n" +
                "불타올랐지 아무리 추워도 난\n" +
                "With you\n" +
                "불이 꺼져 재만 남아도 Lovin u\n" +
                "라고 말하던 때 그때 그 기억인 듯\n" +
                "아직도 너와 듣던 노래들의 가사들\n" +
                "뻔한듯했던 그 Melody\n" +
                "가 익숙하던 예전 그대로\n" +
                "고정돼있던 곡 뻔하던 그 제목\n" +
                "초라해질까 봐 난 말을 못 했어\n" +
                "필요해 너가');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '릴러말즈', 'RUN', '힙합', '20200623', 'We came 16%', " +
                "'I’m gon die 너가 사라지면\n" +
                "난 망가졌을거야 다\n" +
                "내게서 떠나지마 너 없이는\n" +
                "I’m gon die');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '스키니브라운', 'fix you', '힙합', '20200419', '괴로운 나를 위해서, 그리고 나와 같은 사람들을 위해서 내는 노래.', " +
                "'넌 네 생각보다 빛이나\n" +
                "언젠가는 fix me\n" +
                "나도 너의 손을 붙잡을 거야');");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '블랙핑크', 'Lovesick Girls', 'K-pop', '20201002', '인간은 왜 사랑에 상처받고 아파하면서도 또 다른 사랑을 찾아가는지', " +
                "'사랑은 slippin’ and fallin’\n" +
                "사랑은 killin’ your darlin’\n" +
                "아프다 아물면 또 찾아오는 이 겁 없는 떨림');");
    }
}
