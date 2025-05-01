package com.ajaxspringboot2.notes;

import java.util.StringTokenizer;

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

    public int getIntDate() {
        if (date == null) { return 0;}
        else {
            try{
        String tempdate = date.replace(".", " ");
        Integer intdate = 0;
        StringTokenizer st = new StringTokenizer(tempdate);
        Integer i = 0;
        while (st.hasMoreTokens()) {
            String x = st.nextToken();
            Double mult = Math.pow(100, i.doubleValue());
            intdate += Integer.valueOf(x) * mult.intValue();
            i++;
        }
        return intdate;
    }
    catch (Exception ex) {
        return 0;
    }
    }
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