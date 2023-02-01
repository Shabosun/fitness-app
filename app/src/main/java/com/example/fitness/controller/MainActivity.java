package com.example.fitness.controller;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness.R;
import com.example.fitness.database.DatabaseAdapter;
import com.example.fitness.database.DatabaseHelper;
import com.example.fitness.model.Exercise;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    TextView header;
    ListView exerciseList;
    ArrayAdapter<Exercise> arrayAdapter;
    //DatabaseHelper databaseHelper;
    //SQLiteDatabase db;
    //Cursor cursor;
    //SimpleCursorAdapter cursorAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        header = findViewById(R.id.header);



        exerciseList = findViewById(R.id.list);

        exerciseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Exercise exercise = arrayAdapter.getItem(position);
                if(exercise != null)
                {
                    //something
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        DatabaseAdapter adapter = new DatabaseAdapter(this);
        adapter.open();

        List<Exercise> exercises = adapter.getExercises();

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercises);
        if(arrayAdapter != null)
            header.setText(String.valueOf(arrayAdapter.getCount()));
        exerciseList.setAdapter(arrayAdapter);
        adapter.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    /*  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        header = findViewById(R.id.header);
        exerciseList = findViewById(R.id.list);
        exerciseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(getApplicationContext(), ExercisesActivity.class);
//                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        databaseHelper = new DatabaseHelper(getApplicationContext());
        // создаем базу данных
        databaseHelper.copy_db();
    }

    @Override
    protected void onResume() {
        super.onResume();

        db = databaseHelper.open(); //открываем подключение к бд
        cursor = db.rawQuery("select * from " + DatabaseHelper.ExerciseTable.NAME, null);

        //определяем какие столбцы будут выводиться в ListView
        String[] headers = new String[]{DatabaseHelper.ExerciseTable.Cols.EXERCISE_NAME,
                DatabaseHelper.ExerciseTable.Cols.MUSCLE_NAME}; //заменить

        //создаем адаптер, передаем в него курсор
        cursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                cursor,
                headers,
                new int[]{android.R.id.text1, android.R.id.text2}, 0);
//        header.setText("Найдено элементов: " + cursor.getCount());
        exerciseList.setAdapter(cursorAdapter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Закрываем подключение и курсор
        db.close();
        cursor.close();
    }*/
}
