package com.cmk.notekeeper;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataManagerTest {
    @Before
    public void setUp() throws  Exception{
        DataManager dm = DataManager.getInstance();
        dm.getNotes().clear();
        dm.initializeExampleNotes();

    }

    @Test
    public void createNewNote() throws Exception {
        final DataManager dm = DataManager.getInstance();
        final CourseInfo course = dm.getCourse("android_async");
        final String NoteTitle = "Test note title";
        final String NoteText = "This is the body text of my test note" ;

        int NoteIndex = dm.createNewNote();
        NoteInfo newNote = dm.getNotes().get(NoteIndex);
        newNote.setText(NoteText);
        newNote.setTitle(NoteTitle);
        newNote.setCourse(course);

        NoteInfo compareNote = dm.getNotes().get(NoteIndex);
        assertEquals(course,compareNote.getCourse());
        assertEquals(NoteTitle,compareNote.getTitle());
        assertEquals(NoteText,compareNote.getText());



    }
    @Test
    public void findSimilarNote()throws Exception{
        final DataManager dm = DataManager.getInstance();
        final  CourseInfo course = dm.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText1 = "This is the body text of my test note";
        final String noteText2 = "This is the body text for my second test note";

        int noteIndex1 = dm.createNewNote();
        NoteInfo newnote1 = dm.getNotes().get(noteIndex1);
        newnote1.setCourse(course);
        newnote1.setTitle(noteTitle);
        newnote1.setText(noteText1);

        int noteIndex2 = dm.createNewNote();
        NoteInfo newNote2 = dm.getNotes().get(noteIndex2);
        newNote2.setTitle(noteTitle);
        newNote2.setCourse(course);
        newNote2.setText(noteText2);

        int foundIndex1 = dm.findNote(newnote1);
        assertEquals(noteIndex1,foundIndex1);

        int foundIndex2 = dm.findNote(newNote2);
        assertEquals(noteIndex2,foundIndex2);
    }
}