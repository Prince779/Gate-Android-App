package com.example.prince.g_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Prince on 14-04-2017.
 */

public class why_fragment_1 extends Fragment {
    Button skip;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.why_fragment_1, null);
       /* TextView textView = (TextView)v.findViewById(R.id.text_view);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());*/

        return v;
    }
}
