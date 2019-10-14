package com.example.prince.g_app;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubePlayer;

import java.util.ArrayList;

import static android.R.id.list;
import static android.os.Build.ID;
import static com.example.prince.g_app.R.id.text;

public class Engg_math extends AppCompatActivity {
    private DatabaseHandler dataBaseHandler;
    public ListView lvGate;
    TextView t1,t2;
    ImageView back;
  //  public static ArrayList<GateListItem> Fav=new ArrayList<>();


    private static final String DB_NAME = "Gate.db";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engg_math);
        dataBaseHandler = DatabaseHandler.getInstance(this, DB_NAME);
        lvGate = (ListView) findViewById(R.id.lv);
        String table_name = getIntent().getStringExtra("TABLE NAME");
        Log.d("name  =" + table_name, "Hello  =" + table_name);

        back=(ImageView)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        showGateDetails(table_name);

    }
  /*  @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        menu.add(0, v.getId(), 0, "Add to Favourite");//groupId, itemId, order, title
    }*/
   /* @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Add to Favourite"){
            Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
            t1=(TextView)findViewById(R.id.topics);

            String one=t1.getText().toString();
            Intent in=new Intent(Engg_math.this,Favourite.class);
            in.putExtra("FAV",one);
            startActivity(in);

           *//* Intent intent=new Intent(Engg_math.this,Favourite.class);
            intent.putExtra("fav",)
            startActivity(intent);*//*

        }
      else{
            return false;
        }
        return true;
    }
*/

    private void showGateDetails(final String TableName) {

        final ArrayList<GateListItem> gateList = new ArrayList<GateListItem>();
        gateList.clear();
        final String query = "SELECT * FROM " + TableName;

        final Cursor c1 = DatabaseHandler.rawQuery(query);

        if (c1 != null && c1.getCount() != 0) {
            if (c1.moveToFirst()) {
                do {
                    GateListItem gateListItems = new GateListItem();

                    gateListItems.setTopics(c1.getString(c1
                            .getColumnIndex("Topics")));
                    gateListItems.setLinks(c1.getString(c1
                            .getColumnIndex("Links")));

                    gateList.add(gateListItems);
                } while (c1.moveToNext());
            }
        }
        c1.close();

        GateListAdapter gateListAdapter = new GateListAdapter(Engg_math.this, gateList);
        lvGate.setAdapter(gateListAdapter);

        lvGate.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        TextView tex=(TextView)view.findViewById(R.id.topics);
                        TextView text = (TextView) view.findViewById(R.id.links);

                        String insertQuery = "INSERT INTO recently VALUES('"
                                + tex.getText().toString() + "'," + "'"
                                + text.getText().toString() + "')";

                        DatabaseHandler.execute(insertQuery);


                        String top=tex.getText().toString();

                        String link = text.getText().toString();

                        String ID = link.substring(32, 43);
                        Intent intent = new Intent(Engg_math.this, MainActivity.class);
                        intent.putExtra("KEY", ID);
                        intent .putExtra("NAME",top);
                        startActivity(intent);
                    }
                }

        );
        lvGate.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


                t1=(TextView)view.findViewById(R.id.topics);
                t2=(TextView)view.findViewById(R.id.links);

              /*  String to = t1.getText().toString();
                String to1=t2.getText().toString();*/


                String insertQuery = "INSERT INTO favourite VALUES('"
                        + t1.getText().toString() + "'," + "'"
                        + t2.getText().toString() + "')";

                DatabaseHandler.execute(insertQuery);


                Toast.makeText(Engg_math.this,"Added to Favourite", Toast.LENGTH_LONG).show();


                return true;
            }

        });
    }



}