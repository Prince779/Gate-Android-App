package com.example.prince.g_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prince on 08-05-2017.
 */

public class Freq_adapter extends BaseAdapter {
     ArrayList<Freq_model> freqlist;
    Context context;
    public Freq_adapter(Context context, ArrayList<Freq_model> freqlist) {
        this.freqlist=freqlist;
        this.context=context;
    }

    @Override
    public int getCount() {
        return freqlist.size();
    }

    @Override
    public Object getItem(int position) {
        return freqlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Freq_model freq_item = freqlist.get(position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.freq_row, null);
            holder = new ViewHolder();
            holder.ques = (TextView) convertView.findViewById(R.id.ques);

            holder.ans = (TextView) convertView.findViewById(R.id.ans);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ques.setText(freq_item.getQuestion());
        holder.ans.setText(freq_item.getAnswer());



        return convertView;
    }
    static class ViewHolder {
        TextView ques, ans;

    }
}
