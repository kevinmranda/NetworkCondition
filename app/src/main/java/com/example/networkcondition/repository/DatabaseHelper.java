package com.example.networkcondition.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.networkcondition.model.Survey;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "network_condition";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "survey";
    private static final String KEY_ID = "id";
    private static final String KEY_ROAD = "road";
    private static final String KEY_START = "start";
    private static final String KEY_START_NO = "start_no";
    private static final String KEY_LINK = "link";
    private static final String KEY_END = "end_t";
    private static final String KEY_END_NO = "end_no";
    private static final String KEY_SUB_LINK = "sub_link";
    private static final String KEY_CORRIDOR = "corridor";
    private static final String KEY_REGION = "region";
    private static final String KEY_SHOULDER_TYPE = "shoulder_type";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+TABLE_NAME+" ( "+KEY_ID+" integer primary key,"+KEY_ROAD+"" +
                " text,"+KEY_START+" text,"+KEY_START_NO+" " +
                "text,"+KEY_LINK+" text,"+KEY_END+" text,"+KEY_END_NO+" text,"+KEY_SUB_LINK+"" +
                " text,"+KEY_CORRIDOR+" text,"+KEY_REGION+" text,"+KEY_SHOULDER_TYPE+" text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "drop table if exists "+TABLE_NAME;
        db.execSQL(query);

        onCreate(db);
    }

    public void createSurvey(Survey survey){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ROAD,survey.getRoad());
        values.put(KEY_START,survey.getStart());
        values.put(KEY_START_NO,survey.getStart_no());
        values.put(KEY_LINK,survey.getLink());
        values.put(KEY_END,survey.getEnd_t());
        values.put(KEY_END_NO,survey.getEnd_no());
        values.put(KEY_SUB_LINK,survey.getSub_link());
        values.put(KEY_CORRIDOR,survey.getCorridor());
        values.put(KEY_REGION,survey.getRegion());
        values.put(KEY_SHOULDER_TYPE,survey.getShoulder_type());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public ArrayList<Survey> getAllSurveys(){
        ArrayList<Survey> surveys = new ArrayList<>();

        String query = "select * from "+TABLE_NAME+" order by id desc";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =db.rawQuery(query, null);

        System.out.println("DATA: "+cursor.moveToFirst());
        if (cursor.moveToFirst()){
            do{
                Survey survey =new Survey();
                survey.setId(Integer.parseInt(cursor.getString(0)));
                survey.setRoad(cursor.getString(1));
                survey.setStart(cursor.getString(2));
                survey.setStart_no(cursor.getString(3));
                survey.setLink(cursor.getString(4));
                survey.setEnd_t(cursor.getString(5));
                survey.setEnd_no(cursor.getString(6));
                survey.setSub_link(cursor.getString(7));
                survey.setCorridor(cursor.getString(8));
                survey.setRegion(cursor.getString(9));
                survey.setShoulder_type(cursor.getString(10));
                surveys.add(survey);
            } while (cursor.moveToNext());
        }
        return surveys;
    }

    public int updateSurvey(Survey survey){
        SQLiteDatabase db  = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ROAD,survey.getRoad());
        values.put(KEY_START,survey.getStart());
        values.put(KEY_START_NO,survey.getStart_no());
        values.put(KEY_LINK,survey.getLink());
        values.put(KEY_END,survey.getEnd_t());
        values.put(KEY_END_NO,survey.getEnd_no());
        values.put(KEY_SUB_LINK,survey.getSub_link());
        values.put(KEY_CORRIDOR,survey.getCorridor());
        values.put(KEY_REGION,survey.getRegion());
        values.put(KEY_SHOULDER_TYPE,survey.getShoulder_type());

        int status  = db.update(TABLE_NAME, values, KEY_ID+"=?", new String[]{String.valueOf(survey.getId())});
        db.close();
        return  status;
    }

    public void deleteSurvey(Survey survey){
        SQLiteDatabase db  = this.getWritableDatabase();
        db.delete(TABLE_NAME, KEY_ID+"=?", new String[]{String.valueOf(survey.getId())});
    }
}
