package com.example.prince.g_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.prince.g_app.R.id.to;
import static com.example.prince.g_app.R.id.to1;

/**
 * Created by Prince on 26-04-2017.
 */

public class Favourite_adapter extends BaseAdapter {
    Context context;
    public ArrayList<GateListItem> message_holder;
    LayoutInflater inflater;


    public Favourite_adapter(Context context, ArrayList<GateListItem> message_holder) {
        this.context=context;
        this.message_holder=message_holder;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {

        return message_holder.size();
    }
    @Override
    public Object getItem(int position) {

        return message_holder.get(position);
    }
    @Override
    public long getItemId(int position) {

        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;


        GateListItem gateListItems = message_holder.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fav_row, null, false);
            holder = new ViewHolder();

            holder.to = (TextView) convertView.findViewById(to);
            holder.to1 = (TextView) convertView.findViewById(to1);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.to.setText(gateListItems.getTopics());
        holder.to1.setText(gateListItems.getLinks());

        return convertView;
    }
    static class ViewHolder{
        TextView to,to1;

    }

}
