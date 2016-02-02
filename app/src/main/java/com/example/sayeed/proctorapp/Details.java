package com.example.sayeed.proctorapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class Details extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);
        Intent intnt = getIntent();
        String sUsn = intnt.getStringExtra("sUSN");

        final TextView Usn = (TextView)findViewById(R.id.usn);
        final TextView Name = (TextView)findViewById(R.id.name);
        final TextView Sub1 = (TextView)findViewById(R.id.sub1);
        final TextView Sub2 = (TextView)findViewById(R.id.sub2);
        final TextView Sub3 = (TextView)findViewById(R.id.sub3);

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Student");
        query.whereEqualTo("USN",sUsn);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null)
                    Toast.makeText(getApplicationContext(),"All the best!",Toast.LENGTH_LONG).show();
                    for (ParseObject ob : objects){
                        Usn.setText(ob.get("USN").toString());
                        Name.setText(ob.get("sNAME").toString());
                        Sub1.setText(ob.get("CIE1").toString());
                        Sub2.setText(ob.get("CIE2").toString());
                        Sub3.setText(ob.get("CIE2").toString());

                    }
            }
        });
     }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
