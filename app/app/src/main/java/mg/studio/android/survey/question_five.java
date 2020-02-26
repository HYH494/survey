package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class question_five extends AppCompatActivity {
    Button q5_next;
    int count = 0;
    CheckBox b1,b2,b3,b4,b5,b6,b7;
    int ct1 = 0,ct2 = 0,ct3 = 0,ct4 = 0,ct5 = 0,ct6 = 0,ct7 = 0,ct8 = 0;
    String[] inputArr;
    String q5input = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_five);
        q5_next = (Button)findViewById(R.id.q5_next);
        q5_next.setOnClickListener(ButtonClick);
        b1 = (CheckBox)findViewById(R.id.q5_businessfunc);
        b1.setOnClickListener(ButtonClick);
        b2 = (CheckBox)findViewById(R.id.q5_musicfunc);
        b2.setOnClickListener(ButtonClick);
        b3 = (CheckBox)findViewById(R.id.q5_gpsfunc);
        b3.setOnClickListener(ButtonClick);
        b4 = (CheckBox)findViewById(R.id.q5_gamefunc);
        b4.setOnClickListener(ButtonClick);
        b5 = (CheckBox)findViewById(R.id.q5_datafunc);
        b5.setOnClickListener(ButtonClick);
        b6 = (CheckBox)findViewById(R.id.q5_photofunc);
        b6.setOnClickListener(ButtonClick);
        b7 = (CheckBox)findViewById(R.id.q5_others);
        b7.setOnClickListener(ButtonClick);
        inputArr = getIntent().getStringArrayExtra("inputArr");
    }
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q5_businessfunc:
                    ct1 += 1;
                    if(ct1 % 2 == 1)
                    {
                        count += 1;
                        if(ct1 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q5_businessfunc);
                            if(q5input.length() != 0)
                                q5input = q5input + "、" + c.getText().toString();
                            else
                                q5input = q5input + c.getText().toString();
                        }
                    }
                    if(ct1 % 2 == 0 && ct1 != 0)
                        count -= 1;
                    break;
                case R.id.q5_gamefunc:
                    ct2 += 1;
                    if(ct2 % 2 == 1)
                    {
                        count += 1;
                        if(ct2 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q5_gamefunc);
                            if(q5input.length() != 0)
                                q5input = q5input + "、" + c.getText().toString();
                            else
                                q5input = q5input + c.getText().toString();
                        }
                    }
                    if(ct2 % 2 == 0 && ct2 != 0)
                        count -= 1;
                    break;
                case R.id.q5_gpsfunc:
                    ct3 += 1;
                    if(ct3 % 2 == 1)
                    {
                        count += 1;
                        if(ct3 == 1){
                            CheckBox c = (CheckBox)findViewById(R.id.q5_gpsfunc);
                            if(q5input.length() != 0)
                                q5input = q5input + "、" + c.getText().toString();
                            else
                                q5input = q5input + c.getText().toString();
                        }
                    }
                    if(ct3 % 2 == 0 && ct3 != 0)
                        count -= 1;
                    break;
                case R.id.q5_datafunc:
                    ct4 += 1;
                    if(ct4 % 2 == 1)
                    {
                        count += 1;
                        if(ct4 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q5_datafunc);
                            if(q5input.length() != 0)
                                q5input = q5input + "、" + c.getText().toString();
                            else
                                q5input = q5input + c.getText().toString();
                        }
                    }
                    if(ct4 % 2 == 0 && ct4 != 0)
                        count -= 1;
                    break;
                case R.id.q5_musicfunc:
                    ct5 += 1;
                    if(ct5 % 2 == 1)
                    {
                        count += 1;
                        if(ct5 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q5_musicfunc);
                            if(q5input.length() != 0)
                                q5input = q5input + "、" + c.getText().toString();
                            else
                                q5input = q5input + c.getText().toString();
                        }
                    }
                    if(ct5 % 2 == 0 && ct5 != 0)
                        count -= 1;
                    break;
                case R.id.q5_photofunc:
                    ct6 += 1;
                    if(ct6 % 2 == 1)
                    {
                        count += 1;
                        if(ct6 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q5_photofunc);
                            if(q5input.length() != 0)
                                q5input = q5input + "、" + c.getText().toString();
                            else
                                q5input = q5input + c.getText().toString();
                        }
                    }
                    if(ct6 % 2 == 0 && ct6 != 0)
                        count -= 1;
                    break;
                case R.id.q5_others:
                    ct7 += 1;
                    if(ct7 % 2 == 1)
                    {
                        count += 1;
                        if(ct7 == 1){
                            CheckBox c = (CheckBox) findViewById(R.id.q5_others);
                            if(q5input.length() != 0)
                                q5input = q5input + "、" + c.getText().toString();
                            else
                                q5input = q5input + c.getText().toString();
                        }
                    }
                    if(ct7 % 2 == 0 && ct7 != 0)
                        count -= 1;
                    break;
                case R.id.q5_next:
                    ct8 += 1;
                    if(ct8 > 0 && count > 0)
                    {
                        Intent intent = new Intent(question_five.this,question_six.class);
                        intent.putExtra("inputArr", new String[]{inputArr[0],inputArr[1],inputArr[2],inputArr[3],
                        q5input});
                        startActivity(intent);
                    }

            }
        }
    };
}
