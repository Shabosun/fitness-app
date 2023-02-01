package com.example.fitness.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static  String DB_PATH; //путь к БД
    private static final String DB_NAME = "fit.db"; // название БД
    private static final int SCHEMA = 1; // версия базы данных

    public static final class ExerciseTable
    {
        public static final String NAME = "exercises";
        public static final class Cols
        {
            public static final String EXERCISE_ID = "_id";
            public static final String EXERCISE_NAME = "exercise_name";
            public static final String MUSCLE_NAME = "muscle_id";
            public static final String DESCRIPTION = "description";
            public static final String REFERENCE = "reference";

        }
    }



    private Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
        DB_PATH =context.getFilesDir().getPath() + DB_NAME;
    }


    @Override
    public void onCreate(SQLiteDatabase db) { }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) { }

    //копирование БД из ресурсов проекта
    public void copy_db(){

        File file = new File(DB_PATH);
        if (!file.exists()) {
            //получаем локальную бд как поток
            try(InputStream myInput = myContext.getAssets().open(DB_NAME);
                // Открываем пустую бд
                OutputStream myOutput = new FileOutputStream(DB_PATH)) {

                // побайтово копируем данные
                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush();
            }
            catch(IOException ex){
                Log.d("DatabaseHelper", ex.getMessage());
            }
        }
    }

    //открваем подключение к бд
    public SQLiteDatabase open()throws SQLException {
        copy_db();
        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }
}

