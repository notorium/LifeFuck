package com.example.lifefuck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private View cautionScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        cautionScreen = findViewById(R.id.caution_screen);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share_option:

                return true;
            case R.id.caution_option:
                showCaution();
                return true;
            case R.id.config_menu:
//                Intent intent = new Intent(getApplicationContext(), Config.class);
//                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showCaution() {
        cautionScreen.setVisibility(View.VISIBLE);
    }

    public void closeCaution(View v) {
        cautionScreen.setVisibility(View.GONE);
    }

    public void goWordsList(View v) {
        Intent intent = new Intent(getApplicationContext(), WordsListActivity.class);
        startActivity(intent);
    }
}