package com.example.sayeed.proctorapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;


public class StudentLogin extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        final EditText sUSN = (EditText)findViewById(R.id.susn);
        final EditText sPswd = (EditText)findViewById(R.id.spassword);
        final Button sLogin = (Button)findViewById(R.id.slog);

        sLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usn = sUSN.getEditableText().toString();
                usn = usn.toUpperCase().trim();
                String spswd = sPswd.getEditableText().toString();
                if(usn.isEmpty() || spswd.isEmpty())
                    Toast.makeText(getApplicationContext(), "Please enter both USN and Password", Toast.LENGTH_LONG).show();

                else{
                    int ulen = usn.length();
                    int plen = spswd.length();
                    if(ulen>10)
                        Toast.makeText(getApplicationContext(), "Please enter valid USN", Toast.LENGTH_LONG).show();
                    else {
                        Intent inr = new Intent(StudentLogin.this, Details.class);
                        inr.putExtra("sUSN", usn);
                        inr.addFlags(Intent.FLAG_DEBUG_LOG_RESOLUTION);
                        startActivity(inr);
                       // ParseUser currentUser = ParseUser.getCurrentUser();
                    }
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student_login, menu);
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
