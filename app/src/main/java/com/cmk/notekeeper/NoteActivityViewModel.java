package com.cmk.notekeeper;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class NoteActivityViewModel extends ViewModel {
    public static final String ORIGINAL_NOTE_COURESE_ID = "com.cmk.notekeeper.ORIGINAL_NOTE_COURESE_ID";
    public static final String ORIGINAL_NOTE_TITLE = "com.cmk.notekeeper.ORIGINAL_NOTE_TITLE";
    public static final String ORIGINAL_NOTE_TEXT = "com.cmk.notekeeper.ORIGINAL_NOTE_TEXT";


    //instance state field
    public String mOriginalNoteCourseId;
    public String mOriginalNoteTitle;
    public String mOriginalNoteText;
    public Boolean mIsNewlyCreated = true;


    public void saveState(Bundle outState) {
        outState.putString(ORIGINAL_NOTE_COURESE_ID, mOriginalNoteCourseId);
        outState.putString(ORIGINAL_NOTE_TITLE, mOriginalNoteTitle);
        outState.putString(ORIGINAL_NOTE_TEXT, mOriginalNoteText);
    }

    public void restoreState(Bundle inState) {
        mOriginalNoteCourseId = inState.getString(mOriginalNoteCourseId);
        mOriginalNoteTitle = inState.getString(mOriginalNoteTitle);
        mOriginalNoteText = inState.getString(mOriginalNoteText);
    }
}
