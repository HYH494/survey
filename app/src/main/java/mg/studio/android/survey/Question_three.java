package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Question_three extends AppCompatActivity {
    Button q3_next;
    String q3input;
    String[] inputArr;
    RadioButton q3_2G;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_three);
        q3_next = (Button)findViewById(R.id.q3_next);
        q3_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q3_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
        inputArr = getIntent().getStringArrayExtra("inputArr");
        q3_2G = (RadioButton) findViewById(R.id.q3_2G);
        q3input = q3_2G.getText().toString();
    }
    private RadioGroup.OnCheckedChangeListener RadioClick=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    RadioButton e = (RadioButton) findViewById(id);
                    q3input = e.getText().toString();
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q3_next:
                    Intent intent = new Intent(Question_three.this, Question_four.class);
                    intent.putExtra("inputArr", new String[]{inputArr[0], inputArr[1], q3input});//q1input,q2input
                    startActivity(intent);
            }
        }
    };
}
