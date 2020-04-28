package com.cmk.notekeeper;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NoteRecyclerAdapter mRecyclerAdapter;


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NoteActivity.class));

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

       //ctionBarDrawerToggle  toggle  = new ActionBarDrawerToggle(
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_notes, R.id.nav_courses, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
//        NavController navController = Navigation.findNavController(this, R.id.list_items);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
        initializeDisplayContent();

    }
    @Override
    protected void onResume() {
        super.onResume();
        //mAdapterNotes.notifyDataSetChanged();
        mRecyclerAdapter.notifyDataSetChanged();
    }

    private void initializeDisplayContent() {
////        final ListView listNotes = findViewById(R.id.list_notes);
////        //first thing is to get the list of notes
////        List<NoteInfo> notes = DataManager.getInstance().getNotes();
////        mAdapterNotes = new ArrayAdapter<>(this,
////                android.R.layout.simple_list_item_1,notes);
////        listNotes.setAdapter(mAdapterNotes);
////        listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Intent  intent = new Intent(NoteListActivity.this,NoteActivity.class);
////               // NoteInfo note = (NoteInfo)listNotes.getItemAtPosition(position);
////                intent.putExtra(NoteActivity.NOTE_POSITION,position);
////                startActivity(intent);
////
//
//            }
//        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<NoteInfo> notes = DataManager.getInstance().getNotes();
        mRecyclerAdapter = new NoteRecyclerAdapter(this,notes);
        recyclerView.setAdapter(mRecyclerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.list_items);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();


    }

    
}
