package com.example.prince.g_app;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static android.content.ContentValues.TAG;

/**
 * Created by Prince on 18-04-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static SQLiteDatabase sqliteDb;
    private static DatabaseHandler instance;
    private static final int DATABASE_VERSION = 3;
    //
    private static final String DB_NAME = "Gate.db";
    private static final String SP_KEY_DB_VER = "db_ver";


    private Context context;
    static Cursor cursor = null;

    DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory,
                   int version) {
        super(context, name, factory, version);
        this.context = context;

    }


    private static void initialize(Context context, String databaseName) {


        if (instance == null) {


            if (!checkDatabase(context, databaseName)) {

                try {
                    copyDataBase(context, databaseName);
                } catch (IOException e) {

                    System.out.println( databaseName
                            + " does not exists ");
                }
            }

            instance = new DatabaseHandler(context, databaseName, null,
                    DATABASE_VERSION);
            sqliteDb = instance.getWritableDatabase();

            System.out.println("instance of  " + databaseName + " created ");
        }
    }







    public static final DatabaseHandler getInstance(Context context, String databaseName) {
        initialize(context, databaseName);
        return instance;
    }
    public SQLiteDatabase getDatabase() {
        return sqliteDb;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB_NAME, int oldVersion, int newVersion) {
       /* "Upgrading database from version " + oldVersion  + " to "
                + newVersion + ", which will destroy all old data");*//*
        DB_NAME.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
        onCreate(DB_NAME);*/
        /*if(oldVersion!=newVersion){
            DB_NAME.execSQL("DROP DATABASE IF EXISTS " + DB_NAME);
    }*/
    }

    private static void copyDataBase(Context aContext, String databaseName)
            throws IOException {

        InputStream myInput = aContext.getAssets().open(databaseName);

        String outFileName = getDatabasePath(aContext, databaseName);

        File f = new File("/data/data/" + aContext.getPackageName()
                + "/databases/");
        if (!f.exists())
            f.mkdir();

        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        myOutput.flush();
        myOutput.close();
        myInput.close();

        System.out.println(databaseName + " copied");
    }
    public static boolean checkDatabase(Context aContext, String databaseName) {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = getDatabasePath(aContext, databaseName);

            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READONLY);

            checkDB.close();
        } catch (SQLiteException e) {

            System.out.println(databaseName + " does not exists");
        }

        return checkDB != null ? true : false;
    }
    private static String getDatabasePath(Context aContext, String databaseName) {
        return "/data/data/" + aContext.getPackageName() + "/databases/"
                + databaseName;
    }

    public static Cursor rawQuery(String query) {
        try {
            if (sqliteDb.isOpen()) {
                sqliteDb.close();
            }
            sqliteDb = instance.getWritableDatabase();

            cursor = null;
            cursor = sqliteDb.rawQuery(query, null);
        } catch (Exception e) {
            System.out.println("DB ERROR  " + e.getMessage());
            e.printStackTrace();
        }
        return cursor;
    }
    public static void execute(String query) {
        try {
            if (sqliteDb.isOpen()) {
                sqliteDb.close();
            }
            sqliteDb = instance.getWritableDatabase();
            sqliteDb.execSQL(query);
        } catch (Exception e) {
            System.out.println("DB ERROR  " + e.getMessage());
            e.printStackTrace();
        }
    }

}
