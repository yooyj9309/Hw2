
package com.example.yooyj.hw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by yooyj on 2016-04-13.
 * This activity is a role of showing each description activity.
 * If you click list, main activity sends list's title data to this activity.
 * So this activity gets the data and shows each description activity corresponding to the data although we implement only one xml.
 * If you click a button, it will execute the  corresponding app
 * And if calculator activity sends a calculating value to this activity,
 * this activity show the value to use toast message.
 *
 */
public class DescriptActivity extends Activity {

    private TextView tv1, tv2;
    private Button button;
    private String appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.describe);

        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        button=(Button)findViewById(R.id.button);
         Bundle bundle=getIntent().getExtras();   //previous activity sends app name data to this activity.
        appName=bundle.getString("name");
        if(appName.equalsIgnoreCase("Time"))
        {
            tv1.setText("Time Table");
            tv2.setText("Description : This is my lecture timetable!");
            button.setText("Run TimeTable");
        }
        if(appName.equalsIgnoreCase("Tip"))
        {
            tv1.setText("Tip calculator");
            tv2.setText("Description : Calculate your tip!");
            button.setText("Run TipCal");
        }
        if(appName.equalsIgnoreCase("Cal"))
        {
            tv1.setText("Calculator");
            tv2.setText("Description : Plus, Sub, Mult, Divide!");
            button.setText("Run Calculator");
        }
    }
/*
* This method : If you click a button, it shows activity corresponding app name.
* */
    public void onClickButton(View view)
    {
        if(appName.equalsIgnoreCase("Time"))
        {
            Intent intent = new Intent(getApplicationContext(),TimeActivity.class);
            startActivity(intent);
        }
        if(appName.equalsIgnoreCase("Tip"))
        {
            Intent intent = new Intent(getApplicationContext(),TipActivity.class);
            startActivity(intent);

        }
        if(appName.equalsIgnoreCase("Cal"))
        {
            Intent intent = new Intent(getApplicationContext(),CalActivity.class);
            startActivityForResult(intent, 222);
        }
    }
    /*
    * This method : If calculator activity sends a result data to this activity,
    * this activity gets a data and shows the result.
    * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == 222) {
                if (resultCode == Activity.RESULT_OK) {
                    Bundle mResult = data.getExtras();
                    String str=mResult.getString("value");
                    Toast.makeText(getApplicationContext(), "The value is = " + str, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
