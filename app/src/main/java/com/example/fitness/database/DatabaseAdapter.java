package com.example.fitness.database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.fitness.model.Exercise;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
            private DatabaseHelper dbHelper;
            private SQLiteDatabase db;


    public DatabaseAdapter(Context context){
        dbHelper = new DatabaseHelper(context.getApplicationContext());
        //dbHelper.copy_db();
    }


    public DatabaseAdapter open()
    {
        //dbHelper.open();
        db = dbHelper.open();
        return this;
    }

    public void close()
    {
        dbHelper.close();
    }

    private Cursor getAllEntries()
    {
        String[] columns = new String []{
                DatabaseHelper.ExerciseTable.Cols.EXERCISE_ID,
                DatabaseHelper.ExerciseTable.Cols.EXERCISE_NAME,
                DatabaseHelper.ExerciseTable.Cols.MUSCLE_NAME,
                DatabaseHelper.ExerciseTable.Cols.DESCRIPTION,
                DatabaseHelper.ExerciseTable.Cols.REFERENCE};
        return db.query(DatabaseHelper.ExerciseTable.NAME, columns, null, null, null, null, null);
        //return db.rawQuery(DatabaseHelper.ExerciseTable.NAME, null);
    }

    public List<Exercise> getExercises()
    {
        ArrayList<Exercise> exercises = new ArrayList<>();
        Cursor cursor = getAllEntries();
        while(cursor.moveToNext())
        {
            long id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.ExerciseTable.Cols.EXERCISE_ID));
            String ex_name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ExerciseTable.Cols.EXERCISE_NAME));
            String muscle_g = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ExerciseTable.Cols.MUSCLE_NAME));
            String descr = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ExerciseTable.Cols.DESCRIPTION));
            String ref = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ExerciseTable.Cols.REFERENCE));

            exercises.add(new Exercise(id, ex_name, muscle_g, descr, ref));

        }

        cursor.close();

        return exercises;
    }

    public long getCount()
    {
        return DatabaseUtils.queryNumEntries(db, DatabaseHelper.ExerciseTable.NAME, DatabaseHelper.ExerciseTable.Cols.EXERCISE_ID);


    }

    public Exercise getExercise(long id)
    {
        Exercise exercise = null;
        String query = String.format("select * from %s where %s=?", DatabaseHelper.ExerciseTable.NAME);
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(id)});
        if(cursor.moveToFirst())
        {

            String ex_name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ExerciseTable.Cols.EXERCISE_NAME));
            String muscle_g = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ExerciseTable.Cols.MUSCLE_NAME));
            String descr = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ExerciseTable.Cols.DESCRIPTION));
            String ref = cursor.getString(cursor.getColumnIndex(DatabaseHelper.ExerciseTable.Cols.REFERENCE));

        }

        cursor.close();
        return exercise;
    }









}
