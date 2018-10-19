package main.java.app.models;

public class Message {

    private String text,sender,receiver;

    public Message() {
    }

    public Message(String sender,String receiver,String text) {
    	this.sender = sender;
        this.text = text;
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }
    
    public String getSender() {
    	return sender;
    }
    
    public String getReceiver() {
    	
    	return receiver;
    }

    public void setText(String text) {
        this.text = text;
    }
}