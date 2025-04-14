package com.ajaxspringboot2.ajaxspringboot2;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajaxspringboot2.notes.Note;
import com.ajaxspringboot2.notes.NoteList;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/api2")

public class NoteController {
    @RequestMapping(method = RequestMethod.GET,value = "getdata")
    public ResponseEntity<List<Note>> getdata (HttpSession session) {
                    
            NoteList notes = new NoteList(session, 3);
            List<Note> stList = notes.getStTitlesFromDB();
                
            HttpHeaders headers = new HttpHeaders();
            headers.add("contentType", "application/json");

            return new ResponseEntity<>(stList, headers, HttpStatus.OK);

    }
    
    @RequestMapping(method = RequestMethod.GET, value = "find")
    public ResponseEntity<List<Note>> getfind (HttpSession session, @RequestParam(value = "name", defaultValue = "") String name) {
        NoteList states = new NoteList(session);
        List<Note> stList;//=null;
        if (name.compareTo("")==0){
            stList = states.getStTitlesFromDB();
        }
        else{
            stList = states.getStTitlesFromDB(name);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("contentType", "application/json");

        return new ResponseEntity<>(stList, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST,value = "insert")
    public ResponseEntity<Note> insertDB (HttpSession session, @RequestParam(value = "fname", defaultValue = "") String fname,  
    @RequestParam(value = "user") String user, @RequestParam(value = "date") String date, @RequestParam(value = "time") String time, 
    @RequestParam(value = "content") String content) {
                   
        NoteList notes = new NoteList(session);
        Note n = new Note(); 
        int i;
        i = notes.insertDB(fname, user, date, time, content);
        HttpHeaders headers = new HttpHeaders();
        headers.add("contentType", "application/json");
        if (i != 0) {    
            return new ResponseEntity<>(n, headers, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(n, headers, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "delete")
    public ResponseEntity<List<Note>> deleteDB (HttpSession session, @RequestParam(value = "id", defaultValue = "") String id) {
        NoteList notes = new NoteList(session);
        List<Note> stList = notes.getDeleteFromDB(Integer.parseInt(id));
        HttpHeaders headers = new HttpHeaders();
        headers.add("contentType", "application/json");
        return new ResponseEntity<>(stList, headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "update")
    public ResponseEntity<List<Note>> updateDB (HttpSession session, @RequestParam(value = "id", defaultValue = "") String id, 
    @RequestParam(value = "fname", defaultValue = "") String fname, @RequestParam(value = "user") String user, @RequestParam(value = "date") String date, 
    @RequestParam(value = "time") String time,  @RequestParam(value = "content") String content) {
            NoteList notes = new NoteList(session);
            List<Note> stList = notes.getUpdateFromDB(Integer.parseInt(id), fname, user, date, time, content);
            HttpHeaders headers = new HttpHeaders();
            headers.add("contentType", "application/json");
            return new ResponseEntity<>(stList, headers, HttpStatus.OK);
    }

}
