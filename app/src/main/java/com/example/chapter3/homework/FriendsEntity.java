package com.example.chapter3.homework;

import java.io.Serializable;

public class FriendsEntity implements Serializable {
    public String imgPath;
    public String FriendName;
    public String ChatContent;
    public FriendsEntity(){
    }

    public FriendsEntity(String imgPath, String FriendName, String ChatContent){
        this.imgPath = imgPath;
        this.FriendName = FriendName;
        this.ChatContent = ChatContent;
    }

    public String getImgPath(){
        return imgPath;
    }

    public void setImgPath(String imgPath){
        this.imgPath = imgPath;
    }
    public String getFriendName(){
        return FriendName;
    }
    public void setFriendName(String FriendName){
        this.FriendName = FriendName;
    }
    public String getChatContent(){
        return ChatContent;
    }
    public void setChatContent(String ChatContent){
        this.ChatContent = ChatContent;
    }
    @Override
    public String toString(){
        return "FriendsEntity{" +
                "imgPath='" + imgPath +'\'' +
                ", FriendName='" + FriendName + '\'' + ", ChatContent='" + ChatContent + '\'' + '}';
    }

}
