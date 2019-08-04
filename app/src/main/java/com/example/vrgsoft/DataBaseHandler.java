package com.example.vrgsoft;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.vrgsoft.nyt.MediaMetadatum;
import com.example.vrgsoft.nyt.Medium;
import com.example.vrgsoft.nyt.Result;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DB";
    private static final String TABLE_NEWS = "Favourite";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DETAIL = "detail";
    private static final String KEY_URL = "url";
    private static final String KEY_DATE = "date";
    private static final String KEY_SECTION = "section";

    public DataBaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FAVOURITE_TABLE;
        CREATE_FAVOURITE_TABLE = "create table if not exists " + TABLE_NEWS + "("
                + KEY_ID + " integer primary key autoincrement unique, "
                + KEY_NAME + " text not null,"
                + KEY_URL + " text,"
                + KEY_DATE + " text,"
                + KEY_SECTION + " text,"
                + KEY_DETAIL + " text);";
        db.execSQL(CREATE_FAVOURITE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NEWS);
        onCreate(db);
    }

    void add(Result result) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, result.getTitle());
        values.put(KEY_URL, result.getMedia().get(0).getMediaMetadata().get(2).getUrl());
        values.put(KEY_DATE, result.getUpdated());
        values.put(KEY_DETAIL, result.getAbstract());
        values.put(KEY_SECTION, result.getSection());
        db.insert(TABLE_NEWS, null, values);
        db.close();
    }

    Result getResult(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NEWS, new String[]{KEY_ID, KEY_NAME, KEY_URL, KEY_DATE, KEY_DETAIL, KEY_SECTION},
                KEY_ID + "=?", new String[]{String.valueOf(id)},
                null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }


        return cursorTOResult(cursor);
    }

    public Result cursorTOResult(Cursor cursor) {
        Result result = new Result();
        Medium medium = new Medium();
        MediaMetadatum mediaMetadatum = new MediaMetadatum();
        MediaMetadatum mediaMetadatum1 = new MediaMetadatum();
        result.setTitle(cursor.getString(1));
        result.setSection(cursor.getString(4));
        result.setAbstract(cursor.getString(5));
        result.setUpdated(cursor.getString(3));
        mediaMetadatum.setUrl(cursor.getString(2));
        List<MediaMetadatum> mediaMetadatumArrayList = new ArrayList<>();
        mediaMetadatumArrayList.add(mediaMetadatum1);
        mediaMetadatumArrayList.add(mediaMetadatum1);
        mediaMetadatumArrayList.add(mediaMetadatum);
        medium.setMediaMetadata(mediaMetadatumArrayList);
        List<Medium> mediumList = new ArrayList<>();
        mediumList.add(medium);
        result.setMedia(mediumList);

        return result;
    }

    public void remove( String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NEWS, KEY_NAME + "=?", new String[]{title});
        db.close();
    }

    public ArrayList<Result> getAllResults() {

        ArrayList<Result> resultList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NEWS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                resultList.add(cursorTOResult(cursor));
            } while (cursor.moveToNext());
        }

        return resultList;
    }
}
