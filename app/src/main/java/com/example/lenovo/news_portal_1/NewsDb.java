package com.example.lenovo.news_portal_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 18.12.2017.
 */

public class NewsDb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "news_db";
    private static final String TABLE_NAME = "news_table";
    private static String NEWS_ID = "news_id";
    private static String NEWS_TITLE = "news_title";
    private static String NEWS_TEXT = "news_text";
    private static String NEWS_KATEGORI = "news_categori";
    private static String NEWS_IMG = "news_img";
    private static String[] columns = {NEWS_ID, NEWS_TITLE, NEWS_TEXT, NEWS_KATEGORI, NEWS_IMG};


    public NewsDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + "("
                + NEWS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NEWS_TITLE + " TEXT, "
                + NEWS_TEXT + " TEXT, "
                + NEWS_KATEGORI + " TEXT, "
                + NEWS_IMG + " BLOB);";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public long addNews(String baslik, String aciklama, String kategori, byte[] image) {

        try {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(NEWS_TITLE, baslik);
            cv.put(NEWS_TEXT, aciklama);
            cv.put(NEWS_KATEGORI, kategori);
            cv.put(NEWS_IMG, image);
            return db.insert(TABLE_NAME, null, cv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
    public List<News> haberleriGetir(){
        List<News> sporlar = new ArrayList<>();
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase;
        sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        News sport = null;
        if (cursor.moveToFirst()){
            do {
                sport = new News();
                sport.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(NEWS_ID))));
                sport.setBaslik(cursor.getString(cursor.getColumnIndex(NEWS_TITLE)));
                sport.setMetin(cursor.getString(cursor.getColumnIndex(NEWS_TEXT)));
                sport.setKategori(cursor.getString(cursor.getColumnIndex(NEWS_KATEGORI)));
                sport.setImage(cursor.getBlob(cursor.getColumnIndex(NEWS_IMG)));
                sporlar.add(sport);

            }while (cursor.moveToNext());
        }
        return sporlar;
    }


    public  News haberOku(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,columns," news_id = ?",new String[]{String.valueOf(id)},null,
                null,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        News news = new News();
        news.setId(Integer.parseInt(cursor.getString(0)));
        news.setBaslik(cursor.getString(1));
        news.setMetin(cursor.getString(2));
        news.setKategori(cursor.getString(3));
        news.setImage(cursor.getBlob(4));
        return news;
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
    }

    public List<News> economyGetir(){
        List<News> newss = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,columns,NEWS_KATEGORI + " = 'economy'",null,null,null,null);
        News news = null;
        if (cursor.moveToFirst()){
            do {
                news = new News();
                news.setId(Integer.parseInt(cursor.getString(0)));
                news.setBaslik(cursor.getString(1));
                news.setMetin(cursor.getString(2));
                news.setKategori(cursor.getString(3));
                news.setImage(cursor.getBlob(4));
                newss.add(news);

            }while (cursor.moveToNext());
        }
        return newss;
    }

    public List<News> sportGetir(){
        List<News> newss = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,columns,NEWS_KATEGORI + " = 'sport'",null,null,null,null);
        News news = null;
        if (cursor.moveToFirst()){
            do {
                news = new News();
                news.setId(Integer.parseInt(cursor.getString(0)));
                news.setBaslik(cursor.getString(1));
                news.setMetin(cursor.getString(2));
                news.setKategori(cursor.getString(3));
                news.setImage(cursor.getBlob(4));
                newss.add(news);

            }while (cursor.moveToNext());
        }
        return newss;
    }

    public List<News> lifeGetir(){
        List<News> newss = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,columns,NEWS_KATEGORI + " = 'life'",null,null,null,null);
        News news = null;
        if (cursor.moveToFirst()){
            do {
                news = new News();
                news.setId(Integer.parseInt(cursor.getString(0)));
                news.setBaslik(cursor.getString(1));
                news.setMetin(cursor.getString(2));
                news.setKategori(cursor.getString(3));
                news.setImage(cursor.getBlob(4));
                newss.add(news);

            }while (cursor.moveToNext());
        }
        return newss;
    }


    public List<News> technologyGetir(){
        List<News> newss = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,columns,NEWS_KATEGORI + " = 'technology'",null,null,null,null);
        News news = null;
        if (cursor.moveToFirst()){
            do {
                news = new News();
                news.setId(Integer.parseInt(cursor.getString(0)));
                news.setBaslik(cursor.getString(1));
                news.setMetin(cursor.getString(2));
                news.setKategori(cursor.getString(3));
                news.setImage(cursor.getBlob(4));
                newss.add(news);

            }while (cursor.moveToNext());
        }
        return newss;
    }
}
