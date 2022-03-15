package com.example.jason_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    String JSON_STRING = "{\"employee\":{\"name\":\"XYZ\",\"salary\":65000}}";
    String name,salary;
    TextView employeeName, employeeSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeName = (TextView) findViewById(R.id.textView1) ;
        employeeSalary = (TextView) findViewById(R.id.textView2) ;
        String data = "";
                try {
                    JSONObject jsonRootObject = new JSONObject(JSON_STRING);
                    JSONArray jsonArray = jsonRootObject.getJSONArray("Employee");
                    for (int i=0; i<jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject((i));
                        int id = Integer.parseInt(jsonObject.optString("id").toString());
                        String name = jsonObject.optString("name").toString();
                        float salary = Float.parseFloat(jsonObject.optString("salary").toString());
                        data += "Node"+i+" : id = "+ id + "\n Name = "+ name +"\n Salary "+ salary + "\n";
                    }
                    employeeName.setText(data);
                    
                } catch (JSONException e) {
                    e.printStackTrace();
                }


    }
}