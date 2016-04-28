package com.example.yooyj.hw2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by yooyj on 2016-04-13.
 * This class is an adpater class that extends ArrayAdpater for expressing customized listView .
 * Receive raw data and show each list's icon & text.
 *
 */
public class MyAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    public MyAdapter(Context context, String[] value)
    {
        super(context,R.layout.listitem,value);
        this.context=context;
        this.values=value;
    }
    /*
    * GetView method is overriding method that connects information to each ListView's component(icon, text).
    * And return View expressing each list.
    * */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listitem,parent,false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView)rowView.findViewById(R.id.icon);
        textView.setText(values[position]);
        String s = values[position];
        if(s.equalsIgnoreCase("TimeTable"))
            imageView.setImageResource(R.drawable.time);
        if(s.equalsIgnoreCase("Tip"))
            imageView.setImageResource(R.drawable.tip);
        if(s.equalsIgnoreCase("Calculator"))
            imageView.setImageResource(R.drawable.cal);
        if(s.equalsIgnoreCase("Changed PW"))
            imageView.setImageResource(R.drawable.pw);
        return rowView;
    }
}
