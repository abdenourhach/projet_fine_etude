package com.example.admin_firmly;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Handler;

import de.hdodenhof.circleimageview.CircleImageView;


public class myadapter03 extends FirebaseRecyclerAdapter<modle03,myadapter03.myviewholde>
{
    public myadapter03(@NonNull FirebaseRecyclerOptions<modle03> options)
    {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholde holder, final int position, @NonNull final modle03 modle03)
    {

        holder.name.setText(modle03.getName02());
        holder.course.setText(modle03.getAge02());
        holder.email.setText(modle03.getNombre_pere02());
        Glide.with(holder.img.getContext()).load(modle03.getPurl02()).into(holder.img);











        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus=DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.dialogcontent02))
                        .setExpanded(true,1100)
                        .create();

                View myView1=dialogPlus.getHolderView();
                final EditText purl02=myView1.findViewById(R.id.uimgurl02);
                final EditText name02=myView1.findViewById(R.id.uname02);
                final EditText age02=myView1.findViewById(R.id.ucourse02);
                final EditText nombre_pere02=myView1.findViewById(R.id.uemail02);
                Button submit=myView1.findViewById(R.id.usubmit02);

                purl02.setText(modle03.getPurl02());
                name02.setText(modle03.getName02());
                age02.setText(modle03.getAge02());
                nombre_pere02.setText(modle03.getNombre_pere02());

                dialogPlus.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map=new HashMap<>();
                        map.put("purl02",purl02.getText().toString());
                        map.put("name02",name02.getText().toString());
                        map.put("age02",age02.getText().toString());
                        map.put("nombre_pere02",nombre_pere02.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("mouadat")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });


            }
        });






        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.img.getContext());
                builder.setTitle("Delete Panel");
                builder.setMessage("Delete...?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("listvac")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });

    } // End of OnBindViewMethod

    @NonNull
    @Override
    public myviewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow03,parent,false);
        return new myviewholde(view);
    }



    class myviewholde extends RecyclerView.ViewHolder
    {
        CircleImageView img;
        ImageView edit,delete;
        TextView name,course,email;
        @SuppressLint("WrongViewCast")
        public myviewholde(@NonNull View itemView)
        {
            super(itemView);
            img=(CircleImageView) itemView.findViewById(R.id.img1);
            name=(TextView)itemView.findViewById(R.id.nametext);
            course=(TextView)itemView.findViewById(R.id.coursetext);
            email=(TextView)itemView.findViewById(R.id.emailtext);

            edit=(ImageView)itemView.findViewById(R.id.editicon);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);
        }
    }
}
