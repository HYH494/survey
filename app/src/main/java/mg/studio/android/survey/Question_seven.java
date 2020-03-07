package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Question_seven extends AppCompatActivity {
    Button q7_next;
    String[] inputArr;
    String q7input;
    RadioButton q7_iphone;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_seven);
        q7_next = (Button)findViewById(R.id.q7_next);
        q7_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q7_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
        inputArr = getIntent().getStringArrayExtra("inputArr");
        q7_iphone = (RadioButton) findViewById(R.id.q7_opuse12);
        q7input = q7_iphone.getText().toString();
    }
    private RadioGroup.OnCheckedChangeListener RadioClick=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    RadioButton e = (RadioButton) findViewById(id);
                    q7input = e.getText().toString();
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q7_next:
                    Intent intent = new Intent(Question_seven.this, Question_eight.class);
                    intent.putExtra("inputArr", new String[]{inputArr[0], inputArr[1],
                            inputArr[2], inputArr[3], inputArr[4], inputArr[5], q7input});
                    startActivity(intent);
            }
        }
    };
}
