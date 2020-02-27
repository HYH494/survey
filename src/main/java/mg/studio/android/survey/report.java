package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class report extends AppCompatActivity {
    String[] inputArr;
    TextView textview1,textview2,textview3,textview4,
            textview5,textview6,textview7,textview8,
            textview9,textview10,textview11,textview12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        inputArr = getIntent().getStringArrayExtra("inputArr");
        textview1 = (TextView)findViewById(R.id.q1_answer);
        textview2 = (TextView)findViewById(R.id.q2_answer);
        textview3 = (TextView)findViewById(R.id.q3_answer);
        textview4 = (TextView)findViewById(R.id.q4_answer);
        textview5 = (TextView)findViewById(R.id.q5_answer);
        textview6 = (TextView)findViewById(R.id.q6_answer);
        textview7 = (TextView)findViewById(R.id.q7_answer);
        textview8 = (TextView)findViewById(R.id.q8_answer);
        textview9 = (TextView)findViewById(R.id.q9_answer);
        textview10 = (TextView)findViewById(R.id.q10_answer);
        textview11 = (TextView)findViewById(R.id.q11_answer);
        textview12 = (TextView)findViewById(R.id.q12_answer);
        textview1.setText(textview1.getText().toString()+ inputArr[0]);
        textview2.setText(textview2.getText().toString()+ inputArr[1]);
        textview3.setText(textview3.getText().toString()+ inputArr[2]);
        textview4.setText(textview4.getText().toString()+ inputArr[3]);
        textview5.setText(textview5.getText().toString()+ inputArr[4]);
        textview6.setText(textview6.getText().toString()+ inputArr[5]);
        textview7.setText(textview7.getText().toString()+ inputArr[6]);
        textview8.setText(textview8.getText().toString()+ inputArr[7]);
        textview9.setText(textview9.getText().toString()+ inputArr[8]);
        textview10.setText(textview10.getText().toString()+ inputArr[9]);
        textview11.setText(textview11.getText().toString()+ inputArr[10]);
        textview12.setText(textview12.getText().toString()+ inputArr[11]);
        //String temp;
        //for(int i = 0;i<12;i++){
            //temp = textview[i].getText().toString()+ inputArr[i];
            //textview[i].setText(temp);
        //}
    }
}
