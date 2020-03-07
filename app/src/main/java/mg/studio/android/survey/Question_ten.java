package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Question_ten extends AppCompatActivity {
    Button q10_next;
    String[] inputArr;
    String q10input;
    RadioButton q10_under18;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_ten);
        q10_next = (Button)findViewById(R.id.q10_next);
        q10_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q10_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
        inputArr = getIntent().getStringArrayExtra("inputArr");
        q10_under18 = (RadioButton) findViewById(R.id.q10_under18);
        q10input = q10_under18.getText().toString();
    }
    private RadioGroup.OnCheckedChangeListener RadioClick=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    RadioButton e = (RadioButton) findViewById(id);
                    q10input = e.getText().toString();
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q10_next:
                    Intent intent = new Intent(Question_ten.this, Question_eleven.class);
                    intent.putExtra("inputArr", new String[]{inputArr[0], inputArr[1],
                            inputArr[2], inputArr[3], inputArr[4], inputArr[5], inputArr[6],
                            inputArr[7], inputArr[8], q10input});
                    startActivity(intent);
            }
        }
    };
}