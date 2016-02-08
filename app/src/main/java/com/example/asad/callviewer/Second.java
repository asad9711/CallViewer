package com.example.asad.callviewer;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class Second extends AppCompatActivity {
    TextView call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        call = (TextView)findViewById(R.id.call);
        call.setMovementMethod(new ScrollingMovementMethod());
        if(MainActivity.param.equals("missed"))
        {
        getCallDetails("missed");
        }
        else if(MainActivity.param.equals("received"))
        {
            getCallDetails("received");
        }
        else if(MainActivity.param.equals("dialled"))
        {
        getCallDetails("dialled");
        }


    }
    private void getCallDetails(String x) {
        Log.d("asd", "I am in call details.");

        StringBuffer sb = new StringBuffer();
        Cursor managedCursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, null,
                null, null, null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int name = managedCursor.getColumnIndex(CallLog.Calls.CACHED_NAME);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        sb.append("Call Details :");
        int count = 0;int dircode=0;
        while (managedCursor.moveToNext()) {

            //count++;
            String phNumber = managedCursor.getString(number);
           // if ( count == 50)
             //   break;
            String namee = managedCursor.getString(name);
            String callType = managedCursor.getString(type);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            String callDuration = managedCursor.getString(duration);
            String dir = null;
            if(x.equals("received"))
                dircode= CallLog.Calls.INCOMING_TYPE;
            else if(x.equals("missed"))
                dircode= CallLog.Calls.MISSED_TYPE;
            else if(x.equals("dialled"))
                dircode= CallLog.Calls.OUTGOING_TYPE;

            // = Integer.parseInt(callType);
            switch (dircode) {
                case CallLog.Calls.OUTGOING_TYPE:
                    dir = "OUTGOING";
                    break;

                case CallLog.Calls.INCOMING_TYPE:
                    dir = "INCOMING";
                    break;

                case CallLog.Calls.MISSED_TYPE:
                    dir = "MISSED";
                    break;
            }
            sb.append("\nName: "+namee+"\nPhone Number:  " + phNumber + " \nCall Type:  "
                    + dir + " \nCall Date:   " + callDayTime
                    + " \nCall duration in sec :   " + callDuration);
            sb.append("\n----------------------------------");
        }
        //CharSequence cs=(CharSequence)sb;
        //call.setText(cs);
        call.setText(sb);
        managedCursor.close();
    }

}
