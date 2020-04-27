package com.example.ChanageColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout back;
    TextView layoutText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back = findViewById(R.id.back);
        layoutText = findViewById(R.id.hello_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                new AlertDialog.Builder(this)
                        .setTitle(R.string.dialog_title)
                        .setMessage(R.string.dialog_description)
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setIcon(android.R.drawable.ic_menu_myplaces)
                        .show();
                return true;
            case R.id.night_mode:
                if (item.isChecked()){
                    item.setChecked(false);
                    back.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    layoutText.setTextColor(Color.parseColor("#757575"));
                }
                else{
                    item.setChecked(true);
                    back.setBackgroundColor(Color.BLACK);
                    layoutText.setTextColor(Color.parseColor("#FFFFFF"));
                };
                return true;
            case R.id.exit:
                new AlertDialog.Builder(this)
                        .setTitle(R.string.danger)
                        .setMessage(R.string.danger_exit)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finishAffinity();
                                System.exit(0);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setIcon(android.R.drawable.stat_notify_error)
                        .show();
                return true;
            case R.id.setting:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
