package com.example.chapter3.homework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myViewHolder> {
    private Context context;
    private ArrayList<FriendsEntity> friendsEntityList;

    public RecyclerAdapter(Context context, ArrayList<FriendsEntity> friendsEntityList){
        this.context = context;
        this.friendsEntityList = friendsEntityList;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = View.inflate(context,R.layout.layout_friends,null);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        FriendsEntity data = friendsEntityList.get(position);
        holder.mFriendName.setText(data.FriendName);
        holder.mChatContent.setText(data.ChatContent);

    }

    @Override
    public int getItemCount() {
        return friendsEntityList.size();
    }
    static class myViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImg;
        private TextView mFriendName;
        private TextView mChatContent;

        public  myViewHolder(final View itemView) {
            super(itemView);
            mImg = (ImageView) itemView.findViewById(R.id.friend_img);
            mFriendName = (TextView) itemView.findViewById(R.id.friend_name);
            mChatContent = (TextView) itemView.findViewById(R.id.chat_content);
        }
    }


}
