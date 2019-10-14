package com.example.prince.g_app;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Prince on 13-04-2017.
 */

public class Recently_view extends AppCompatActivity {
    private ListView listt;
    public Recently_adapter madapter;
    ImageView back;



    private DatabaseHandler dataBaseHandler;
    private static final String DB_NAME = "Gate.db";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recently_view);
        dataBaseHandler = DatabaseHandler.getInstance(this, DB_NAME);
        final ArrayList<GateListItem> message_holderr = new ArrayList<GateListItem>();
        listt = (ListView) findViewById(R.id.listt);
        listt.setEmptyView(findViewById(android.R.id.empty));
        back=(ImageView)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        showgateDetailss();

        listt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                TextView texttop = (TextView) view.findViewById(R.id.recto);
                TextView textrec = (TextView) view.findViewById(R.id.recli);

                String top=texttop.getText().toString();
                String link = textrec.getText().toString();

                String ID = link.substring(32, 43);
                Intent intent = new Intent(Recently_view.this, MainActivity.class);
                intent.putExtra("KEY", ID);
                intent .putExtra("NAME",top);

                startActivity(intent);
            }
        });

            }
    private void showgateDetailss() {
        final ArrayList<GateListItem> message_holderr = new ArrayList<GateListItem>();
        message_holderr.clear();
        final String query = "SELECT * FROM recently";

        final Cursor c1 = DatabaseHandler.rawQuery(query);

        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    GateListItem gateListItems = new GateListItem();

                    gateListItems.setTopics(c1.getString(c1
                            .getColumnIndex("First")));
                    gateListItems.setLinks(c1.getString(c1
                            .getColumnIndex("Second")));

                    message_holderr.add(gateListItems);
                } while (c1.moveToNext());
            }
        }
        c1.close();


        madapter = new Recently_adapter(this, message_holderr);
        listt.setAdapter(madapter);

    }
}
