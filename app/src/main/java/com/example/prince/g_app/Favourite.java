package com.example.prince.g_app;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.edit;
import static com.example.prince.g_app.R.id.view;

/**
 * Created by Prince on 13-04-2017.
 */

public class Favourite extends AppCompatActivity {
    public Favourite_adapter adapter;
    private ListView list;
    private DatabaseHandler dataBaseHandler;
    private static final String DB_NAME = "Gate.db";
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourite);
        dataBaseHandler = DatabaseHandler.getInstance(this, DB_NAME);
        final ArrayList<GateListItem> message_holder = new ArrayList<GateListItem>();
        list = (ListView) findViewById(R.id.list);
        list.setEmptyView(findViewById(android.R.id.empty));
        back=(ImageView)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        showgateDetails();




        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TextView textto=(TextView)view.findViewById(R.id.to);
                String top=textto.getText().toString();


                TextView textfav = (TextView) view.findViewById(R.id.to1);
                String link = textfav.getText().toString();
                String ID = link.substring(32, 43);
                Intent intent = new Intent(Favourite.this, MainActivity.class);
                intent.putExtra("KEY", ID);
                intent .putExtra("NAME",top);
                startActivity(intent);




            }
        });

    }

    private void showgateDetails() {

        final ArrayList<GateListItem> message_holder = new ArrayList<GateListItem>();
        message_holder.clear();
        final String query = "SELECT * FROM favourite";

        final Cursor c1 = DatabaseHandler.rawQuery(query);

        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    GateListItem gateListItems = new GateListItem();

                    gateListItems.setTopics(c1.getString(c1
                            .getColumnIndex("Topics")));
                    gateListItems.setLinks(c1.getString(c1
                            .getColumnIndex("Links")));

                    message_holder.add(gateListItems);
                } while (c1.moveToNext());
            }
        }
        c1.close();

        adapter = new Favourite_adapter(this, message_holder);
        list.setAdapter(adapter);

    }
}
