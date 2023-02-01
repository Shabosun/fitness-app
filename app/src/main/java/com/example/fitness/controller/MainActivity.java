package com.example.fitness.controller;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.fitness.R;
import com.example.fitness.database.DatabaseHelper;


public class MainActivity extends AppCompatActivity {


    TextView header;
    ListView exerciseList;
    DatabaseHelper databaseHelper;
    SQLiteDatabase db;
    Cursor cursor;
    SimpleCursorAdapter cursorAdapter;

    @Override
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
    }
}
