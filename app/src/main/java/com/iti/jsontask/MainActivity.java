package com.iti.jsontask;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    Button button;
    EditText editText;
    TextView textView;
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindComponents();

        button.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    void bindComponents(){
        button= (Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textview);
        editText=(EditText)findViewById(R.id.edittext);
        editText.setText("{name='aya', gender='female', age=22}");
    }
    Person parseJson(String json){
        person= new Person();
        try {
            JSONObject jsonObject= new JSONObject(json);
            person.setName(jsonObject.getString("name"));
            person.setAge(jsonObject.getInt("age"));
            person.setGender(jsonObject.getString("gender"));
            System.out.println("person"+person.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button:
                person=parseJson(editText.getText().toString());
                System.out.println("on click"+person.toString());
                textView.setText("name :"+person.getName()+"\nage :"+person.getAge()+"\ngender :"+person.getGender());
        }
    }
}
