package com.example.ChanageColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout back;
    TextView layoutText;
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back = findViewById(R.id.back);
        layoutText = findViewById(R.id.hello_text);
        findViewById(R.id.hello_text).setVisibility(View.VISIBLE);
        findViewById(R.id.language_section).setVisibility(View.INVISIBLE);
        findViewById(R.id.color_setting).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView5).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
        findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
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
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
                return true;
            case R.id.setting:
                findViewById(R.id.hello_text).setVisibility(View.INVISIBLE);
                findViewById(R.id.language_section).setVisibility(View.VISIBLE);
                findViewById(R.id.color_setting).setVisibility(View.VISIBLE);
                findViewById(R.id.textView5).setVisibility(View.VISIBLE);
                findViewById(R.id.button).setVisibility(View.VISIBLE);
                findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public  void onAccept(View view){
        mProgressBar=findViewById(R.id.progressBar);
        mProgressBar.setProgress(i);
        mCountDownTimer=new CountDownTimer(5100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                mProgressBar.setProgress(i);
            }
            @Override
            public void onFinish() {
                i++;
                mProgressBar.setProgress(0);
                findViewById(R.id.hello_text).setVisibility(View.VISIBLE);
                findViewById(R.id.language_section).setVisibility(View.INVISIBLE);
                findViewById(R.id.color_setting).setVisibility(View.INVISIBLE);
                findViewById(R.id.textView5).setVisibility(View.INVISIBLE);
                findViewById(R.id.button).setVisibility(View.INVISIBLE);
                findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
                i=0;
            }
        };
        mCountDownTimer.start();

    }
}
