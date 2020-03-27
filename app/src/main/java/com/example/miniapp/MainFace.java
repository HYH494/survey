package com.example.miniapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;


public class MainFace extends AppCompatActivity implements View.OnClickListener {

    RadioButton rb_main_mainface,rb_main_scan,rb_main_createquenair,rb_main_mine,
            rb_scan_main,rb_scan_scan,rb_scan_createquenair,rb_scan_mine,
            rb_createquenair_main,rb_createquenair_scan,rb_createquenair_createquenair,rb_createquenair_mine,
            rb_mine_main,rb_mine_scan,rb_mine_createquenair,rb_mine_mine;
    int rb_now = R.id.rb_main_mainface;  //用于记录目前所属的界面
    int rb_temp = 0;   //用于方便操作
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_face);
        setId();
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.rb_main_mainface | R.id.rb_scan_mainface | R.id.rb_createquenair_mainface | R.id.rb_mine_mainface:
                setContentView(R.layout.activity_main_face);
                break;
            case R.id.rb_main_scan | R.id.rb_scan_scan | R.id.rb_createquenair_scan | R.id.rb_mine_scan:
                setContentView(R.layout.activity_scan);
                break;
            case R.id.rb_main_create | R.id.rb_scan_create | R.id.rb_createquenair_create | R.id.rb_mine_create:
                setContentView(R.layout.activity_createquenair);
                break;
            case R.id.rb_main_mine | R.id.rb_scan_mine | R.id.rb_createquenair_mine | R.id.rb_mine_mine:
                setContentView(R.layout.activity_mine);
                break;
        }
    }

    private void setId(){
        rb_main_mainface = (RadioButton)findViewById(R.id.rb_main_mainface);
        rb_main_scan = (RadioButton)findViewById(R.id.rb_main_scan);
        rb_main_createquenair = (RadioButton)findViewById(R.id.rb_main_create);
        rb_main_mine = (RadioButton)findViewById(R.id.rb_main_mine);
        rb_main_mainface.setOnClickListener(this);
        rb_main_scan.setOnClickListener(this);
        rb_main_createquenair.setOnClickListener(this);
        rb_main_mine.setOnClickListener(this);

        rb_scan_main = (RadioButton)findViewById(R.id.rb_scan_mainface);
        rb_scan_scan = (RadioButton)findViewById(R.id.rb_scan_scan);
        rb_scan_createquenair = (RadioButton)findViewById(R.id.rb_scan_create);
        rb_scan_mine = (RadioButton)findViewById(R.id.rb_scan_mine);
        rb_scan_main.setOnClickListener(this);
        rb_scan_scan.setOnClickListener(this);
        rb_scan_createquenair.setOnClickListener(this);
        rb_scan_mine.setOnClickListener(this);

        rb_createquenair_main = (RadioButton)findViewById(R.id.rb_createquenair_mainface);
        rb_createquenair_scan = (RadioButton)findViewById(R.id.rb_createquenair_scan);
        rb_createquenair_createquenair = (RadioButton)findViewById(R.id.rb_createquenair_create);
        rb_createquenair_mine = (RadioButton)findViewById(R.id.rb_createquenair_mine);
        rb_createquenair_main.setOnClickListener(this);
        rb_createquenair_scan.setOnClickListener(this);
        rb_createquenair_createquenair.setOnClickListener(this);
        rb_createquenair_mine.setOnClickListener(this);

        rb_mine_main = (RadioButton)findViewById(R.id.rb_mine_mainface);
        rb_mine_scan = (RadioButton)findViewById(R.id.rb_mine_scan);
        rb_mine_createquenair = (RadioButton)findViewById(R.id.rb_mine_create);
        rb_mine_mine = (RadioButton)findViewById(R.id.rb_mine_mine);
        rb_mine_main.setOnClickListener(this);
        rb_mine_scan.setOnClickListener(this);
        rb_mine_createquenair.setOnClickListener(this);
        rb_mine_mine.setOnClickListener(this);
    }
}
