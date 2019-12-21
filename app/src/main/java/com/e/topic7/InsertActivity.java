package com.e.topic7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class InsertActivity extends AppCompatActivity {
Button btnAdd;
EditText etMeaning,etWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        btnAdd =findViewById(R.id.btnAdd);
        etMeaning=findViewById(R.id.etMeaning);
        etWord=findViewById(R.id.etWord);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }
    public void Save()
    {
        try {
            PrintStream printStream =new PrintStream(openFileOutput("words.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println(etWord.getText().toString()+"="+etMeaning.getText().toString());
            Toast.makeText(this,"saved to"+getFilesDir(),Toast.LENGTH_SHORT ).show();
        }
        catch(IOException e){
            Log.d("Dictionary app", "Error"+e.toString());
            e.printStackTrace();

        }
    }
}
