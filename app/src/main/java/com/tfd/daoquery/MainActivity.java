package com.tfd.daoquery;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.tfd.daoquery.entity.DaoMaster;
import com.tfd.daoquery.entity.DaoSession;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.AbstractDaoMaster;
import com.tfd.daoquery.entity.*;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DaoSession daoSession;
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        noteDao = daoSession.getNoteDao();

        /**
         * Insert Data
         */
        Note note = new Note();
        note.setName("First Note");
        noteDao.insert(note);
        Log.d("DaoExample", "Inserted new note, ID: " + note.getId());

        /**
         * Query
         */
        List<Note> notes = noteDao.queryBuilder()
                .where(NoteDao.Properties.Repos.eq(0))
                .list();
        /**
         * Output Data
         */
        for(int i = 0 ; i < notes.size() ; i++){
            Log.d("Data", notes.get(i).getName());
        }
//        Log.d("Data","My first data" + notes);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}