package com.example.ChanageColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RelativeLayout back;
    TextView layoutText;
    MenuItem about_developer;
    MenuItem setting_item;
    MenuItem night_mode_item;
    MenuItem exit_item;
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    RadioButton en;
    RadioButton fa;
    TextView language;
    TextView red;
    TextView green;
    TextView blue;
    TextView setting_background;
    Button confirm;
    String app_language;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back = findViewById(R.id.back);
        layoutText = findViewById(R.id.hello_text);
        en = findViewById(R.id.english);
        fa = findViewById(R.id.persian);
        language = findViewById(R.id.textView);
        red = findViewById(R.id.textView2);
        green = findViewById(R.id.textView3);
        blue = findViewById(R.id.textView4);
        setting_background = findViewById(R.id.textView5);
        confirm = findViewById(R.id.button);
        findViewById(R.id.hello_text).setVisibility(View.VISIBLE);
        findViewById(R.id.language_section).setVisibility(View.INVISIBLE);
        findViewById(R.id.color_setting).setVisibility(View.INVISIBLE);
        findViewById(R.id.textView5).setVisibility(View.INVISIBLE);
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
        findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
        app_language = "fa";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        about_developer = menu.findItem(R.id.about);
        setting_item = menu.findItem(R.id.setting);
        night_mode_item = menu.findItem(R.id.night_mode);
        exit_item = menu.findItem(R.id.exit);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                if (app_language == "fa"){
                    new AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_title)
                    .setMessage(R.string.dialog_description)
                    .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_menu_myplaces)
                    .show();
                }
                else if (app_language == "en"){
                    new AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_title_2)
                    .setMessage(R.string.dialog_description_2)
                    .setNegativeButton(R.string.ok_2, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_menu_myplaces)
                    .show();
                }
                return true;
            case R.id.night_mode:
                if (item.isChecked()){
                    item.setChecked(false);
                    back.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    layoutText.setTextColor(Color.parseColor("#757575"));
                    language.setTextColor(Color.BLACK);
                    fa.setTextColor(Color.BLACK);
                    en.setTextColor(Color.BLACK);
                    red.setTextColor(Color.parseColor("#757575"));
                    green.setTextColor(Color.parseColor("#757575"));
                    blue.setTextColor(Color.parseColor("#757575"));
                    setting_background.setTextColor(Color.parseColor("#757575"));
                    confirm.setTextColor(Color.BLACK);
                }
                else{
                    item.setChecked(true);
                    back.setBackgroundColor(Color.BLACK);
                    layoutText.setTextColor(Color.parseColor("#FFFFFF"));
                    language.setTextColor(Color.parseColor("#FFFFFF"));
                    fa.setTextColor(Color.parseColor("#FFFFFF"));
                    en.setTextColor(Color.parseColor("#FFFFFF"));
                    red.setTextColor(Color.parseColor("#FFFFFF"));
                    green.setTextColor(Color.parseColor("#FFFFFF"));
                    blue.setTextColor(Color.parseColor("#FFFFFF"));
                    setting_background.setTextColor(Color.parseColor("#FFFFFF"));
                    confirm.setTextColor(Color.parseColor("#FFFFFF"));
                };
                return true;
            case R.id.exit:
                if (app_language == "fa"){
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
                }
                else if (app_language == "en"){
                    new AlertDialog.Builder(this)
                    .setTitle(R.string.danger_2)
                    .setMessage(R.string.danger_exit_2)
                    .setPositiveButton(R.string.yes_2, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton(R.string.no_2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .show();
                }

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
                if (fa.isChecked()) {
                    layoutText.setText(R.string.startup_text);
                    about_developer.setTitle(R.string.about_us);
                    setting_item.setTitle(R.string.setting);
                    night_mode_item.setTitle(R.string.night_mode);
                    exit_item.setTitle(R.string.exit);
                    language.setText(R.string.language);
                    fa.setText(R.string.persian);
                    en.setText(R.string.english);
                    red.setText(R.string.red);
                    green.setText(R.string.green);
                    blue.setText(R.string.blue);
                    confirm.setText(R.string.ok_button);
                    setting_background.setText(R.string.background_color);
                    language.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                    app_language = "fa";
                }
                else if (en.isChecked()){
                    layoutText.setText(R.string.startup_text_2);
                    about_developer.setTitle(R.string.about_us_2);
                    setting_item.setTitle(R.string.setting_2);
                    night_mode_item.setTitle(R.string.night_mode_2);
                    exit_item.setTitle(R.string.exit_2);
                    language.setText(R.string.language_2);
                    fa.setText(R.string.persian_2);
                    en.setText(R.string.english_2);
                    red.setText(R.string.red_2);
                    green.setText(R.string.green_2);
                    blue.setText(R.string.blue_2);
                    confirm.setText(R.string.ok_button_2);
                    setting_background.setText(R.string.background_color_2);
                    language.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
                    app_language = "en";
                }
                i=0;
            }
        };
        mCountDownTimer.start();

    }
}
