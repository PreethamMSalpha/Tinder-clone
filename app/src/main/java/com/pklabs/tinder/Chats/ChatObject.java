package com.pklabs.tinder.Chats;

public class ChatObject {

    private String message;
    private Boolean currentUser;

    public ChatObject(String message,Boolean currentUser){
        this.message = message;
        this.currentUser = currentUser;
    }

    public String getMessage(){
        return message;
    }
    public void setMessage(String userId){
        this.message = message;
    }

    public Boolean getcurrentUser(){
        return currentUser;
    }
    public void setCurrentUser(Boolean currentUser){
        this.currentUser = currentUser;
    }

}
