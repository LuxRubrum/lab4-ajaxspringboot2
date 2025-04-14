package com.ajaxspringboot2.notes;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpSession;

public class NoteList {
    private HttpSession session=null;
    private List<Note> notes =null;

    public NoteList(HttpSession session) {
        this.session = session;    
    }
    public NoteList(HttpSession session, int k) {
        this.session = session;    
        notes = (List<Note>)session.getAttribute("notes"); 
        if  (notes == null){         
            notes = new ArrayList();
            for(int i = 1; i <= k; i++){
                Note n = new Note();
                n.setId(i);
                n.setName("Название" +String.format("%d", i));
                n.setUser("Пользователь" + String.format("%d", i));
                n.setDate("01.01.2025");
                n.setTime("00:00");
                n.setContent("Lorem ipsum dolor sit amet");
                notes.add(n);
            }
            session.setAttribute("notes", notes);  
        }      
    }   

    public List<Note> getStTitlesFromDB(){
        notes = (List<Note>)session.getAttribute("notes");        
        return notes;
    }   

    public List<Note> getStTitlesFromDB(String name){
        notes = (List<Note>)session.getAttribute("notes");
        List<Note> listnotes = new ArrayList();
        for(int i = 0; i < notes.size(); i++){
            if (name.compareTo(notes.get(i).getName()) == 0){
                listnotes.add(notes.get(i));
            }        
        }
        return listnotes;
    }

    public int insertDB(String fname, String user, String date, String time, String content){
        notes = (List<Note>)session.getAttribute("notes"); 
        
        int max=0;        
        for(int j=0;j<notes.size();j++){
            if (max<notes.get(j).getId()){
                max=notes.get(j).getId();
            }
        }
        max++;    
        Note n=new Note();    
        n.setId(max);    
        n.setName(fname);   
        n.setUser(user);
        n.setDate(date);
        n.setTime(time);
        n.setContent(content);
        notes.add(n);
        session.setAttribute("notes", notes);
        return max;
    }
    public List<Note> getDeleteFromDB(int id){
        notes = (List<Note>)session.getAttribute("notes");        
        for(int i = 0; i < notes.size(); i++){
            if (notes.get(i).getId() == id){
                notes.remove(i);
                break; 
            }        
        }
        session.setAttribute("notes", notes);
        return notes;
    }   
    public List<Note> getUpdateFromDB(int id, String fname, String user, String date, String time, String content){
        notes = (List<Note>)session.getAttribute("notes");        
        for(int i = 0; i < notes.size(); i++){
            if (notes.get(i).getId() == id){
                notes.get(i).setName(fname);
                notes.get(i).setUser(user);
                notes.get(i).setDate(date);
                notes.get(i).setTime(time);
                notes.get(i).setContent(content);
                break; 
            }        
        }
        session.setAttribute("notes", notes);
        return notes;
    }   

}

