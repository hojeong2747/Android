package ddwu.mobile.finalreport.finalreport_02_20201030;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MusicDBManager {

    MusicDBHelper musicDBHelper = null;
    Cursor cursor = null;

    public MusicDBManager(Context context) {
        musicDBHelper = new MusicDBHelper(context);
    }

    public ArrayList<Music> getAllMusic() {
        ArrayList musicList = new ArrayList();
        SQLiteDatabase db = musicDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MusicDBHelper.TABLE_NAME, null);

        while (cursor.moveToNext()) {
            @SuppressLint("Range") long id = cursor.getInt(cursor.getColumnIndex(MusicDBHelper.COL_ID));
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_TITLE));
            @SuppressLint("Range") String artist = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_ARTIST));
            @SuppressLint("Range") String genre = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_GENRE));
            @SuppressLint("Range") String date = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_DATE));
            @SuppressLint("Range") String report = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_REPORT));
            @SuppressLint("Range") String lyrics = cursor.getString(cursor.getColumnIndex(MusicDBHelper.COL_LYRICS));
            musicList.add(new Music(id, title, artist, genre, date, report, lyrics));
        }

        cursor.close();
        musicDBHelper.close();
        return musicList;
    }

    public boolean addNewMusic(Music newMusic) {

        SQLiteDatabase db = musicDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(MusicDBHelper.COL_TITLE, newMusic.getTitle());
        value.put(MusicDBHelper.COL_ARTIST, newMusic.getArtist());
        value.put(MusicDBHelper.COL_GENRE, newMusic.getGenre());

        long count = db.insert(MusicDBHelper.TABLE_NAME, null, value);

        if (count > 0) return true;
        return false;
    }

    public boolean removeMusic(long id) {
        SQLiteDatabase db = musicDBHelper.getWritableDatabase();
        String whereClause = MusicDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = db.delete(MusicDBHelper.TABLE_NAME, whereClause, whereArgs);

        musicDBHelper.close();
        if(result > 0)
            return true;
        return false;
    }

    public boolean modifyMusic(Music music) {
        SQLiteDatabase db = musicDBHelper.getWritableDatabase();

        ContentValues row = new ContentValues();
        row.put(MusicDBHelper.COL_TITLE, music.getTitle());
        row.put(MusicDBHelper.COL_ARTIST, music.getArtist());
        row.put(MusicDBHelper.COL_GENRE, music.getGenre());
        row.put(MusicDBHelper.COL_DATE, music.getDate());
        row.put(MusicDBHelper.COL_REPORT, music.getReport());
        row.put(MusicDBHelper.COL_LYRICS, music.getLyrics());

        String whereClause = MusicDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(music.get_id()) };

        int result = db.update(MusicDBHelper.TABLE_NAME, row, whereClause, whereArgs);

        musicDBHelper.close();

        if(result > 0 ) return true;
        return false;
    }


}
