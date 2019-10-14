package com.example.prince.g_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

/**
 * Created by Prince on 17-04-2017.
 */

public class GateListAdapter extends BaseAdapter {
    Context context;
    ArrayList<GateListItem> gateList;
    LayoutInflater inflater;

    public GateListAdapter(Context context,
                           ArrayList<GateListItem> gateList) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.gateList = gateList;
    }

    @Override
    public int getCount() {

        return gateList.size();
    }

    @Override
    public Object getItem(int position) {

        return gateList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        GateListItem gateListItems = gateList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.gate_list_row, null);
            holder = new ViewHolder();
            holder.tvSlNo = (TextView) convertView.findViewById(R.id.topics);

            holder.tvFirstName = (TextView) convertView.findViewById(R.id.links);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvSlNo.setText(gateListItems.getTopics());
        holder.tvFirstName.setText(gateListItems.getLinks());

        return convertView;
    }

    static class ViewHolder {
        TextView tvSlNo, tvFirstName;

    }

}

