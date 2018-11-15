package com.example.bryan.databasetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDatabase.db";
    public static final String TABLE_NAME = "MyTable";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " TEXT );";

        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

    //Add row
    public void addRow(Row row){
        ContentValues values = new ContentValues();

        values.put(COL_NAME, row.get_name());

        SQLiteDatabase db = getWritableDatabase();

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    //Update row
    public void updateRow(String oldData, String newData){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COL_NAME, newData);

        db.update(TABLE_NAME, values, COL_NAME + "=\"" + oldData + "\"", null);

        db.close();
    }

    //Delete row
    public void deleteRow(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COL_NAME + "=\"" + name + "\";");
        db.close();
    }

    //Query all rows
    public String getTableData(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE 1";

        Cursor c = db.rawQuery(query,null);

        c.moveToFirst();

        while(!c.isAfterLast()){

            if(c.getString(c.getColumnIndex("name")) != null){
                dbString += c.getString(c.getColumnIndex("name"));
                dbString += "\n";

                c.moveToNext();
            }

        }

        db.close();

        return dbString;
    }
}















