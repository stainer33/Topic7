package com.e.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MeaningActivity extends AppCompatActivity {
    TextView meaning, word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);

        meaning =findViewById(R.id.meaning);
        word =findViewById(R.id.word);

        Bundle bundle =getIntent().getExtras();
        if(bundle!=null)
        {
            String meaning =bundle.getString("meaning");
            String word=bundle.getString("word");
            this.meaning.setText(meaning);
            this.word.setText(word);
        }
    }
}
