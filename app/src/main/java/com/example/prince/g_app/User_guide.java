package com.example.prince.g_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Prince on 13-04-2017.
 */

public class User_guide extends Fragment {
    TextView tv;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.user_guide,null);
        tv=(TextView)v.findViewById(R.id.tv);
        return v;
    }
}
