package com.example.yooyj.hw2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/*
* This activity shows ListView to user and if users click a list, show each description menu.
* And send a data what user click.
* */
public class MainActivity extends ListActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] values = new String[]{"TimeTable", "Tip", "Calculator","Changed PW"};
        MyAdapter adapter = new MyAdapter(this, values);
        setListAdapter(adapter);
    }
    /*
    * If user clicks a list, this method executes and this activity sends a data to description menu.
    * And pass each description activity.
    * */
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        if(position==0)
        {
            Intent intent = new Intent(getApplicationContext(),DescriptActivity.class);
            intent.putExtra("name","Time");
            startActivity(intent);
        }
        if(position==1)
        {
            Intent intent = new Intent(getApplicationContext(),DescriptActivity.class);
            intent.putExtra("name","Tip");
            startActivity(intent);
        }
        if(position==2)
        {
            Intent intent = new Intent(getApplicationContext(),DescriptActivity.class);
            intent.putExtra("name","Cal");
            startActivity(intent);
        }
        if(position==3)
        {
            Intent intent = new Intent(getApplicationContext(),ChangeActivity.class);
            startActivity(intent);
        }
    }

}
