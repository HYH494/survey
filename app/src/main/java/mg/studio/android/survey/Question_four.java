package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Question_four extends AppCompatActivity {
    Button q4_next;
    CheckBox b1,b2,b3,b4,b5,b6,b7;
    int ct1 = 0,ct2 = 0,ct3 = 0,ct4 = 0,ct5 = 0,ct6 = 0,ct7 = 0,ct8 = 0;
    int count = 0;
    String[] inputArr;
    String q4input = "";
    //String[] temp = {""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_four);
        b1 = (CheckBox)findViewById(R.id.q4_businessfunc);
        b1.setOnClickListener(ButtonClick);
        b2 = (CheckBox)findViewById(R.id.q4_musicfunc);
        b2.setOnClickListener(ButtonClick);
        b3 = (CheckBox)findViewById(R.id.q4_gpsfunc);
        b3.setOnClickListener(ButtonClick);
        b4 = (CheckBox)findViewById(R.id.q4_gamefunc);
        b4.setOnClickListener(ButtonClick);
        b5 = (CheckBox)findViewById(R.id.q4_datafunc);
        b5.setOnClickListener(ButtonClick);
        b6 = (CheckBox)findViewById(R.id.q4_photofunc);
        b6.setOnClickListener(ButtonClick);
        b7 = (CheckBox)findViewById(R.id.q4_others);
        b7.setOnClickListener(ButtonClick);
        q4_next = (Button)findViewById(R.id.q4_next);
        q4_next.setOnClickListener(ButtonClick);
        inputArr = getIntent().getStringArrayExtra("inputArr");
    }
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q4_businessfunc:
                    ct1 += 1;
                    if(ct1 % 2 == 1)
                    {
                        count += 1;
                        if(ct1 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q4_businessfunc);
                            if(q4input.length() != 0)
                                q4input = q4input + "、" + c.getText().toString();
                            else
                                q4input = q4input + c.getText().toString();
                        }
                    }
                    if(ct1 % 2 == 0 && ct1 != 0)
                        count -= 1;
                    break;
                case R.id.q4_gamefunc:
                    ct2 += 1;
                    if(ct2 % 2 == 1)
                    {
                        count += 1;
                        if(ct2 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q4_gamefunc);
                            if(q4input.length() != 0)
                                q4input = q4input + "、" + c.getText().toString();
                            else
                                q4input = q4input + c.getText().toString();
                        }
                    }
                    if(ct2 % 2 == 0 && ct2 != 0)
                        count -= 1;
                    break;
                case R.id.q4_gpsfunc:
                    ct3 += 1;
                    if(ct3 % 2 == 1)
                    {
                        count += 1;
                        if(ct3 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q4_gpsfunc);
                            if(q4input.length() != 0)
                                q4input = q4input + "、" + c.getText().toString();
                            else
                                q4input = q4input + c.getText().toString();
                        }
                    }
                    if(ct3 % 2 == 0 && ct3 != 0)
                        count -= 1;
                    break;
                case R.id.q4_datafunc:
                    ct4 += 1;
                    if(ct4 % 2 == 1)
                    {
                        count += 1;
                        if(ct4 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q4_datafunc);
                            if(q4input.length() != 0)
                                q4input = q4input + "、" + c.getText().toString();
                            else
                                q4input = q4input + c.getText().toString();
                        }
                    }
                    if(ct4 % 2 == 0 && ct4 != 0)
                        count -= 1;
                    break;
                case R.id.q4_musicfunc:
                    ct5 += 1;
                    if(ct5 % 2 == 1)
                    {
                        count += 1;
                        if(ct5 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q4_musicfunc);
                            if(q4input.length() != 0)
                                q4input = q4input + "、" + c.getText().toString();
                            else
                                q4input = q4input + c.getText().toString();
                        }
                    }
                    if(ct5 % 2 == 0 && ct5 != 0)
                        count -= 1;
                    break;
                case R.id.q4_photofunc:
                    ct6 += 1;
                    if(ct6 % 2 == 1)
                    {
                        count += 1;
                        if(ct6 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q4_photofunc);
                            if(q4input.length() != 0)
                                q4input = q4input + "、" + c.getText().toString();
                            else
                                q4input = q4input + c.getText().toString();
                        }
                    }
                    if(ct6 % 2 == 0 && ct6 != 0)
                        count -= 1;
                    break;
                case R.id.q4_others:
                    ct7 += 1;
                    if(ct7 % 2 == 1)
                    {
                        count += 1;
                        if(ct7 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q4_others);
                            if(q4input.length() != 0)
                                q4input = q4input + "、" + c.getText().toString();
                            else
                                q4input = q4input + c.getText().toString();
                        }
                    }
                    if(ct7 % 2 == 0 && ct7 != 0)
                        count -= 1;
                    break;
                case R.id.q4_next:
                    ct8 += 1;
                    if(ct8 > 0 && count > 0)
                    {
                        Intent intent = new Intent(Question_four.this,Question_five.class);
                        intent.putExtra("inputArr", new String[]{inputArr[0],inputArr[1],inputArr[2],q4input});
                        startActivity(intent);
                    }
                    break;
            }
        }
    };
}
