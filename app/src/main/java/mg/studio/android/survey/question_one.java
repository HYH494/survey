package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Question_one extends AppCompatActivity {
    Button q1_next;
    int count = 0;
    String q1input = null;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_one);
        q1_next = (Button)findViewById(R.id.q1_next);
        q1_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q1_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
    }
    private OnCheckedChangeListener  RadioClick=new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    count += 1;
                    RadioButton e = (RadioButton) findViewById(id);
                    q1input = e.getText().toString();
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q1_next:
                    if(count > 0)
                    {
                        Intent intent = new Intent(Question_one.this,Question_two.class);
                        intent.putExtra("q1input",q1input);
                        startActivity(intent);
                    }

            }
        }
    };
}
