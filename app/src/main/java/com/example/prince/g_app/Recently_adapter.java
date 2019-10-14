package com.example.prince.g_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.prince.g_app.R.id.recli;
import static com.example.prince.g_app.R.id.recto;
import static com.example.prince.g_app.R.id.to;
import static com.example.prince.g_app.R.id.to1;

/**
 * Created by Prince on 26-04-2017.
 */

public class Recently_adapter extends BaseAdapter {
    Context context;
    public ArrayList<GateListItem> message_holderr;
    LayoutInflater inflater;


    public Recently_adapter(Context context, ArrayList<GateListItem> message_holderr) {
        this.context=context;
        this.message_holderr=message_holderr;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {

        return message_holderr.size();
    }
    @Override
    public Object getItem(int position) {

        return message_holderr.get(position);
    }
    @Override
    public long getItemId(int position) {

        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;


        GateListItem gateListItems = message_holderr.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.rec_row, null, false);
            holder = new ViewHolder();

            holder.tore = (TextView) convertView.findViewById(recto);
            holder.toore = (TextView) convertView.findViewById(recli);


            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
            holder.tore.setText(gateListItems.getTopics());
            holder.toore.setText(gateListItems.getLinks());

        return convertView;
    }
    static class ViewHolder{
        TextView tore,toore;

    }

}
