package com.example.ex022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * @author Tahel Hazan <th8887@bs.amalnet.k12.il>
 * @version	1.1.4
 * @since 09.12.2020
 * The credit page shows the author and ways to contact him in case something doesn't work.
 */
public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     * Btnp.
     *
     * @param item the item moves back to the buttons page.
     */
    public void btnp(MenuItem item) {
        finish();
    }

    /**
     * Cred.
     *
     * @param item the item Sends a Toast to let the user know he is in the current page
     *            he chose from the OptionMenu.
     */
    public void cred(MenuItem item) {
        Toast.makeText(this, "You are already here :)", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}