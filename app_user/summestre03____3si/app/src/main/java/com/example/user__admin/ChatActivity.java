package com.example.user__admin;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.admin_firmly.ModelClass.Messages;
import com.example.user__admin.Adapter.MessagesAdater;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;


public class ChatActivity extends AppCompatActivity {

    String ReciverImage, ReciverUID, ReciverName, SenderUID;
    CircleImageView profileImage;
    TextView reciverName;
    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;
    public static String sImage;
    public static String rImage;

    CardView sendBtn;
    EditText edtMessage;

    String senderRoom, reciverRoom;

    RecyclerView messageAdater;
    ArrayList<Messages> messagesArrayList;

    MessagesAdater adater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        database = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        ReciverName = getIntent().getStringExtra("name");
        ReciverImage = getIntent().getStringExtra("ReciverImage");
        ReciverUID = getIntent().getStringExtra("uid");

        messagesArrayList = new ArrayList<>();

        profileImage = findViewById(R.id.profile_image);
        reciverName = findViewById(R.id.reciverName);
        messageAdater = findViewById(R.id.messageAdater);

        messagesArrayList = new ArrayList<>();
        adater = new MessagesAdater(com.example.user__admin.ChatActivity.this, messagesArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        messageAdater.setLayoutManager(linearLayoutManager);
        messageAdater.setAdapter(adater);

        sendBtn = findViewById(R.id.sendBtn);
        edtMessage = findViewById(R.id.edtMessage);



        SenderUID = firebaseAuth.getUid();

        senderRoom = SenderUID + ReciverUID;
        reciverRoom = ReciverUID + SenderUID;


        DatabaseReference reference = database.getReference().child("user").child(Objects.requireNonNull(firebaseAuth.getUid()));
        DatabaseReference chatRefrece = database.getReference().child("chats").child(senderRoom).child("messages");




        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                sImage = Objects.requireNonNull(snapshot.child("imageUri").getValue()).toString();
                rImage = ReciverImage;

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        chatRefrece.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                messagesArrayList.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Messages messages = dataSnapshot.getValue(Messages.class);
                    messagesArrayList.add(messages);
                }
                adater.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        sendBtn.setOnClickListener(v -> {
            String message = edtMessage.getText().toString();
            if (message.isEmpty()) {
                Toast.makeText(ChatActivity.this, "Please enter Valid Message", Toast.LENGTH_SHORT).show();
                return;
            }
            edtMessage.setText("");
            Date date = new Date();

            Messages messages = new Messages(message, SenderUID, date.getTime());

            database.getReference().child("chats")
                    .child(senderRoom)
                    .child("messages")
                    .push()
                    .setValue(messages).addOnCompleteListener(task -> database.getReference().child("chats")
                            .child(reciverRoom)
                            .child("messages")
                            .push().setValue(messages).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                        }
                    }));

        });


    }
}