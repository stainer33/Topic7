package com.e.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class wordsActivity extends AppCompatActivity {
    private ListView listView;
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        listView = findViewById(R.id.listView);
        dictionary = new HashMap<>();

        //read all the words from text file
        readFromFile();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                                     android.R.layout.simple_list_item_1,
                                     new ArrayList<String>(dictionary.keySet()));

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key =parent.getItemAtPosition(position).toString();//to get which item is clicked
                String meaning =dictionary.get(key);//get the meaning of clicked word/position
                //showing meaning into another activity
                Intent intent = new Intent(wordsActivity.this,MeaningActivity.class);
                intent.putExtra("meaning",meaning);
                intent.putExtra("word",key);
                startActivity(intent);
            }
        });
    }

    private void readFromFile() {
        try {
            FileInputStream fos = openFileInput("words.txt");
            InputStreamReader isr = new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                dictionary.put(parts[0], parts[1]);//parts[0]=key and parts[1]=value

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
