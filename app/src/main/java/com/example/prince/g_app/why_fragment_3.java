package com.example.prince.g_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Prince on 14-04-2017.
 */

public class why_fragment_3 extends Fragment {
    Button skip;
    TextView text6;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.why_fragment_3, null);
        text6=(TextView)v.findViewById(R.id.text6);

        text6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link="https://www.youtube.com/watch?v=olhZGC4t7Qg";
                String ID = link.substring(32, 43);
                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("KEY", ID);
                intent .putExtra("NAME","Benefits of Gate");

                startActivity(intent);
            }
        });

        return v;
    }
}
