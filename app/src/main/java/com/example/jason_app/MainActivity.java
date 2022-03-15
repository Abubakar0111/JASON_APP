package com.example.jason_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.BreakIterator;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    String JSON_STRING = "{\"employee\":{\"name\":\"Abubakar\",\"salary\":100000}}";
    String name, salary;
    TextView employeeName, employeeSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of TextView's
        employeeName = (TextView) findViewById(R.id.textView1);
        employeeSalary = (TextView) findViewById(R.id.textView2);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(JSON_STRING);
            // fetch JSONObject named employee
            JSONObject employee = obj.getJSONObject("employee");
            // get employee name and salary
            name = employee.getString("name");
            salary = employee.getString("salary");
            // set employee name and salary in TextView's
            employeeName.setText("Name: "+ name);
            employeeSalary.setText("Salary: "+ salary);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

//public class MainActivity extends AppCompatActivity {
//    String JSON_STRING = "{\"employee\":{\"name\":\"XYZ\",\"salary\":65000}}";
//    String name,salary;
//    TextView employeeName, employeeSalary;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        employeeName = (TextView) findViewById(R.id.textView1) ;
//        employeeSalary = (TextView) findViewById(R.id.textView2) ;
//        String data = "";
//                try {
//                    JSONObject jsonRootObject = new JSONObject(JSON_STRING);
//                    JSONArray jsonArray = jsonRootObject.getJSONArray("Employee");
//                    for (int i=0; i<jsonArray.length(); i++)
//                    {
//                        JSONObject jsonObject = jsonArray.getJSONObject((i));
//                        int id = Integer.parseInt(jsonObject.optString("id").toString());
//                        String name = jsonObject.optString("name").toString();
//                        float salary = Float.parseFloat(jsonObject.optString("salary").toString());
//                        data += "Node"+i+" : id = "+ id + "\n Name = "+ name +"\n Salary "+ salary + "\n";
//                    }
//                    employeeName.setText(data);
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//    }
//}