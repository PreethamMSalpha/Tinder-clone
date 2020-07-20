package com.pklabs.tinder;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pklabs.tinder.Chats.ChatObject;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> {

    private List<Messages> userMessagesList;
    private FirebaseAuth mAuth;
    private DatabaseReference userDatabaseRef;

    private  String currentUserId, matchId, chatId;

    public MessagesAdapter(List<Messages> userMessagesList, MessagesChatActivity messagesChatActivity){
        this.userMessagesList = userMessagesList;
    }



    public class MessageViewHolder extends RecyclerView.ViewHolder {
        public TextView mMessage;
        public LinearLayout mContainer;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            mMessage = (TextView) itemView.findViewById(R.id.message);
            mContainer = itemView.findViewById(R.id.container);

        }
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat, parent, false);
        mAuth = FirebaseAuth.getInstance();

        return new MessageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        String messageSenderId = mAuth.getCurrentUser().getUid();
        Messages messages = userMessagesList.get(position);
        //more lines are there

        currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        userDatabaseRef = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserId).child("connections").child("matches").child(matchId).child("chatId");

        holder.mMessage.setText(userMessagesList.get(position).getMessage());
        if (userMessagesList.get(position).getCurrentUser()){
            holder.mMessage.setGravity(Gravity.END);//end indicates left side message view
            holder.mMessage.setTextColor(Color.parseColor("#404040"));
            holder.mContainer.setBackgroundColor(Color.parseColor("#F4F4F4"));
        }else {
            holder.mMessage.setGravity(Gravity.START);//start indicates right side message view
            holder.mMessage.setTextColor(Color.parseColor("#FFFFFF"));
            holder.mContainer.setBackgroundColor(Color.parseColor("#2DB4C8"));
        }
    }

    @Override
    public int getItemCount() {

        return userMessagesList.size();
    }
}
