package com.zack.ok.bankfinder;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Address extends AppCompatActivity {
  Button click;
  public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        click=(Button) findViewById(R.id.button4);
        data=(TextView)findViewById(R.id.textview1);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            FetchData process=new FetchData();
            process.execute();
            }
        });
    }
}