package com.ajaxspringboot2.notes;

public class Note {
    private int id;    
    private String name;
    private String user;    
    private String date;
    private String time;
    private String content;

    public String getUser() {
        return user;
    }

    public void setUser(String User) {
        this.user = User;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public String getTime(){
    return time;
    }

    public void setTime(String Time) {
        this.time = Time;
    }

    public String getContent(){
        return content;
        }
    
    public void setContent(String Content) {
        this.content = Content;
    }

}