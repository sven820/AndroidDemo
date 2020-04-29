package com.example.androiddemo.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androiddemo.R;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.List;

public class StoreActivity extends AppCompatActivity {

    EditText editText;
    EditText prfEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        editText = (EditText)findViewById(R.id.editText1);
        prfEditText = (EditText)findViewById(R.id.editText2);
        getFromLocalFile();
        getFromSharedPreference();

        SQLiteDatabase database = LitePal.getDatabase();
    }

    public void saveSqlLitePalData(View view) {
        Person pan = new Person();
        pan.name = "pan";
        pan.age = 18;

        Person person = new Person();
        person.name = "jxf";
        person.age = 19;


        Person[] family = {pan, person};
//        person.family = family;
//        pan.family = family;

        pan.save();
        person.save();
    }
    public void getSqlLitePalData(View view) {
        final List<Person> allPersons = DataSupport.findAll(Person.class);

        Toast.makeText(StoreActivity.this, String.format("%d", allPersons.size()), Toast.LENGTH_SHORT).show();
    }

    public void saveSqlData(View view) {

    }

    private void getFromSharedPreference() {
        //自命名
        SharedPreferences preferences1 = getSharedPreferences("data", MODE_PRIVATE);
        String text = preferences1.getString("text", "");
        prfEditText.setText(text);
    }

    public void saveSharedPreference(View view) {

        //自命名
        SharedPreferences preferences1 = getSharedPreferences("data", MODE_PRIVATE);
        //已类名命名
        SharedPreferences preferences2 = getPreferences(MODE_PRIVATE);
        //已包名命名
        SharedPreferences preferences3 = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor edit = preferences1.edit();
        edit.putString("text", prfEditText.getText().toString());
        edit.apply();
        prfEditText.setText("");
    }

/**/
    private void getFromLocalFile() {
        FileInputStream input = null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try {
            input = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(input));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            editText.setText(content.toString());
        }
    }

    public void save(View view) {
        String text = editText.getText().toString();
        FileOutputStream out = null;
        BufferedWriter writer = null;
        Boolean res = true;
        try {
            out = openFileOutput("data", MODE_APPEND);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            res = false;
        } catch (IOException e) {
            e.printStackTrace();
            res = false;
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            if (res) {
                editText.setText("");
            }
        }
    }
}
