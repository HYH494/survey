package mg.studio.android.survey;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class question_twelve extends AppCompatActivity {
    Button q12_next;
    int count = 0;
    String[] inputArr;
    String q12input;
    private  RadioGroup  radioGroup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_twelve);
        q12_next = (Button)findViewById(R.id.q12_next);
        q12_next.setOnClickListener(ButtonClick);
        radioGroup=(RadioGroup)findViewById(R.id.q12_radioGroupId);
        radioGroup.setOnCheckedChangeListener(RadioClick);
        inputArr = getIntent().getStringArrayExtra("inputArr");
    }

    private RadioGroup.OnCheckedChangeListener RadioClick=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id= group.getCheckedRadioButtonId();
            switch (group.getCheckedRadioButtonId()) {
                default:
                    count += 1;
                    RadioButton e = (RadioButton) findViewById(id);
                    q12input = e.getText().toString();
                    break;
            }
        }
    };
    OnClickListener ButtonClick = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.q12_next:
                    if(count > 0)
                    {
                        Intent intent = new Intent(question_twelve.this,finish.class);
                        intent.putExtra("inputArr", new String[]{inputArr[0],inputArr[1],
                                inputArr[2],inputArr[3],inputArr[4],inputArr[5],inputArr[6],
                                inputArr[7],inputArr[8],inputArr[9],inputArr[10],q12input});
                        startActivity(intent);
                    }
            }
        }
    };
}
