package com.grizzlypenguins.lab1mpip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Darko on 08.11.2015.
 */
public class SecondActivity extends Activity {

    Button back;
    Button dozvoli;
    Button vnesi;
    EditText et;
    ListView listView;
    ArrayList<ListInput> lista = new ArrayList<ListInput>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dozvoli = (Button) findViewById(R.id.dozvoli);
        back = (Button) findViewById(R.id.backButton);
        vnesi = (Button) findViewById(R.id.vnesi);
        et = (EditText)findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);

        vnesi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {

                if(!et.getText().toString().equals(""))
                {
                    Calendar c = Calendar.getInstance();
                    int seconds = c.get(Calendar.SECOND);
                    int mins = c.get(Calendar.MINUTE);
                    int hours = c.get(Calendar.HOUR);
                    String time = String.format(hours+ ":"+mins+":"+seconds);
                    lista.add(new ListInput(et.getText().toString(), time));
                    listView.setAdapter(new ListElementAdapter(SecondActivity.this, lista));
                    et.setText("");
                }
                else
                    Toast.makeText(SecondActivity.this,"InputSomething",Toast.LENGTH_LONG).show();

            }
        });


        dozvoli.setOnClickListener(new View.OnClickListener() {
            public  void onClick(View arg0)
            {
                findViewById(R.id.editText).setEnabled(true);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent myIntent = new Intent(SecondActivity.this,
                        MainActivity.class);
                startActivity(myIntent);

            }
        });

        Toast.makeText(getApplicationContext(), "SecondActivity - OnCreate", Toast.LENGTH_LONG).show();
    }

    public void remove_row(int n)
    {
        lista.remove(n);
        listView.setAdapter(new ListElementAdapter(SecondActivity.this, lista));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "SecondActivity - OnStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"SecondActivity - OnResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"SecondActivity - OnPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"SecondActivity - OnStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"SecondActivity - OnDestroy", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(),"SecondActivity - OnRestart", Toast.LENGTH_LONG).show();
    }

}
