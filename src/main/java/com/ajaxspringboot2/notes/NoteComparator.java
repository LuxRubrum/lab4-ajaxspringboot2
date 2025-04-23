package com.ajaxspringboot2.notes;

import java.util.Comparator;

public class NoteComparator implements Comparator<Note> {
    @Override
    public int compare(Note note1, Note note2) {
        return note1.getIntDate() - note2.getIntDate();
    }
}
