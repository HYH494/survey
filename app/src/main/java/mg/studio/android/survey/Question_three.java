package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Question_three extends AppCompatActivity {
    Button q3_next;
    int count = 0;
    String q3input;//q1input,q2input,
    String[] inputArr;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_three);
        q3_next = (Button)findViewById(R.id.q3_next);
        q3_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q3_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
        //String[]
        inputArr = getIntent().getStringArrayExtra("inputArr");
        //q1input = inputArr[0];
        //q2input = inputArr[1];
    }
    private RadioGroup.OnCheckedChangeListener RadioClick=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    count += 1;
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
                    if(count > 0)
                    {
                        Intent intent = new Intent(Question_three.this,Question_four.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putStringArray("inputArr", new String[]{inputArr[0],inputArr[1],inputArr[2]});
                        //intent.putExtras(bundle);
                        intent.putExtra("inputArr", new String[]{inputArr[0],inputArr[1],q3input});//q1input,q2input
                        startActivity(intent);
                    }

            }
        }
    };
}
