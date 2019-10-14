package com.example.prince.g_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Prince on 14-04-2017.
 */

public class V_P_fragment1 extends Fragment {
    Button skip;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.v_p_fragment1, null);
        //skip=(Button)v.findViewById(R.id.skip1);

        /*skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
       *//* Fragment myfragment = new Subjects_main();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame, myfragment);
        ft.commit();*//*
                Intent in=new Intent(getActivity(),Main_Window.class);
                startActivity(in);
            }});*/
        return v;
    }
}
