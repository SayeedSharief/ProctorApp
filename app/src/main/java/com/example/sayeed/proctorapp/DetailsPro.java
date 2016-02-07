package com.example.sayeed.proctorapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import org.w3c.dom.Text;

import java.util.List;


public class DetailsPro extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pro);
        final EditText pName = (EditText)findViewById(R.id.pname);
        final EditText Desig = (EditText)findViewById(R.id.designation);
        final EditText Stud = (EditText)findViewById(R.id.students);
        final EditText Subj = (EditText)findViewById(R.id.subjects);
        final EditText Quiz = (EditText)findViewById(R.id.quiz);
        final Button but = (Button)findViewById(R.id.enter_button);

        Intent ent = getIntent();
        final String email = ent.getStringExtra("pEmail");

        final String Name = pName.getEditableText().toString();
        String Designstion = Desig.getEditableText().toString();
        String Students = Stud.getEditableText().toString();
        String Subjects = Subj.getEditableText().toString();
        final String QUiz = Quiz.getEditableText().toString();

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        ParseObject ob = new ParseObject("Professor");
                ob.put("ADD",QUiz);// ADD is the column i have declared in Parse.com
                if(ob.containsKey(email)){
                    ob.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e==null){
                                Toast.makeText(getApplicationContext(),"Done Saving",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Log.d("Parse",e.getMessage());
                            }
                        }
                    });
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
