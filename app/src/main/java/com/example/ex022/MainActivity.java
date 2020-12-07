package com.example.ex022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author Tahel Hazan <th8887@bs.amalnet.k12.il>
 * @version	1.1.4
 * @since 09.12.2020
 * the user can press one of the buttons and an AlertDialog will show,
 * the user could change the back ground colors.
 * In the 4th and the 5th buttons the user can type text.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * @param bg = background.
     */
    LinearLayout bg;
    /**
     * Basic colors.
     */
    final String [] colors={"Red","Green","Blue"};
    /**
     * @param bad = Build Alert Dialog.
     */
    AlertDialog.Builder bad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bg=(LinearLayout) findViewById(R.id.bg);
    }

    /**
     * Basic Colors
     *
     * @param view The user can choose between the basic colors(blue,red and green) and it will change to the background color.
     */
    public void bc(View view) {
        bad= new AlertDialog.Builder(this);
        int [] color= new int[] {0,0,0};
        bad.setTitle("Basic Colors- One Choice");
        bad.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which]= 255;
                bg.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        bad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad= bad.create();
        ad.show();
    }

    /**
     * Mix Basic Colors
     *
     * @param view Adds basic colors together and puts them in the background. if the user chooses colors then deletes then, so none of the colors are chosen then the background color will be black.
     */
    public void mbc(View view) {
        bad= new AlertDialog.Builder(this);
        int [] color= new int[] {0,0,0};
        bad.setTitle("Adding colors together");
        bad.setMultiChoiceItems(colors, null, new DialogInterface.
                OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked)
                    color[which]= 255;
                else if(color[which]==255)
                        color[which]=0;
            }
        });
        bad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                bg.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        bad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad= bad.create();
        ad.show();
    }

    /**
     * Reset to(2) White
     *
     * @param view Reset the background to white.
     */
    public void r2w(View view) {
        bg.setBackgroundColor(Color.WHITE);
    }

    /**
     * Type and Show
     *
     * @param view The user can type information in and he'll see it through a toast.
     *            t= EditText to type info to.
     */
    public void ts(View view) {
        bad= new AlertDialog.Builder(this);
        bad.setCancelable(false);
        bad.setTitle("Type & Show:");
        final EditText t= new EditText(this);
        t.setHint("type text here");
        bad.setView(t);
        bad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String s= t.getText().toString();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
        bad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad= bad.create();
        ad.show();
    }

    /**
     * Double Type and Show
     *
     * @param view the user put his name and last name and he'll see if through a Toast.
     */
    public void dts(View view) {
        bad= new AlertDialog.Builder(this);
        bad.setCancelable(false);
        bad.setTitle("Double Type & Show:");
        final EditText name= new EditText(this);
        final EditText last_name= new EditText(this);
        name.setHint("Name:");
        last_name.setHint("Last Name:");
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(name);
        layout.addView(last_name);
        bad.setView(layout);
        bad.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String s1= name.getText().toString();
                String s2= last_name.getText().toString();
                Toast.makeText(MainActivity.this, s1+"   "+s2, Toast.LENGTH_SHORT).show();
            }
        });
        bad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad= bad.create();
        ad.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Btnp.
     *
     * @param item the item Sends a Toast to let the user know he is in the current page
     *             he chose from the OptionMenu.
     */
    public void btnp(MenuItem item) {
        Toast.makeText(this, "You are already here :)", Toast.LENGTH_SHORT).show();
    }

    /**
     * Cred.
     *
     * @param item the item Moves from main activity to Credits.
     */
    public void cred(MenuItem item) {
        Intent c= new Intent(this,Credits.class);
        startActivity(c);
    }
}