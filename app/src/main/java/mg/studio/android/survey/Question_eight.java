package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Question_eight extends AppCompatActivity {
    Button q8_next;
    String[] inputArr;
    String q8input;
    RadioButton q8_iphone;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_eight);
        q8_next = (Button)findViewById(R.id.q8_next);
        q8_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q8_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
        inputArr = getIntent().getStringArrayExtra("inputArr");
        q8_iphone = (RadioButton) findViewById(R.id.q8_iphone);
        q8input = q8_iphone.getText().toString();
    }
    private RadioGroup.OnCheckedChangeListener RadioClick=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    RadioButton e = (RadioButton) findViewById(id);
                    q8input = e.getText().toString();
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q8_next:
                    Intent intent = new Intent(Question_eight.this,Question_nine.class);
                    intent.putExtra("inputArr", new String[]{inputArr[0],inputArr[1],
                                inputArr[2],inputArr[3],inputArr[4],inputArr[5],inputArr[6],q8input});
                    startActivity(intent);

            }
        }
    };
}
