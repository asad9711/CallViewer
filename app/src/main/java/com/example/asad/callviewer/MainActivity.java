package com.example.asad.callviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3;
    //TextView call;
    static String param=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("asd", "oncreate is called");
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(this);
      //  call = (TextView)findViewById(R.id.call);
        //call.setMovementMethod(new ScrollingMovementMethod());
        Log.d("asd","I am calling getcalldetails");
        //getCallDetails();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.b1) {
           // Toast.makeText(MainActivity.this,"button1",
             //       LENGTH_SHORT).show();
           // getCallDetails("missed");
       // dosomething("misssed");
            param="missed";
        }
        if (v.getId() == R.id.b2) {
           // Toast.makeText(MainActivity.this,"button2",
             //       LENGTH_SHORT).show();
            //getCallDetails("received");
           // dosomething("received");
            param="received";
        }
        if (v.getId() == R.id.b3) {
           // Toast.makeText(MainActivity.this,"button3",
             //       LENGTH_SHORT).show();
            //getCallDetails("dialled");
         // dosomething("dialled");
            param="dialled";
        }
        dosomething();
    }
   private void dosomething()
    {
        Intent i=new Intent(this,Second.class);
        startActivity(i);
    }

}