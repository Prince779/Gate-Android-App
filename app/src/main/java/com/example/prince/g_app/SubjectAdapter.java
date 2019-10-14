package com.example.prince.g_app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


import java.util.List;

/**
 * Created by Prince on 01-04-2017.
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {
    private Context context;
    private List<Subject> subjectlist;



    public SubjectAdapter(Context context, List<Subject> topicsList) {
        this.context=context;
        this.subjectlist=topicsList;
    }





        @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.subject_list_row, parent, false);


            return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Subject subject;
        subject=subjectlist.get(position);
        holder.subject.setText(subject.getSubject());

      //  holder.topic.setText(subject.getTopic());
        holder.image.setImageResource(subject.getImage());
        holder.total.setText(subject.getTotal());

        holder.itemid.setTag(subjectlist.get(position));



        Glide.with(context).load(subject.getImage()).into(holder.image);

        holder.itemid.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                holder.itemid.getTag();

                //   Toast.makeText(context,"Click"+topics.getSubject(),Toast.LENGTH_SHORT).show();

             switch (position)
             {
                 case 0:
                    // Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();
                 Intent math=new Intent(context,Engg_math.class);
                     math.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    math.putExtra("TABLE NAME","Algorithm");
                     context.startActivity(math);
                     break;
                 case 1:
                    // Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();

                     Intent Programming=new Intent(context,Engg_math.class);
                     Programming.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     Programming.putExtra("TABLE NAME","CompilerDesign");
                     context.startActivity(Programming);
                     break;

                 case 2:
                     //Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();

                     Intent coa=new Intent(context,Engg_math.class);
                     coa.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     coa.putExtra("TABLE NAME","coa");
                     context.startActivity(coa);
                     break;
                 case 3:
                     //Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();

                     Intent pda=new Intent(context,Engg_math.class);
                     pda.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     pda.putExtra("TABLE NAME","pds");
                     context.startActivity(pda);
                     break;
                 case 4:

                     //Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();

                     Intent dg=new Intent(context,Engg_math.class);
                     dg.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     dg.putExtra("TABLE NAME","ComputerNetwork");
                     context.startActivity(dg);
                     break;
                 case 5:
                     //Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();

                     Intent cn=new Intent(context,Engg_math.class);
                     cn.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     cn.putExtra("TABLE NAME","toc");
                     context.startActivity(cn);
                     break;
                 case 6:
                     //Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();

                     Intent db=new Intent(context,Engg_math.class);
                     db.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     db.putExtra("TABLE NAME","Databases");
                     context.startActivity(db);
                     break;
                 case 7:
                     //Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();

                     Intent dl=new Intent(context,Engg_math.class);
                     dl.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     dl.putExtra("TABLE NAME","Digitallogic");
                     context.startActivity(dl);
                     break;
                 case 8:
                     //Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();

                     Intent os=new Intent(context,Engg_math.class);
                     os.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     os.putExtra("TABLE NAME","Os");
                     context.startActivity(os);
                     break;
                 case 9:
                     //Toast.makeText(context, "1st", Toast.LENGTH_SHORT).show();

                     Intent em=new Intent(context,Engg_math.class);
                     em.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     em.putExtra("TABLE NAME","Enggmath");
                     context.startActivity(em);
                     break;
            }
            }
        });

    }

    @Override
    public int getItemCount() {
        return subjectlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
        private TextView subject, total;
        private ImageView image;
       // private ItemClickListener mListener;
        private RelativeLayout itemid;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.getContext();

            subject = (TextView) itemView.findViewById(R.id.subject);
           // topic = (TextView) itemView.findViewById(R.id.topic);
            image=(ImageView)itemView.findViewById(R.id.iv);
            total=(TextView)itemView.findViewById(R.id.total);
           // overflow = (ImageView) itemView.findViewById(R.id.overflow);
          // itemView.setOnClickListener(this);
            itemid=(RelativeLayout)itemView.findViewById(R.id.itemid);


        }


/*
        public void setClickListener(ItemClickListener listener) {
            this.mListener = listener;
        }
*/

        /*@Override
        public void onClick(View view) {
            mListener.onClickItem(getLayoutPosition());
        }*/

       /* public interface ItemClickListener {
            void onClickItem(int pos);
        }*/
    }


    }

