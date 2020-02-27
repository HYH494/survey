package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class question_two extends AppCompatActivity {
    Button q2_next;
    int count = 0;
    String q1input,q2input;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_two);
        q2_next = (Button)findViewById(R.id.q2_next);
        q2_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q2_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
        Intent i = getIntent();
        q1input = i.getStringExtra("q1input");
    }

    private RadioGroup.OnCheckedChangeListener RadioClick=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    count += 1;
                    RadioButton e = (RadioButton) findViewById(group.getCheckedRadioButtonId());
                    q2input = e.getText().toString();
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q2_next:
                    if(count > 0)
                    {
                        Intent intent = new Intent(question_two.this,question_three.class);
                        //Bundle bundle = new Bundle();
                        //bundle.putStringArray("inputArr", new String[]{inputArr[0],inputArr[1]});
                        //intent.putExtras(bundle);
                        intent.putExtra("inputArr",new String[]{q1input,q2input});
                        startActivity(intent);
                    }

            }
        }
    };
}
