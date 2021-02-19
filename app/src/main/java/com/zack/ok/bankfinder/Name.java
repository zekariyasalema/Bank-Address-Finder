package com.zack.ok.bankfinder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Name extends AppCompatActivity {
    Button click;
    public static TextView data;
    public static EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        click=(Button) findViewById(R.id.btnsearch);
        data=(TextView)findViewById(R.id.textview2);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FetchData1 process=new FetchData1();
                process.execute();
            }
        });
    }
}