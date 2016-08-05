package com.example.asad.callviewer;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Asad on 31-03-2016.
 */
public class CustomAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    String[] your_array_list;
    public CustomAdapter(Context context,String [] your_array_list)
    {
this.your_array_list=your_array_list;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return Second.count;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = inflater.inflate(R.layout.each_row, null);
        CardView cv=(CardView)rowView.findViewById(R.id.card_viewcustom);
            TextView textView= (TextView) rowView.findViewById(R.id.textview);
            textView.setText(your_array_list[Second.count-1-position]);
            return rowView;
    }
}
