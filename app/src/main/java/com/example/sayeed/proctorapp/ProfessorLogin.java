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


public class ProfessorLogin extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_login);
        final EditText pEmail = (EditText)findViewById(R.id.pemail);
        final EditText pPasswd = (EditText)findViewById(R.id.ppassword);
        final Button pLogin = (Button)findViewById(R.id.plogin);

        pLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = pEmail.getText().toString();
                String pswd = pPasswd.getText().toString();
                if(em.isEmpty() || pswd.isEmpty())
                    Toast.makeText(getApplicationContext(),"Please enter both eMail and Password",Toast.LENGTH_LONG).show();
                else{
                    Intent in = new Intent(ProfessorLogin.this,DetailsPro.class);
                    startActivity(in);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_professor_login, menu);
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